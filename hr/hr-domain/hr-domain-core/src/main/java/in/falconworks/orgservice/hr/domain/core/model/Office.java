package in.falconworks.orgservice.hr.domain.core.model;

import in.falconworks.orgservice.domain.common.model.Address;
import in.falconworks.orgservice.domain.common.model.AggregateRoot;
import in.falconworks.orgservice.domain.common.model.OfficeId;
import in.falconworks.orgservice.hr.domain.core.event.ChildOfficeAddedEvent;
import in.falconworks.orgservice.hr.domain.core.event.OfficeCreatedEvent;
import in.falconworks.orgservice.hr.domain.core.event.PositionAddedEvent;
import in.falconworks.orgservice.hr.domain.core.exception.OfficeValidationException;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;


public class Office implements AggregateRoot{
   private final OfficeId officeId;
   private final String officeIdentifier;
   private final Address officeAddress;
   private final List<Position> positions;
   private final List<OfficeId> childOfficeIds;
   private OfficeId parentOfficeId;
   private final Logger logger = Logger.getLogger(getClass().getName());

   private Office(Builder builder) {
      this.officeId = builder.officeId;
      officeIdentifier = builder.officeIdentifier;
      officeAddress = builder.officeAddress;
      positions = new ArrayList<>();
      childOfficeIds = new ArrayList<>();
   }

   public OfficeCreatedEvent validateAndInitiate() {
      validate();
      return new OfficeCreatedEvent(getState());
   }

   public OfficeState getState() {
      return OfficeState.builder()
              .officeId(officeId)
              .officeIdentifier(officeIdentifier)
              .officeAddress(officeAddress)
              .positionIds(positions.stream().map(Position::getPositionId).toList())
              .childOfficeIds(childOfficeIds)
              .parentOfficeId(parentOfficeId)
              .build();
   }

   public PositionAddedEvent addNewPosition(Position newPosition) {
      positions.add(newPosition);
      PositionData data = PositionData.builder()
              .positionId(newPosition.getPositionId())
              .officeId(officeId)
              .positionIdentifier(newPosition.getPositionIdentifier())
              .positionDescription(newPosition.getPositionDescription())
              .isChairPosition(newPosition.isChairPosition())
              .build();
      return new PositionAddedEvent(data);
   }

   public ChildOfficeAddedEvent addChildOffice(OfficeId anOfficeId) {
      childOfficeIds.add(anOfficeId);
      return new ChildOfficeAddedEvent(new ChildOfficeData(officeId, anOfficeId));
   }

   public void setParentOfficeId(OfficeId anOfficeId) {
      this.parentOfficeId = anOfficeId;
   }

   private void validate() {
      if (officeId == null) {
         throw new OfficeValidationException("Office id can not be null");
      }
      logger.info("Validating office with id "+officeId.id());
      if (officeIdentifier == null || officeIdentifier.isBlank() || officeIdentifier.length() < 8) {
         throw new OfficeValidationException("Office identifier must a string with length at least 8 characters");
      }
      if (officeAddress == null) {
         throw new OfficeValidationException("Office must have a non null address");
      }
      if (!positions.isEmpty() && !(positions.stream().filter(Position::isChairPosition).toList().size() == 1)) {
         throw new OfficeValidationException("Office must have a single chair position");
      }
      logger.info("Office with id "+officeId.id()+" successfully validated");
   }

   public static Builder builder() {
      return new Builder();
   }

   public static final class Builder {
      private OfficeId officeId;
      private String officeIdentifier;
      private Address officeAddress;

      private Builder() {
      }

      public Builder officeId(OfficeId val) {
         officeId = val;
         return this;
      }

      public Builder officeIdentifier(String val) {
         officeIdentifier = val;
         return this;
      }

      public Builder officeAddress(Address val) {
         officeAddress = val;
         return this;
      }

      public Office build() {
         return new Office(this);
      }
   }

}

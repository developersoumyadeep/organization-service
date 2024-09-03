package in.falconworks.orgservice.domain.hr.model;

import in.falconworks.orgservice.domain.common.model.Address;
import in.falconworks.orgservice.domain.common.model.AggregateRoot;
import in.falconworks.orgservice.domain.common.model.OfficeId;

import java.util.List;
import java.util.Map;


public class OfficeAggregate implements AggregateRoot{
   private OfficeId officeId;
   private String officeIdentifier;
   private Address officeAddress;
   private List<Position> positions;
   private Map<OfficeId, OfficeAggregate> childOffices;
   private OfficeAggregate parentOffice;


}

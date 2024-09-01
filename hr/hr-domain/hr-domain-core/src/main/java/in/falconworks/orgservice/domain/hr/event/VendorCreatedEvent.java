package in.falconworks.orgservice.domain.hr.event;

import in.falconworks.orgservice.domain.common.event.DomainEvent;
import in.falconworks.orgservice.domain.hr.model.VendorState;

public class VendorCreatedEvent extends DomainEvent<VendorState> {

    public VendorCreatedEvent(VendorState value) {
        super(value);
    }
}

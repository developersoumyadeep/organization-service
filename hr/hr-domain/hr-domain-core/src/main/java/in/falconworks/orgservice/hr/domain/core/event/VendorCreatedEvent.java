package in.falconworks.orgservice.hr.domain.core.event;

import in.falconworks.orgservice.domain.common.event.DomainEvent;
import in.falconworks.orgservice.hr.domain.core.model.VendorState;

public class VendorCreatedEvent extends DomainEvent<VendorState> {

    public VendorCreatedEvent(VendorState value) {
        super(value);
    }
}

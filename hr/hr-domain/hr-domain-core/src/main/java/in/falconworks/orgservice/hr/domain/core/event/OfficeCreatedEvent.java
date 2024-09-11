package in.falconworks.orgservice.hr.domain.core.event;

import in.falconworks.orgservice.domain.common.event.DomainEvent;
import in.falconworks.orgservice.hr.domain.core.model.OfficeState;

public class OfficeCreatedEvent extends DomainEvent<OfficeState> {
    public OfficeCreatedEvent(OfficeState value) {
        super(value);
    }
}

package in.falconworks.orgservice.hr.domain.core.event;

import in.falconworks.orgservice.domain.common.event.DomainEvent;
import in.falconworks.orgservice.hr.domain.core.model.RegularEmployeeState;

public class RegularEmployeeCreatedEvent extends DomainEvent<RegularEmployeeState> {

    public RegularEmployeeCreatedEvent(RegularEmployeeState regularEmployeeState) {
        super(regularEmployeeState);
    }
}

package in.falconworks.orgservice.domain.hr.event;

import in.falconworks.orgservice.domain.common.event.DomainEvent;
import in.falconworks.orgservice.domain.hr.model.RegularEmployeeState;

public class RegularEmployeeCreatedEvent extends DomainEvent<RegularEmployeeState> {

    public RegularEmployeeCreatedEvent(RegularEmployeeState regularEmployeeState) {
        super(regularEmployeeState);
    }
}

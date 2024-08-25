package in.falconworks.orgservice.domain.hr.event;

import in.falconworks.orgservice.domain.common.event.DomainEvent;
import in.falconworks.orgservice.domain.hr.model.ReengagedEmployeeState;

public class ReengagedEmployeeCreatedEvent extends DomainEvent<ReengagedEmployeeState> {

    public ReengagedEmployeeCreatedEvent(ReengagedEmployeeState reengagedEmployeeState) {
        super(reengagedEmployeeState);
    }
}

package in.falconworks.orgservice.hr.domain.core.event;

import in.falconworks.orgservice.domain.common.event.DomainEvent;
import in.falconworks.orgservice.hr.domain.core.model.ReengagedEmployeeState;

public class ReengagedEmployeeCreatedEvent extends DomainEvent<ReengagedEmployeeState> {

    public ReengagedEmployeeCreatedEvent(ReengagedEmployeeState reengagedEmployeeState) {
        super(reengagedEmployeeState);
    }
}

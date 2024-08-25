package in.falconworks.orgservice.domain.hr.event;

import in.falconworks.orgservice.domain.common.event.DomainEvent;
import in.falconworks.orgservice.domain.hr.model.OutsourcedEmployeeState;

public class OutsourcedEmployeeCreatedEvent extends DomainEvent<OutsourcedEmployeeState> {

    public OutsourcedEmployeeCreatedEvent(OutsourcedEmployeeState outsourcedEmployeeState) {
        super(outsourcedEmployeeState);
    }
}

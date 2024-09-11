package in.falconworks.orgservice.hr.domain.core.event;

import in.falconworks.orgservice.domain.common.event.DomainEvent;
import in.falconworks.orgservice.hr.domain.core.model.OutsourcedEmployeeState;

public class OutsourcedEmployeeCreatedEvent extends DomainEvent<OutsourcedEmployeeState> {

    public OutsourcedEmployeeCreatedEvent(OutsourcedEmployeeState outsourcedEmployeeState) {
        super(outsourcedEmployeeState);
    }
}

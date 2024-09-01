package in.falconworks.orgservice.domain.hr.event;

import in.falconworks.orgservice.domain.common.event.DomainEvent;
import in.falconworks.orgservice.domain.hr.model.EmployeeRetirementData;

public class EmployeeRetiredEvent extends DomainEvent<EmployeeRetirementData> {

    public EmployeeRetiredEvent(EmployeeRetirementData value) {
        super(value);
    }
}

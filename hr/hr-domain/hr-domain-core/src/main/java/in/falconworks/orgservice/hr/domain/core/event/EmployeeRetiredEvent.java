package in.falconworks.orgservice.hr.domain.core.event;

import in.falconworks.orgservice.domain.common.event.DomainEvent;
import in.falconworks.orgservice.hr.domain.core.model.EmployeeRetirementData;

public class EmployeeRetiredEvent extends DomainEvent<EmployeeRetirementData> {

    public EmployeeRetiredEvent(EmployeeRetirementData value) {
        super(value);
    }
}

package in.falconworks.orgservice.domain.hr;

import in.falconworks.orgservice.domain.hr.event.OutsourcedEmployeeCreatedEvent;
import in.falconworks.orgservice.domain.hr.event.ReengagedEmployeeCreatedEvent;
import in.falconworks.orgservice.domain.hr.event.RegularEmployeeCreatedEvent;
import in.falconworks.orgservice.domain.hr.model.OutsourcedEmployeeAggregate;
import in.falconworks.orgservice.domain.hr.model.ReengageEmployeeAggregate;
import in.falconworks.orgservice.domain.hr.model.RegularEmployeeAggregate;

public interface HrDomainService {
    RegularEmployeeCreatedEvent validateNewRegularEmployee(RegularEmployeeAggregate regularEmployeeAggregate);
    ReengagedEmployeeCreatedEvent validateNewReengagedEmployee(ReengageEmployeeAggregate reengageEmployeeAggregate);
    OutsourcedEmployeeCreatedEvent validateNewOutsourcedEmployee(OutsourcedEmployeeAggregate outsourcedEmployeeAggregate);
}

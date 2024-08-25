package in.falconworks.orgservice.domain.hr;

import in.falconworks.orgservice.domain.hr.event.OutsourcedEmployeeCreatedEvent;
import in.falconworks.orgservice.domain.hr.event.ReengagedEmployeeCreatedEvent;
import in.falconworks.orgservice.domain.hr.event.RegularEmployeeCreatedEvent;
import in.falconworks.orgservice.domain.hr.model.OutsourcedEmployeeAggregate;
import in.falconworks.orgservice.domain.hr.model.ReengageEmployeeAggregate;
import in.falconworks.orgservice.domain.hr.model.RegularEmployeeAggregate;

public class HrDomainServiceImpl implements HrDomainService{

    @Override
    public RegularEmployeeCreatedEvent validateNewRegularEmployee(RegularEmployeeAggregate regularEmployeeAggregate) {
        regularEmployeeAggregate.validate();
        return new RegularEmployeeCreatedEvent(regularEmployeeAggregate.getState());
    }

    @Override
    public ReengagedEmployeeCreatedEvent validateNewReengagedEmployee(ReengageEmployeeAggregate reengageEmployeeAggregate) {
        reengageEmployeeAggregate.validate();
        return new ReengagedEmployeeCreatedEvent(reengageEmployeeAggregate.getState());
    }

    @Override
    public OutsourcedEmployeeCreatedEvent validateNewOutsourcedEmployee(OutsourcedEmployeeAggregate outsourcedEmployeeAggregate) {
        outsourcedEmployeeAggregate.validate();
        return new OutsourcedEmployeeCreatedEvent(outsourcedEmployeeAggregate.getState());
    }
}

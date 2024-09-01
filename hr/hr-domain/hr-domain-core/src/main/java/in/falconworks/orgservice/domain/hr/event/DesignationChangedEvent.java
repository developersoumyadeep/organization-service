package in.falconworks.orgservice.domain.hr.event;

import in.falconworks.orgservice.domain.common.event.DomainEvent;
import in.falconworks.orgservice.domain.hr.model.DesignationChangeData;

public class DesignationChangedEvent extends DomainEvent<DesignationChangeData> {

    public DesignationChangedEvent(DesignationChangeData value) {
        super(value);
    }
}

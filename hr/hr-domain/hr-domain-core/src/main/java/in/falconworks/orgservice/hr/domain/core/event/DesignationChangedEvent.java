package in.falconworks.orgservice.hr.domain.core.event;

import in.falconworks.orgservice.domain.common.event.DomainEvent;
import in.falconworks.orgservice.hr.domain.core.model.DesignationChangeData;

public class DesignationChangedEvent extends DomainEvent<DesignationChangeData> {

    public DesignationChangedEvent(DesignationChangeData value) {
        super(value);
    }
}

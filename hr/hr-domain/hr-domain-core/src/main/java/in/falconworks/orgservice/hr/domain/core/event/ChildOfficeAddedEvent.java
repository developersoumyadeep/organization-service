package in.falconworks.orgservice.hr.domain.core.event;

import in.falconworks.orgservice.domain.common.event.DomainEvent;
import in.falconworks.orgservice.hr.domain.core.model.ChildOfficeData;

public class ChildOfficeAddedEvent extends DomainEvent<ChildOfficeData> {
    public ChildOfficeAddedEvent(ChildOfficeData value) {
        super(value);
    }
}

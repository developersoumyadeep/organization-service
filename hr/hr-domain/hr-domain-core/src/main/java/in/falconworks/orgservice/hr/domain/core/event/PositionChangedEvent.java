package in.falconworks.orgservice.hr.domain.core.event;

import in.falconworks.orgservice.domain.common.event.DomainEvent;
import in.falconworks.orgservice.hr.domain.core.model.PositionChangeData;

public class PositionChangedEvent extends DomainEvent<PositionChangeData> {
    public PositionChangedEvent(PositionChangeData value) {
        super(value);
    }
}

package in.falconworks.orgservice.domain.hr.event;

import in.falconworks.orgservice.domain.common.event.DomainEvent;
import in.falconworks.orgservice.domain.hr.model.PositionChangeData;

public class PositionChangedEvent extends DomainEvent<PositionChangeData> {
    public PositionChangedEvent(PositionChangeData value) {
        super(value);
    }
}

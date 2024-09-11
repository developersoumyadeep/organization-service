package in.falconworks.orgservice.hr.domain.core.event;

import in.falconworks.orgservice.domain.common.event.DomainEvent;
import in.falconworks.orgservice.hr.domain.core.model.PositionData;

public class PositionAddedEvent extends DomainEvent<PositionData> {
    public PositionAddedEvent(PositionData value) {
        super(value);
    }
}

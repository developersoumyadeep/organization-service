package in.falconworks.orgservice.hr.domain.core.event;

import in.falconworks.orgservice.domain.common.event.DomainEvent;
import in.falconworks.orgservice.hr.domain.core.model.ContactDetailsChangeData;

public class MobileNumberChangedEvent extends DomainEvent<ContactDetailsChangeData> {

    public MobileNumberChangedEvent(ContactDetailsChangeData value) {
        super(value);
    }
}

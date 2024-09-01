package in.falconworks.orgservice.domain.hr.event;

import in.falconworks.orgservice.domain.common.event.DomainEvent;
import in.falconworks.orgservice.domain.hr.model.ContactDetailsChangeData;

public class MobileNumberChangedEvent extends DomainEvent<ContactDetailsChangeData> {

    public MobileNumberChangedEvent(ContactDetailsChangeData value) {
        super(value);
    }
}

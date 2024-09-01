package in.falconworks.orgservice.domain.hr.event;

import in.falconworks.orgservice.domain.common.event.DomainEvent;
import in.falconworks.orgservice.domain.hr.model.ContactDetailsChangeData;

public class EmailChangedEvent extends DomainEvent<ContactDetailsChangeData> {
    public EmailChangedEvent(ContactDetailsChangeData value) {
        super(value);
    }
}

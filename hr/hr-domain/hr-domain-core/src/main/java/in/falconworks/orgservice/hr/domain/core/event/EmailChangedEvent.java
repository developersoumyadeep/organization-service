package in.falconworks.orgservice.hr.domain.core.event;

import in.falconworks.orgservice.domain.common.event.DomainEvent;
import in.falconworks.orgservice.hr.domain.core.model.ContactDetailsChangeData;

public class EmailChangedEvent extends DomainEvent<ContactDetailsChangeData> {
    public EmailChangedEvent(ContactDetailsChangeData value) {
        super(value);
    }
}

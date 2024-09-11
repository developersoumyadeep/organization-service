package in.falconworks.orgservice.hr.domain.core.event;

import in.falconworks.orgservice.domain.common.event.DomainEvent;
import in.falconworks.orgservice.hr.domain.core.model.ContactDetailsChangeData;

public class AddressChangedEvent extends DomainEvent<ContactDetailsChangeData> {

    public AddressChangedEvent(ContactDetailsChangeData value) {
        super(value);
    }
}

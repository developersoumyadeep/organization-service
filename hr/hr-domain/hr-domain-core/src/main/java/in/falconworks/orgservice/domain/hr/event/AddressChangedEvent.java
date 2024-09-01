package in.falconworks.orgservice.domain.hr.event;

import in.falconworks.orgservice.domain.common.event.DomainEvent;
import in.falconworks.orgservice.domain.hr.model.ContactDetailsChangeData;

public class AddressChangedEvent extends DomainEvent<ContactDetailsChangeData> {

    public AddressChangedEvent(ContactDetailsChangeData value) {
        super(value);
    }
}

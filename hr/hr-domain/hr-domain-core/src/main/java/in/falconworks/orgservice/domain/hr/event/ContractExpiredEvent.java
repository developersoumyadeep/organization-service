package in.falconworks.orgservice.domain.hr.event;

import in.falconworks.orgservice.domain.common.event.DomainEvent;
import in.falconworks.orgservice.domain.hr.model.ContractExpiryData;

public class ContractExpiredEvent extends DomainEvent<ContractExpiryData> {
    public ContractExpiredEvent(ContractExpiryData value) {
        super(value);
    }
}

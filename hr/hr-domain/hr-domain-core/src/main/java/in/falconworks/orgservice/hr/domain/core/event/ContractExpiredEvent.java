package in.falconworks.orgservice.hr.domain.core.event;

import in.falconworks.orgservice.domain.common.event.DomainEvent;
import in.falconworks.orgservice.hr.domain.core.model.ContractExpiryData;

public class ContractExpiredEvent extends DomainEvent<ContractExpiryData> {
    public ContractExpiredEvent(ContractExpiryData value) {
        super(value);
    }
}

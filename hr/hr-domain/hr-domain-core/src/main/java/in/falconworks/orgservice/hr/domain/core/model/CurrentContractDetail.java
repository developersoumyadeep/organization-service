package in.falconworks.orgservice.hr.domain.core.model;

import java.time.LocalDate;

record CurrentContractDetail(LocalDate startDateOfCurrentContract, LocalDate dateOfCurrentContractExpiry) {
     static final int MAX_AGE_FOR_REENGAGEMENT_VALIDITY = 65;
     boolean contractExpired() {
          return LocalDate.now().isAfter(dateOfCurrentContractExpiry);
     }
}

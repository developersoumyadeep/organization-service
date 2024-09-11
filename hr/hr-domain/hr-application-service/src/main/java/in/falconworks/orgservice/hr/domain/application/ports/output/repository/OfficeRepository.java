package in.falconworks.orgservice.hr.domain.application.ports.output.repository;

import in.falconworks.orgservice.domain.common.model.OfficeId;
import in.falconworks.orgservice.hr.domain.core.model.Office;

import java.util.List;
import java.util.Optional;

public interface OfficeRepository {
    Office save(Office office);
    Optional<Office> findOfficeById(OfficeId officeId);
    List<Office> findChildOffices(OfficeId parentOfficeId);
}

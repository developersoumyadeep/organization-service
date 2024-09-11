package in.falconworks.orgservice.hr.domain.core.model;

import in.falconworks.orgservice.domain.common.model.OfficeId;

public record ChildOfficeData(OfficeId parentOfficeId, OfficeId childOfficeId) {}

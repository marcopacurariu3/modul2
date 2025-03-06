package com.modul2.learning.dto.validation;

import jakarta.validation.GroupSequence;

@GroupSequence({BasicInfo.class, AdvancedInfo.class})
public interface ValidationOrder {
}

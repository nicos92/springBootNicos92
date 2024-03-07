package com.nicosandoval.ArquitecturaHexagonal.domain.ports.out;

import com.nicosandoval.ArquitecturaHexagonal.domain.models.AdditionalTaskInfo;

public interface ExternalServicePort {
    AdditionalTaskInfo getAdditionalTaskInfo(Long taskId);
}

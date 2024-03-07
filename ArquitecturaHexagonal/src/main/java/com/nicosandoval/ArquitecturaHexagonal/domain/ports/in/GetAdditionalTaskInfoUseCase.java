package com.nicosandoval.ArquitecturaHexagonal.domain.ports.in;

import com.nicosandoval.ArquitecturaHexagonal.domain.models.AdditionalTaskInfo;

public interface GetAdditionalTaskInfoUseCase {
    AdditionalTaskInfo getAdditionalTaskInfo(Long id);
}

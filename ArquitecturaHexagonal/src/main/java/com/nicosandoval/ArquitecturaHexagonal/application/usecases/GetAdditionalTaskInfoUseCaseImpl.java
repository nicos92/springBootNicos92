package com.nicosandoval.ArquitecturaHexagonal.application.usecases;

import com.nicosandoval.ArquitecturaHexagonal.domain.models.AdditionalTaskInfo;
import com.nicosandoval.ArquitecturaHexagonal.domain.ports.in.GetAdditionalTaskInfoUseCase;
import com.nicosandoval.ArquitecturaHexagonal.domain.ports.out.ExternalServicePort;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GetAdditionalTaskInfoUseCaseImpl implements GetAdditionalTaskInfoUseCase {

    private final ExternalServicePort externalServicePort;
    @Override
    public AdditionalTaskInfo getAdditionalTaskInfo(Long id) {
        return externalServicePort.getAdditionalTaskInfo(id);
    }
}

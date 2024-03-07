package com.nicosandoval.ArquitecturaHexagonal.domain.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class Task {

    private Long id;
    private String title;
    private String description;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime creationDate;
    private boolean completed;

}

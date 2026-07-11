package com.fintech.backend.domain.dto;

import jakarta.validation.constraints.NotBlank;

public record MessageDTO(
    @NotBlank String id,
    @NotBlank String content
) {}
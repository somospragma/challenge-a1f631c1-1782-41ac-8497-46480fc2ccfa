package com.fintech.backend.domain.model;

import jakarta.validation.constraints.NotBlank;

public record Message(
    @NotBlank String id,
    @NotBlank String content
) {}
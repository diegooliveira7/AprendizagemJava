package com.example.springboot.dtos;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ProductRecordDto(@NotBlank String name, @NotNull BigDecimal value) {
    //@NotBlank siginifica que o nome n pode ser nulo e nem vázio
}

package com.example.springboot.dtos;
import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;

public record ProductRecordDto(@NotBlank String name, @NotBlank BigDecimal value) {
    //@NotBlank siginifica que o nome n pode ser nulo e nem vázio
}

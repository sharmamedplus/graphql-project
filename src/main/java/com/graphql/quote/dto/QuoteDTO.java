package com.graphql.quote.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.extern.jackson.Jacksonized;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class QuoteDTO {
    @NotNull(message = "Id cannot be null")
    private UUID id;
    private UUID[] orgs;

    @DecimalMin(value = "0.0", message = "Score must be between 0.0 and 1.0")
    @DecimalMin(value = "1.0", message = "Score must be between 0.0 and 1.0")
    @Builder.Default
    private Float score = 0.0f;

    private LocalDateTime created;
    private BigDecimal price;

    private Map<String, Object> attributes;
    private List<QuoteDTO.Subject> subjects;
    private List<QuoteNumber> quoteNumber;

    @Value
    @Builder(toBuilder = true)
    @Jacksonized
    public static class Subject {
        String name;
        String language;
    }

}

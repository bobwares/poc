package com.bobwares.poc.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@JsonDeserialize(builder = Purchase.PurchaseBuilder.class)
@Builder(builderClassName = "PurchaseBuilder", toBuilder = true)
public class  Purchase {
    private final LocalDateTime transactionDateTime;
    private final String customerId;
    private final int amount;

    @JsonPOJOBuilder(withPrefix = "")
    public static class PurchaseBuilder {}
}

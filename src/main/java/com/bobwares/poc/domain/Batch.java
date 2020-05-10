package com.bobwares.poc.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@JsonDeserialize(builder = Batch.PurchasesBuilder.class)
@Builder(builderClassName = "PurchasesBuilder", toBuilder = true)
public class Batch {
    private final List<Purchase> purchases;

    @JsonPOJOBuilder(withPrefix = "")
    public static class PurchasesBuilder {}
}

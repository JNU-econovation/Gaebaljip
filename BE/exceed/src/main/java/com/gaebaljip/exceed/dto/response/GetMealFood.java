package com.gaebaljip.exceed.dto.response;

import lombok.Builder;

import java.time.LocalTime;

public record GetMealFood(
        String foodName,
        String foodImageUri,
        LocalTime mealTime,
        String mealType
) {
    @Builder
    public GetMealFood {
    }
}

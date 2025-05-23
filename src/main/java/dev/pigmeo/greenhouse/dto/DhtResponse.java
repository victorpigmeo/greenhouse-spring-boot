package dev.pigmeo.greenhouse.dto;

import java.time.LocalDateTime;

public record DhtResponse(String id, Double temperature, Double humidity,
        Double heatIndex, LocalDateTime timestamp) {}

package dev.pigmeo.greenhouse.dto;

import java.time.LocalDateTime;

public record DhtReadsByTimestampRequest(LocalDateTime from, LocalDateTime to) {}

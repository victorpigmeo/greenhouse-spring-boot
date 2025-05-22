package dev.pigmeo.greenhouse.dto;

import java.time.Instant;

public record DhtReadsByTimestampRequest(Instant from, Instant to) {}

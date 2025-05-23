package dev.pigmeo.greenhouse.models;

import java.time.Instant;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Document(collection = "Dht")
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Dht {

    @Id
    private String id;
    private Double temperature;
    private Double humidity;
    private Double heatIndex;
    private Instant timestamp;
}

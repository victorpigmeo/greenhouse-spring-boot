package dev.pigmeo.greenhouse.models;

import java.time.Instant;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;

@Data
@Document(collection = "Dht")
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Dht {

    @Id
    private String id;
    private float temperature;
    private float humidity;
    private float heatIndex;
    private Instant timestamp;

    public static Dht fromJson(String body) {
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            return objectMapper.readValue(body, Dht.class);
        }catch(Exception e){
            throw new RuntimeException("Error parsing JSON: " + e.getMessage());
        }
    }}

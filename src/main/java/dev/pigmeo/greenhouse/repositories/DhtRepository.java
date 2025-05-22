package dev.pigmeo.greenhouse.repositories;

import java.time.Instant;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import dev.pigmeo.greenhouse.models.Dht;

public interface DhtRepository extends MongoRepository<Dht, String>{

    public List<Dht> findByTimestampBetween(Instant from, Instant to);
}

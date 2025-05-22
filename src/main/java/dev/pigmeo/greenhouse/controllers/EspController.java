package dev.pigmeo.greenhouse.controllers;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.pigmeo.greenhouse.dto.DhtReadsByTimestampRequest;
import dev.pigmeo.greenhouse.models.Dht;
import dev.pigmeo.greenhouse.repositories.DhtRepository;
import dev.pigmeo.greenhouse.services.EspService;


@RestController
@RequestMapping("/api")
public class EspController {

    @Autowired
    private EspService espService;
    @Autowired
    private DhtRepository dhtRepository;

    @GetMapping("/dht")
    public List<Dht> getDhtReadsByTimestamp(@RequestBody DhtReadsByTimestampRequest request) {
        return dhtRepository.findByTimestampBetween(request.from(), request.to());
    }
    
    @PostMapping("/dht")
    public Dht getTemperature() {
        Dht dht = espService.getDht();
        dht.setTimestamp(LocalDateTime.now().toInstant(ZoneOffset.UTC));

        dhtRepository.save(dht);

        return dht;
    }

    
}

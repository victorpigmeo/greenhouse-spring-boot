package dev.pigmeo.greenhouse.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.pigmeo.greenhouse.diplomat.EspHttpClient;
import dev.pigmeo.greenhouse.models.Dht;

@Service
public class EspServiceImpl implements EspService {

    @Autowired
    EspHttpClient espHttpClient;

    @Override
    public Dht getDht() {
        
        return espHttpClient.getDht();
    }
    
}

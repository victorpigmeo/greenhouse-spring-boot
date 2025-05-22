package dev.pigmeo.greenhouse.diplomat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import dev.pigmeo.greenhouse.config.EspServerConfig;
import dev.pigmeo.greenhouse.exception.EspServerException;
import dev.pigmeo.greenhouse.models.Dht;

@Component
public class EspHttpClientImpl implements EspHttpClient {

    @Autowired
    WebClient webClient;
    
    @Autowired
    EspServerConfig espServerConfig;

    @Override
    public Dht getDht(){
        return webClient.get()
                .uri(espServerConfig.getEndpointByKey("dht"))
                .exchangeToMono(response -> {
                    if (response.statusCode() == HttpStatus.OK) {
                        return response.bodyToMono(Dht.class);
                    } else {
                        throw new EspServerException("Error reaching the ESP", response.statusCode());
                    }
                }).block();
    }

}

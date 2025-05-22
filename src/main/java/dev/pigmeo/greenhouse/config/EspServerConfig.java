package dev.pigmeo.greenhouse.config;

import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "endpoints.esp-server")
public class EspServerConfig {

    private String url;
    private String port;
    private Map<String, String> endpoints;

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Map<String, String> getEndpoints() {
        return endpoints;
    }

    public void setEndpoints(Map<String, String> urls) {
        this.endpoints = urls;
    }

    public String getEndpointByKey(String endpointKey) {
        return getUrl() + "/" + endpoints.get(endpointKey);
    }
    
}

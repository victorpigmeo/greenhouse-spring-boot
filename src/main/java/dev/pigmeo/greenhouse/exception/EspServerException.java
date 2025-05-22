package dev.pigmeo.greenhouse.exception;

import org.springframework.http.HttpStatusCode;

public class EspServerException extends RuntimeException {
    private HttpStatusCode statusCode;

    public EspServerException(String message, HttpStatusCode statusCode) {
        super(message);
        this.statusCode = statusCode;
    }

    public HttpStatusCode getStatusCode() {
        return statusCode;
    }
}

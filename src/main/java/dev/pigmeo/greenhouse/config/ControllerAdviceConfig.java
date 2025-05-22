package dev.pigmeo.greenhouse.config;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import dev.pigmeo.greenhouse.exception.EspServerException;
import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControllerAdviceConfig {
    
    @ExceptionHandler(EspServerException.class)
    public ResponseEntity<String> handleException(HttpServletRequest req, EspServerException e) {
        // Log the exception (optional)
        System.err.println("ERROR: " + e.getMessage());
        
        // Return a generic error message
        return ResponseEntity
                .status(e.getStatusCode())
                .body("An error occurred while querying the ESP server.");
    }
}

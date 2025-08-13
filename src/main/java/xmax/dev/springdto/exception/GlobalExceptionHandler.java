package xmax.dev.springdto.exception;

import java.time.LocalDateTime;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import xmax.dev.springdto.dto.CreateBookRequestDto;

@RestControllerAdvice
public class ExceptionHandler {
    public ResponseEntity<Map<String, Object>> handleEntityNotFound(EntityNotFoundException exception) {
        return new ResponseEntity<>(
                Map.of(
                        "error", exception.getMessage()
                ),
                HttpStatus.NOT_FOUND
        );
    }
}

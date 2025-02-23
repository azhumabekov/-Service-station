package adi.servicestation.exception;

import lombok.Builder;
import org.springframework.http.HttpStatus;
@Builder
public record ExceptionResponse(
        HttpStatus status,
        String ExceptionClassName,
        String message
) {
}

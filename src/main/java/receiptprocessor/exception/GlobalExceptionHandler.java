package receiptprocessor.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ReceiptNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleReceiptNotFoundException(ReceiptNotFoundException ex) {
        Map<String, String> error = new HashMap<>();
        error.put("description", ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> error = new HashMap<>();
        error.put("description", "The receipt is invalid.");
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}

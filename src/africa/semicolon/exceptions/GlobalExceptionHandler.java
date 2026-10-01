package africa.semicolon.exceptions;

import africa.semicolon.dtos.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResidentDoesNotExistException.class)
    public ResponseEntity<ApiResponse> handleResidentDoesNotExist(ResidentDoesNotExistException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ApiResponse("error", e.getMessage(), null));
    }

    @ExceptionHandler(ResidentAlreadyRegisteredException.class)
    public ResponseEntity<ApiResponse> handleResidentAlreadyRegistered(ResidentAlreadyRegisteredException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(new ApiResponse("error", e.getMessage(), null));
    }

    @ExceptionHandler(ResidentSuspendedException.class)
    public ResponseEntity<ApiResponse> handleResidentSuspended(ResidentSuspendedException e) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN)
                .body(new ApiResponse("error", e.getMessage(), null));
    }

    @ExceptionHandler(GatePassDoesNotExistException.class)
    public ResponseEntity<ApiResponse> handleGatePassDoesNotExist(GatePassDoesNotExistException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ApiResponse("error", e.getMessage(), null));
    }

    @ExceptionHandler(GatePassOtpNotExistException.class)
    public ResponseEntity<ApiResponse> handleGatePassOtpNotExist(GatePassOtpNotExistException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ApiResponse("error", e.getMessage(), null));
    }

    @ExceptionHandler(InvalidGatePassException.class)
    public ResponseEntity<ApiResponse> handleInvalidGatePass(InvalidGatePassException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ApiResponse("error", e.getMessage(), null));
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ApiResponse> handleIllegalArgument(IllegalArgumentException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ApiResponse("error", e.getMessage(), null));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse> handleGenericException(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ApiResponse("error", e.getMessage(), null));
    }
}

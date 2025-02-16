package utils.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import utils.ApiResponse;

public class HtResponseEntity<T> extends ResponseEntity<ApiResponse<T>> {

    public HtResponseEntity(T data, boolean success, String message, HttpStatus status) {
        super(new ApiResponse<>(data, success, message), null, status);
    }

    public HtResponseEntity(T data) {
        super(new ApiResponse<>(data, true, "Success"), null, HttpStatus.OK);
    }

    public static <T> HtResponseEntity<T> success(T data, String message) {
        return new HtResponseEntity<>(data, true, message, HttpStatus.OK);
    }

    public static <T> HtResponseEntity<T> success(T data) {
        return new HtResponseEntity<>(data);
    }

    public static <T> HtResponseEntity<T> error(String message, HttpStatus status) {
        return new HtResponseEntity<>(null, false, message, status);
    }

    public static <T> HtResponseEntity<T> error(String message, String errorDetails, HttpStatus status) {
        return new HtResponseEntity<>(null, false, message, status, errorDetails);
    }

    private HtResponseEntity(T data, boolean success, String message, HttpStatus status, String errorDetails) {
        super(new ApiResponse<>(data, success, message, errorDetails), null, status);
    }
}
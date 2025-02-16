package utils;

public class ApiResponse<T> {
    private T data;
    private boolean success;
    private String message;
    private String errorDetails;

    public ApiResponse(T data, boolean success, String message) {
        this.data = data;
        this.success = success;
        this.message = message;
    }

    public ApiResponse(T data, boolean success, String message, String errorDetails) {
        this.data = data;
        this.success = success;
        this.message = message;
        this.errorDetails = errorDetails;
    }

    // Getters and setters
    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getErrorDetails() {
        return errorDetails;
    }

    public void setErrorDetails(String errorDetails) {
        this.errorDetails = errorDetails;
    }
}
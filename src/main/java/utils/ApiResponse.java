package utils;

public class ApiResponse<T> {
    private T content;
    private boolean success;
    private String message;
    private String errorDetails;

    public ApiResponse(T content, boolean success, String message) {
        this.content = content;
        this.success = success;
        this.message = message;
    }

    public ApiResponse(T content, boolean success, String message, String errorDetails) {
        this.content = content;
        this.success = success;
        this.message = message;
        this.errorDetails = errorDetails;
    }

    // Getters and setters
    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
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

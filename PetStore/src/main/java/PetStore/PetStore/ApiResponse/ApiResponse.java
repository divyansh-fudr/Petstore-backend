package PetStore.PetStore.ApiResponse;
//
//public class ApiResponse<T> {
//    private int statusCode;
//    private String message;
//    private T data;
//
//    public ApiResponse(int statusCode, String message, T data) {
//        this.statusCode = statusCode;
//        this.message = message;
//        this.data = data;
//    }
//
//    // Getters and Setters
//    public int getStatusCode() {
//        return statusCode;
//    }
//
//    public void setStatusCode(int statusCode) {
//        this.statusCode = statusCode;
//    }
//
//    public String getMessage() {
//        return message;
//    }
//
//    public void setMessage(String message) {
//        this.message = message;
//    }
//
//    public T getData() {
//        return data;
//    }
//
//    public void setData(T data) {
//        this.data = data;
//    }
//}
public class ApiResponse<T> {
    private int status;
    private String message;
    private T data;

    public ApiResponse(int status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    // Getters and Setters
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}


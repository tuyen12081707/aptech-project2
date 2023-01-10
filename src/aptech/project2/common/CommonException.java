package aptech.project2.common;


public class CommonException extends RuntimeException {

    private String message;

    public CommonException() {
    }

    public CommonException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "CommonException{" + "message=" + message + '}';
    }

}

package frontend.zanatciu.com.zanatciu.Utilities.BaseResponses;

public class BaseRes {

    private String message;
    private boolean result;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public BaseRes() {
    }

    public BaseRes(String message, boolean result) {
        this.message = message;
        this.result = result;
    }
}

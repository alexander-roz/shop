package shop.dto;

public class RequestTask {
    private boolean result;
    private String error;

    public RequestTask(boolean result){
        this.result = result;
    }

    public RequestTask(boolean result, String error){
        this.result = result;
        this.error = error;
    }
}

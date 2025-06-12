package receiptprocessor.model;

public class ProcessResponse {
    private String id;

    public ProcessResponse(String id) {
        this.id = id;
    }

    // Getter and Setter
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
}
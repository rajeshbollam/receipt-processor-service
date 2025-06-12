package receiptprocessor.model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import java.util.List;

public class Receipt {

    @NotBlank(message = "Retailer name is required.")
    @Pattern(regexp = "^[\\w\\s\\-&]+$", message = "Retailer name contains invalid characters.")
    private String retailer;

    @NotNull(message = "Purchase date is required.")
    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "Purchase date must be in YYYY-MM-DD format.")
    private String purchaseDate;

    @NotNull(message = "Purchase time is required.")
    @Pattern(regexp = "^\\d{2}:\\d{2}$", message = "Purchase time must be in HH:MM format.")
    private String purchaseTime;

    @NotEmpty(message = "Receipt must have at least one item.")
    @Valid
    private List<Item> items;

    @NotBlank(message = "Total is required.")
    @Pattern(regexp = "^\\d+\\.\\d{2}$", message = "Total must be in the format 'X.XX'.")
    private String total;

    // Getters and Setters
    public String getRetailer() { return retailer; }
    public void setRetailer(String retailer) { this.retailer = retailer; }
    public String getPurchaseDate() { return purchaseDate; }
    public void setPurchaseDate(String purchaseDate) { this.purchaseDate = purchaseDate; }
    public String getPurchaseTime() { return purchaseTime; }
    public void setPurchaseTime(String purchaseTime) { this.purchaseTime = purchaseTime; }
    public List<Item> getItems() { return items; }
    public void setItems(List<Item> items) { this.items = items; }
    public String getTotal() { return total; }
    public void setTotal(String total) { this.total = total; }
}

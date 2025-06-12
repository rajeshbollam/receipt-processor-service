package receiptprocessor.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class Item {

    @NotBlank(message = "Item description cannot be blank.")
    @Pattern(regexp = "^[\\w\\s\\-]+$", message = "Item description contains invalid characters.")
    private String shortDescription;

    @NotBlank(message = "Item price cannot be blank.")
    @Pattern(regexp = "^\\d+\\.\\d{2}$", message = "Price must be in the format 'X.XX'.")
    private String price;

    // Getters and Setters
    public String getShortDescription() { return shortDescription; }
    public void setShortDescription(String shortDescription) { this.shortDescription = shortDescription; }
    public String getPrice() { return price; }
    public void setPrice(String price) { this.price = price; }
}

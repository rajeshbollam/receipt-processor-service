package receiptprocessor.service;

import receiptprocessor.exception.ReceiptNotFoundException;
import receiptprocessor.model.Item;
import receiptprocessor.model.Receipt;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Service
public class ReceiptService {

    private final ConcurrentMap<String, Integer> pointsStore = new ConcurrentHashMap<>();
    private static final LocalTime FOURTEEN_HUNDRED = LocalTime.of(14, 0);
    private static final LocalTime SIXTEEN_HUNDRED = LocalTime.of(16, 0);

    public String processReceipt(Receipt receipt) {
        int points = calculatePoints(receipt);
        String id = UUID.randomUUID().toString();
        pointsStore.put(id, points);
        return id;
    }

    public int getPoints(String id) {
        Integer points = pointsStore.get(id);
        if (points == null) {
            throw new ReceiptNotFoundException("No receipt found for that ID.");
        }
        return points;
    }

    private int calculatePoints(Receipt receipt) {
        int totalPoints = 0;
        totalPoints += receipt.getRetailer().chars().filter(Character::isLetterOrDigit).count();
        double total = Double.parseDouble(receipt.getTotal());
        if (total == Math.floor(total)) { totalPoints += 50; }
        if (total % 0.25 == 0) { totalPoints += 25; }
        totalPoints += (receipt.getItems().size() / 2) * 5;
        for (Item item : receipt.getItems()) {
            if (item.getShortDescription().trim().length() % 3 == 0) {
                totalPoints += (int) Math.ceil(Double.parseDouble(item.getPrice()) * 0.2);
            }
        }
        if (LocalDate.parse(receipt.getPurchaseDate()).getDayOfMonth() % 2 != 0) { totalPoints += 6; }
        LocalTime purchaseTime = LocalTime.parse(receipt.getPurchaseTime());
        if (purchaseTime.isAfter(FOURTEEN_HUNDRED) && purchaseTime.isBefore(SIXTEEN_HUNDRED)) { totalPoints += 10; }
        return totalPoints;
    }
}

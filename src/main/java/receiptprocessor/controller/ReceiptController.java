package receiptprocessor.controller;

import receiptprocessor.model.PointsResponse;
import receiptprocessor.model.ProcessResponse;
import receiptprocessor.model.Receipt;
import receiptprocessor.service.ReceiptService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/receipts")
public class ReceiptController {

    private final ReceiptService receiptService;

    public ReceiptController(ReceiptService receiptService) {
        this.receiptService = receiptService;
    }

    @PostMapping("/process")
    public ResponseEntity<ProcessResponse> processReceipt(@Valid @RequestBody Receipt receipt) {
        String id = receiptService.processReceipt(receipt);
        return ResponseEntity.ok(new ProcessResponse(id));
    }

    @GetMapping("/{id}/points")
    public ResponseEntity<PointsResponse> getPoints(@PathVariable String id) {
        int points = receiptService.getPoints(id);
        return ResponseEntity.ok(new PointsResponse(points));
    }
}

package controller;
import entity.stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import repository.stockRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class stockcontroller{
    @Autowired
    private stockRepository stockRepository;

    @GetMapping("/stocks")
    public List<stock> getAllstocks() {
        return stockRepository.findAll();
    }

    @GetMapping("/stocks/{id}")
    public ResponseEntity<stock> getstockById(@PathVariable(value = "id") Long id_stock)
            throws ResourceNotFoundException {
        stock stock= stockRepository.findById(id_stock)
                .orElseThrow(() -> new ResourceNotFoundException("Stock not found for this id :: " +id_stock));
        return ResponseEntity.ok().body(stock);
    }

    @PostMapping("/stocks")
    public stock createstock(@Valid @RequestBody stock stock) {
        return stockRepository.save(stock);
    }

    @PutMapping("/stocks/{id}")
    public ResponseEntity<stock> updatestock(@PathVariable(value = "id") Long id_stock,
                                                      @Valid @RequestBody stock stockDetails) throws ResourceNotFoundException {
        stock stock = stockDetails.findById(id_stock)
                .orElseThrow(() -> new ResourceNotFoundException("stock not found for this id :: " + id_stock));

        stock.setId_stock(stockDetails.getId_stock());
        stock.setId_mat(stockDetails.getId_mat());
        stock.setQte_mat(stockDetails.getQte_mat());
        final stock updatedstock = stockDetails.save(stock);
        return ResponseEntity.ok(updatedstock);
    }

    @DeleteMapping("/stocks/{id}")
    public Map<String, Boolean> deletestock(@PathVariable(value = "id") Long id_stock)
            throws ResourceNotFoundException {
        stock stock = stockRepository.findById(id_stock)
                .orElseThrow(() -> new ResourceNotFoundException("stock not found for this id :: " + id_stock));

        stockRepository.delete(stock);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
}

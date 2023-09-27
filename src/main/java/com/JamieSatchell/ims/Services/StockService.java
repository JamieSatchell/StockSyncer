package com.JamieSatchell.ims.Services;

import com.JamieSatchell.ims.domain.Stock;
import com.JamieSatchell.ims.repositories.StockRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StockService {

    private final StockRepository stockRepository;

    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    public List<Stock> getAllStocks() {
        return stockRepository.findAll();
    }

    public Stock addStock(Stock stock) {
        return stockRepository.save(stock); // Saving the new stock instance to the database
    }


    public void deleteStockById(Long id) throws Exception {
        Optional<Stock> stockOptional = stockRepository.findById(id);
        if(stockOptional.isPresent()) {
            stockRepository.deleteById(id);
        } else {
            throw new Exception("Stock with id " + id + " not found.");
        }
    }
}

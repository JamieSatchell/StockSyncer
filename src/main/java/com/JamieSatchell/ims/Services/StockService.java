package com.JamieSatchell.ims.Services;

import com.JamieSatchell.ims.domain.Location;
import com.JamieSatchell.ims.domain.Product;
import com.JamieSatchell.ims.domain.Stock;
import com.JamieSatchell.ims.repositories.ProductRepository;
import com.JamieSatchell.ims.repositories.StockRepository;
import com.JamieSatchell.ims.repositories.LocationRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class StockService {
    private final StockRepository stockRepository;
    private final ProductRepository productRepository; // Added instance of ProductRepository
    private final LocationRepository locationRepository; // Added instance of LocationRepository
    public StockService(StockRepository stockRepository, ProductRepository productRepository, LocationRepository locationRepository) {
        this.stockRepository = stockRepository;
        this.productRepository = productRepository; // Initialize ProductRepository
        this.locationRepository = locationRepository; // Initialize LocationRepository
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
            Stock stock = stockOptional.get();
            // Remove the stock reference from the related Product and save it
            Product relatedProduct = stock.getProduct();
            if (relatedProduct != null) {
                relatedProduct.removeStock(stock); // assuming you have a removeStock method in your Product class
                productRepository.save(relatedProduct); // Corrected to use instance variable
            }
            // Remove the stock reference from the related Location and save it
            Location relatedLocation = stock.getLocation();
            if (relatedLocation != null) {
                relatedLocation.removeStock(stock); // assuming you have a removeStock method in your Location class
                locationRepository.save(relatedLocation); // Corrected to use instance variable
            }
            stockRepository.deleteById(id);
        } else {
            throw new Exception("Stock with id " + id + " not found.");
        }
    }
}

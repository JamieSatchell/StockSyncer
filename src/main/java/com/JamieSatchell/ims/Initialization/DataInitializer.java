package com.JamieSatchell.ims.Initialization;

import com.JamieSatchell.ims.domain.Category;
import com.JamieSatchell.ims.domain.Location;
import com.JamieSatchell.ims.domain.Product;
import com.JamieSatchell.ims.domain.Stock;
import com.JamieSatchell.ims.repositories.CategoryRepository;
import com.JamieSatchell.ims.repositories.LocationRepository;
import com.JamieSatchell.ims.repositories.ProductRepository;
import com.JamieSatchell.ims.repositories.StockRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final LocationRepository locationRepository;
    private final ProductRepository productRepository;
    private final StockRepository stockRepository;

    // Constructor Injection
    public DataInitializer(
            CategoryRepository categoryRepository,
            LocationRepository locationRepository,
            ProductRepository productRepository,
            StockRepository stockRepository) {
        this.categoryRepository = categoryRepository;
        this.locationRepository = locationRepository;
        this.productRepository = productRepository;
        this.stockRepository = stockRepository;
    }

    @Override
    public void run(String... args) {
        // Create some sample categories
        Category fruits = new Category();
        fruits.setName("Fruits");
        categoryRepository.save(fruits);

        Category electronics = new Category();
        electronics.setName("Electronics");
        categoryRepository.save(electronics);

        // Create some sample locations
        Location warehouse = new Location();
        warehouse.setName("Warehouse");
        warehouse.setAddress("123 Main St");
        locationRepository.save(warehouse);

        Location store = new Location();
        store.setName("Store");
        store.setAddress("456 Market St");
        locationRepository.save(store);

        // Create some sample products
        Product apple = new Product();
        apple.setName("Apple");
        apple.setPrice(1.0);
        apple.setCategory(fruits);
        productRepository.save(apple);

        Product laptop = new Product();
        laptop.setName("Laptop");
        laptop.setPrice(1000.0);
        laptop.setCategory(electronics);
        productRepository.save(laptop);

        // Create some sample stock items
        Stock warehouseStock = new Stock();
        warehouseStock.setLocation(warehouse);
        warehouseStock.setQuantity(100);
        stockRepository.save(warehouseStock);

        Stock storeStock = new Stock();
        storeStock.setLocation(store);
        storeStock.setQuantity(20);
        stockRepository.save(storeStock);
    }
}

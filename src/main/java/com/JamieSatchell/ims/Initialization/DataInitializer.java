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

        // Create some sample locations
        Location warehouse = new Location();
        warehouse.setName("Warehouse");
        warehouse.setAddress("123 Main St");
        locationRepository.save(warehouse);

        Location store = new Location();
        store.setName("Store");
        store.setAddress("456 Market St");
        locationRepository.save(store);




        // Create some sample stock items
        Stock appleStock = new Stock();
        appleStock.setLocationTEST(warehouse);
        appleStock.setQuantity(100);


        Stock laptopStock = new Stock();
        laptopStock.setLocationTEST(store);
        laptopStock.setQuantity(20);

        Stock testStock = new Stock();
        testStock.setLocationTEST(store);
        testStock.setQuantity(88);

        Stock plsWork = new Stock();
        plsWork.setLocationTEST(store);
        plsWork.setQuantity(12);




        // Create some sample categories
        Category fruits = new Category();
        fruits.setName("Fruits");
        categoryRepository.save(fruits);

        Category electronics = new Category();
        electronics.setName("Electronics");
        categoryRepository.save(electronics);



        // Create some sample products
        Product apple = new Product();
        apple.setName("Apple");
        apple.setPrice(1.0);
        apple.setCategory(fruits);
        apple.addStock(appleStock);
        apple.addStock(testStock);
        apple.addStock(plsWork);
        productRepository.save(apple);

        System.out.println("PINEAPPLE: -----"+apple.getStock().get(0).getQuantity());

        Product laptop = new Product();
        laptop.setName("Laptop");
        laptop.setPrice(1000.0);
        laptop.setCategory(electronics);
        laptop.addStock(laptopStock);
        productRepository.save(laptop);



        stockRepository.save(appleStock);
        stockRepository.save(laptopStock);
        stockRepository.save(testStock);
        stockRepository.save(plsWork);

    }
}

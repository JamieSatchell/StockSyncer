package com.JamieSatchell.ims.initializer

import com.JamieSatchell.ims.domain.Category
import com.JamieSatchell.ims.domain.Location
import com.JamieSatchell.ims.domain.Product
import com.JamieSatchell.ims.domain.Stock
import com.JamieSatchell.ims.repository.CategoryRepository
import com.JamieSatchell.ims.repository.LocationRepository
import com.JamieSatchell.ims.repository.ProductRepository
import com.JamieSatchell.ims.repository.StockRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class DataInitializer(
        private val categoryRepository: CategoryRepository,
        private val locationRepository: LocationRepository,
        private val productRepository: ProductRepository,
        private val stockRepository: StockRepository
) : CommandLineRunner {

    override fun run(vararg args: String?) {
        // Create some sample categories
        val fruits = categoryRepository.save(Category(name = "Fruits"))
        val electronics = categoryRepository.save(Category(name = "Electronics"))

        // Create some sample locations
        val warehouse = locationRepository.save(Location(name = "Warehouse", address = "123 Main St"))
        val store = locationRepository.save(Location(name = "Store", address = "456 Market St"))

        // Create some sample products
        val apple = productRepository.save(Product(name = "Apple", price = 1.0, category = fruits))
        val laptop = productRepository.save(Product(name = "Laptop", price = 1000.0, category = electronics))

        // Create some sample stock items
        stockRepository.save(Stock(location = warehouse, quantity = 100))
        stockRepository.save(Stock(location = store, quantity = 20))
    }
}

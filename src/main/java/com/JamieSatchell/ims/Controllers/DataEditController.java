package com.JamieSatchell.ims.Controllers;

import com.JamieSatchell.ims.Services.*;
import com.JamieSatchell.ims.domain.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/dataedit")
public class DataEditController {

    private final ProductService productService;
    private final CategoryService categoryService;
    private final StockService stockService;
    private final LocationService locationService;

    public DataEditController(ProductService productService, CategoryService categoryService,
                              StockService stockService, LocationService locationService) {
        this.productService = productService;
        this.categoryService = categoryService;
        this.stockService = stockService;
        this.locationService = locationService;
    }

    @GetMapping
    public String showEditPage(Model model) {
        model.addAttribute("categories", categoryService.getAllCategories());
        model.addAttribute("locations", locationService.getAllLocations());
        model.addAttribute("products", productService.getAllProducts());

        return "dataedit";
    }

    @PostMapping("/addproduct")
    public String addProduct(@RequestParam String name, @RequestParam Double price, @RequestParam Long categoryId, Model model) {
        Category category = categoryService.findCategoryById(categoryId);
        if (category == null) {
            model.addAttribute("error", "Invalid category ID");
            return "dataedit";
        }

        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        product.setCategory(category);

        productService.addProduct(product);
        return "redirect:/dataedit";
    }

    @PostMapping("/addcategory")
    public String addCategory(@RequestParam String name) {
        Category category = new Category();
        category.setName(name);

        categoryService.addCategory(category);
        return "redirect:/dataedit";
    }

    @PostMapping("/addlocation")
    public String addLocation(@RequestParam String name, @RequestParam String address) {
        Location location = new Location();
        location.setName(name);
        location.setAddress(address);

        locationService.addLocation(location);
        return "redirect:/dataedit";
    }

    @PostMapping("/addstock")
    public String addStock(@RequestParam Long productId, @RequestParam Long locationId, @RequestParam Integer quantity, Model model) {
        Product product = productService.findProductById(productId);
        if (product == null) {
            model.addAttribute("error", "Invalid product ID");
            return "dataedit";
        }

        Location location = locationService.findLocationById(locationId);
        if (location == null) {
            model.addAttribute("error", "Invalid location ID");
            return "dataedit";
        }

        Stock stock = new Stock();
        stock.setProduct(product);
        stock.setLocation(location);
        stock.setQuantity(quantity);

        stockService.addStock(stock);
        return "redirect:/dataedit";
    }
}

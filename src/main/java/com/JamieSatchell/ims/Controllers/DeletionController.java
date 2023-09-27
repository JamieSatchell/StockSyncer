package com.JamieSatchell.ims.Controllers;

import com.JamieSatchell.ims.domain.*;
import com.JamieSatchell.ims.Services.CategoryService;
import com.JamieSatchell.ims.Services.LocationService;
import com.JamieSatchell.ims.Services.ProductService;
import com.JamieSatchell.ims.Services.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class DeletionController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private LocationService locationService;

    @Autowired
    private StockService stockService;

    @GetMapping("/delete")
    public String getDeletionPage(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        model.addAttribute("categories", categoryService.getAllCategories());
        model.addAttribute("locations", locationService.getAllLocations());
        model.addAttribute("stocks", stockService.getAllStocks());
        return "delete";
    }

    @PostMapping("/deleteProduct")
    public String deleteProduct(@RequestParam Long productId, Model model) {
        try {
            productService.deleteProductById(productId);
            model.addAttribute("successMessage", "Product deleted successfully");
        } catch (Exception e) {
            model.addAttribute("errorMessage", e.getMessage());
        }
        return getDeletionPage(model);
    }

    @PostMapping("/deleteCategory")
    public String deleteCategory(@RequestParam Long categoryId, Model model) {
        try {
            categoryService.deleteCategoryById(categoryId);
            model.addAttribute("successMessage", "Category deleted successfully");
        } catch (Exception e) {
            model.addAttribute("errorMessage", e.getMessage());
        }
        return getDeletionPage(model);
    }

    @PostMapping("/deleteLocation")
    public String deleteLocation(@RequestParam Long locationId, Model model) {
        try {
            locationService.deleteLocationById(locationId);
            model.addAttribute("successMessage", "Location deleted successfully");
        } catch (Exception e) {
            model.addAttribute("errorMessage", e.getMessage());
        }
        return getDeletionPage(model);
    }

    @PostMapping("/deleteStock")
    public String deleteStock(@RequestParam Long stockId, Model model) {
        try {
            stockService.deleteStockById(stockId);
            model.addAttribute("successMessage", "Stock deleted successfully");
        } catch (Exception e) {
            model.addAttribute("errorMessage", e.getMessage());
        }
        return getDeletionPage(model);
    }
}

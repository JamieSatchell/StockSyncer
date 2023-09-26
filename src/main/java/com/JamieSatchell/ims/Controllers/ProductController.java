package com.JamieSatchell.ims.Controllers;

import com.JamieSatchell.ims.Services.ProductService;
import com.JamieSatchell.ims.domain.Product;
import com.JamieSatchell.ims.domain.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping
    public String getAllProducts(Model model) {
        List<Product> products = productService.getAllProducts();
        // Calculating total stock for each product and setting it
        for(Product product : products) {
            int totalStock = product.getStock().stream().mapToInt(Stock::getQuantity).sum();
            product.setTotalStock(totalStock);  // Assume a setter method for totalStock in Product class
        }
        model.addAttribute("products", products);
        return "productData";
    }
}

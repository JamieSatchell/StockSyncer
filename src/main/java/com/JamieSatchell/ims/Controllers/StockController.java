package com.JamieSatchell.ims.Controllers;

import com.JamieSatchell.ims.Services.StockService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StockController {
    private final StockService stockService;
    public StockController(StockService stockService) {
        this.stockService = stockService;
    }
    @GetMapping("/stock")
    public String showStockData(Model model) {
        model.addAttribute("stocks", stockService.getAllStocks());
        return "stockData";
    }
}

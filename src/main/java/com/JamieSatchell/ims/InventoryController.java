package com.JamieSatchell.ims;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    @GetMapping("/test")
    public String testEndpoint() {
        return "Test message from Inventory Controller!";
    }

}


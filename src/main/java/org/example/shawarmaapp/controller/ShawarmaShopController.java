package org.example.shawarmaapp.controller;

import org.example.shawarmaapp.entity.ShawarmaShop;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/shops")
public class ShawarmaShopController {
    private List<ShawarmaShop> shops = new ArrayList<>(List.of(
            new ShawarmaShop(1, "Doner u Bratishek", "Borisa Galushkina Street, 16"),
            new ShawarmaShop(2, "ShaurmuEli", "Sushchevskaya Street, 25, building 4")
    ));

    @GetMapping
    public List<ShawarmaShop> getAll() {
        return shops;
    }

    @GetMapping("/{id}")
    public ShawarmaShop getById(@PathVariable int id) {
        return shops.stream()
                .filter(s -> s.getId() == id)
                .findFirst()
                .orElse(null);
    }
}

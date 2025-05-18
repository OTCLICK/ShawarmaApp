package org.example.shawarmaapp.controller;

import org.example.shawarmaapp.entity.Shawarma;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/shawarmas")
public class ShawarmaController {
    private List<Shawarma> shawarmas = new ArrayList<>(List.of(
            new Shawarma(1, "Classic", 229.99),
            new Shawarma(2, "Student", 169.99),
            new Shawarma(3, "Branded", 279.99)
    ));

    @GetMapping
    public List<Shawarma> getAll() {
        return shawarmas;
    }

    @GetMapping("/{id}")
    public Shawarma getById(@PathVariable int id) {
        return shawarmas.stream()
                .filter(s -> s.getId() == id)
                .findFirst()
                .orElse(null);
    }
}

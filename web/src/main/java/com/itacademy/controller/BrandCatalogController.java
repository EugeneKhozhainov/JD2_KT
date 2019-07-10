package com.itacademy.controller;

import com.itacademy.controller.form.BrandFormAdd;
import com.itacademy.controller.form.BrandFormDelete;
import com.itacademy.database.entity.BrandCatalogEntity;
import com.itacademy.database.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class BrandCatalogController {

    @Autowired
    private BrandRepository brandRepository;

    @GetMapping(value = "/brandcatalog")
    public String doGet(Model model) {
        model.addAttribute("brandList", brandRepository.getAll());
        return "brand_catalog";
    }

    @PostMapping(value = "/brandcatalog")
    public String doPost(Model model,
                         @ModelAttribute("brandFormDelete") BrandFormDelete brandFormDelete,
                         @ModelAttribute("brandFormAdd") BrandFormAdd brandFormAdd) {
        Long id = brandFormDelete.getId();
        if (id != null) {
            brandRepository.deleteById(id);
        }

        String name = brandFormAdd.getName();
        BrandCatalogEntity brand = new BrandCatalogEntity();
        brand.setName(name);

        if (name != null) {
            brandRepository.save(brand);
        }

        model.addAttribute("brandList", brandRepository.getAll());
        return "brand_catalog";
    }
}

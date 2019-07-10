package com.itacademy.controller;

import com.itacademy.controller.form.ModelFormAdd;
import com.itacademy.controller.form.ModelFormDelete;
import com.itacademy.database.entity.ModelCatalogEntity;
import com.itacademy.database.repository.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ModelCatalogController {

    @Autowired
    private ModelRepository modelRepository;

    @GetMapping(value = "/modelcatalog")
    public String doGet(Model model) {
        model.addAttribute("modelList", modelRepository.getAll());
        return "model_catalog";
    }

    @PostMapping(value = "/modelcatalog")
    public String doPost(Model model,
                         @ModelAttribute("brandFormDelete") ModelFormDelete modelFormDelete,
                         @ModelAttribute("brandFormAdd") ModelFormAdd modelFormAdd){
        Long id = modelFormDelete.getId();
        if (id != null) {
            modelRepository.deleteById(id);
        }

        String name = modelFormAdd.getName();
        ModelCatalogEntity modelCatalogEntity = new ModelCatalogEntity();
        modelCatalogEntity.setName(name);

        if (name != null) {
            modelRepository.save(modelCatalogEntity);
        }

        model.addAttribute("modelList", modelRepository.getAll());
        return "model_catalog";
    }
    }

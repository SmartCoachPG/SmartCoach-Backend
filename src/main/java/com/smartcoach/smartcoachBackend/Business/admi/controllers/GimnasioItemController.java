package com.smartcoach.smartcoachBackend.Business.admi.controllers;

import com.smartcoach.smartcoachBackend.Business.admi.entities.GimnasioItem;
import com.smartcoach.smartcoachBackend.Business.admi.services.GimnasioItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gimnasioItem")
public class GimnasioItemController {

    @Autowired
    private GimnasioItemService gimnasioItemService;

    @GetMapping
    public List<GimnasioItem> getAllGimnasioItems() {
        return gimnasioItemService.findAll();
    }

    @PostMapping("/add")
    public GimnasioItem addGimnasioItem(@RequestBody GimnasioItem gimnasioItem) {
        return gimnasioItemService.save(gimnasioItem);
    }

}

package com.smartcoach.smartcoachBackend.Business.admi.controllers;

import com.smartcoach.smartcoachBackend.Business.admi.entities.GimnasioItem;
import com.smartcoach.smartcoachBackend.Business.admi.services.GimnasioItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/getByGimnasioId/{gimnasioid}")
    public List<GimnasioItem> getGimnasioItemsByGimnasioid(@PathVariable int gimnasioid) {
        return gimnasioItemService.findGimnasioItemByGimnasioid(gimnasioid);
    }

    @DeleteMapping("/delete/{gimnasioid}/{itemid}")
    public ResponseEntity<Void> deleteGimnasioItem(@PathVariable("gimnasioid") int gimnasioid, @PathVariable("itemid") int itemid) {
        gimnasioItemService.deleteGimnasioItem(gimnasioid, itemid);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update")
    public GimnasioItem updateGimnasioItem(@RequestBody GimnasioItem gimnasioItem) {
        return gimnasioItemService.update(gimnasioItem);
    }

    @GetMapping("/{gimnasioid}/{itemid}")
    public GimnasioItem getGimnasioItem(@PathVariable int gimnasioid, @PathVariable int itemid) {
        return gimnasioItemService.findGimnasioItem(gimnasioid, itemid);
    }

}

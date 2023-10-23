package com.smartcoach.smartcoachBackend.Business.exercise.controllers;

import com.smartcoach.smartcoachBackend.Business.exercise.entities.ImagenEjercicio;
import com.smartcoach.smartcoachBackend.Business.exercise.services.ImagenEjercicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/imagenejercicio")
public class ImagenEjercicioController {

    @Autowired
    private ImagenEjercicioService imagenEjercicioService;

    @GetMapping
    public List<ImagenEjercicio> findAll() {
        return imagenEjercicioService.findAll();
    }

    @GetMapping("/{id}")
    public ImagenEjercicio findById(@PathVariable Long id) {
        return imagenEjercicioService.findById(id);
    }

    @PostMapping
    public ImagenEjercicio save(@RequestBody ImagenEjercicio imagenEjercicio) {
        return imagenEjercicioService.save(imagenEjercicio);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        imagenEjercicioService.deleteById(id);
    }

    @GetMapping("/findByEjercicioid/{id}")
    public List<ImagenEjercicio> findByEjercicioid(@PathVariable int id) {
        return imagenEjercicioService.findByEjercicioid(id);
    }
}

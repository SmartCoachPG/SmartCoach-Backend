package com.smartcoach.smartcoachBackend.Business.exercise.controllers;

import com.smartcoach.smartcoachBackend.Business.exercise.entities.VideoEjercicio;
import com.smartcoach.smartcoachBackend.Business.exercise.services.VideoEjercicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/videoejercicio")
public class VideoEjercicioController {

    @Autowired
    private VideoEjercicioService videoEjercicioService;

    @GetMapping
    public List<VideoEjercicio> findAll() {
        return videoEjercicioService.findAll();
    }

    @GetMapping("/{id}")
    public VideoEjercicio findById(@PathVariable Long id) {
        return videoEjercicioService.findById(id);
    }

    @PostMapping
    public VideoEjercicio save(@RequestBody VideoEjercicio videoEjercicio) {
        return videoEjercicioService.save(videoEjercicio);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        videoEjercicioService.deleteById(id);
    }
}

package com.smartcoach.smartcoachBackend.Business.exercise.services;

import com.smartcoach.smartcoachBackend.Business.exercise.entities.ImagenEjercicio;
import com.smartcoach.smartcoachBackend.Persistence.exercise.ImagenEjercicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImagenEjercicioService {

    @Autowired
    private ImagenEjercicioRepository imagenEjercicioRepository;

    public List<ImagenEjercicio> findAll() {
        return imagenEjercicioRepository.findAll();
    }

    public ImagenEjercicio findById(Long id) {
        return imagenEjercicioRepository.findById(id).orElse(null);
    }

    public ImagenEjercicio save(ImagenEjercicio imagenEjercicio) {
        return imagenEjercicioRepository.save(imagenEjercicio);
    }

    public void deleteById(Long id) {
        imagenEjercicioRepository.deleteById(id);
    }

    public List<ImagenEjercicio> findByEjercicioid(int ejercicioid) {
        return imagenEjercicioRepository.findByEjercicioid(ejercicioid);
    }
}


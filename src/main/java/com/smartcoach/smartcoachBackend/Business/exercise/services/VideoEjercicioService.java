package com.smartcoach.smartcoachBackend.Business.exercise.services;

import com.smartcoach.smartcoachBackend.Business.exercise.entities.VideoEjercicio;
import com.smartcoach.smartcoachBackend.Persistence.exercise.VideoEjercicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VideoEjercicioService {

    @Autowired
    private VideoEjercicioRepository videoEjercicioRepository;

    public List<VideoEjercicio> findAll() {
        return videoEjercicioRepository.findAll();
    }

    public VideoEjercicio findById(Long id) {
        return videoEjercicioRepository.findById(id).orElse(null);
    }

    public VideoEjercicio save(VideoEjercicio videoEjercicio) {
        return videoEjercicioRepository.save(videoEjercicio);
    }

    public void deleteById(Long id) {
        videoEjercicioRepository.deleteById(id);
    }
}

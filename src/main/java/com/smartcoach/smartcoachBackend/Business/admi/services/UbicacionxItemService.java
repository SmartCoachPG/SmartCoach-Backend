package com.smartcoach.smartcoachBackend.Business.admi.services;

import com.smartcoach.smartcoachBackend.Business.admi.entities.UbicacionxItem;
import com.smartcoach.smartcoachBackend.Persistence.admi.UbicacionxItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UbicacionxItemService {

    @Autowired
    private UbicacionxItemRepository ubicacionxItemRepository;

    public List<UbicacionxItem> findAll() {
        return ubicacionxItemRepository.findAll();
    }

    public Optional<UbicacionxItem> findById(int id) {
        return ubicacionxItemRepository.findById(id);
    }

    public UbicacionxItem save(UbicacionxItem ubicacionxItem) {
        return ubicacionxItemRepository.save(ubicacionxItem);
    }

    public void deleteById(int id) {
        ubicacionxItemRepository.deleteById(id);
    }
}

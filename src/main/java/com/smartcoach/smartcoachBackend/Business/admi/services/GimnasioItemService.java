package com.smartcoach.smartcoachBackend.Business.admi.services;

import com.smartcoach.smartcoachBackend.Business.admi.entities.*;
import com.smartcoach.smartcoachBackend.Persistence.admi.GimnasioItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class GimnasioItemService {

    @Autowired
    private GimnasioItemRepository gimnasioItemRepository;

    @Autowired
    private UbicacionxItemService ubicacionxItemService;

    public List<GimnasioItem> findAll() {
        return gimnasioItemRepository.findAll();
    }

    public GimnasioItem save(GimnasioItem gimnasioItem) {
        return gimnasioItemRepository.save(gimnasioItem);
    }

    public List<GimnasioItem> findGimnasioItemByGimnasioid(int gimnasioid) {
        return gimnasioItemRepository.findByGimnasioid(gimnasioid);
    }

    @Transactional
    public void deleteGimnasioItem(int gimnasioid, int itemid) {
        GimnasioItemId id = new GimnasioItemId();
        id.setGimnasioid(gimnasioid);
        id.setItemid(itemid);
        List<UbicacionxItem> listaUI = ubicacionxItemService.getUbicacionxItemByGimnasioId(gimnasioid);
        for(UbicacionxItem ui: listaUI)
        {
            if(ui.getItemid()==itemid)
            {
                ubicacionxItemService.deleteById(ui.getId());
            }
        }
        gimnasioItemRepository.deleteById(id);
    }

    public GimnasioItem update(GimnasioItem gimnasioItem) {
        return gimnasioItemRepository.save(gimnasioItem);
    }

    public GimnasioItem findGimnasioItem(int gimnasioid, int itemid) {
        return gimnasioItemRepository.findByGimnasioidAndItemid(gimnasioid, itemid);
    }

}

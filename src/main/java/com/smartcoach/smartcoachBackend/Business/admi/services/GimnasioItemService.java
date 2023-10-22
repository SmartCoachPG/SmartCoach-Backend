package com.smartcoach.smartcoachBackend.Business.admi.services;

import com.smartcoach.smartcoachBackend.Business.admi.entities.GimnasioItem;
import com.smartcoach.smartcoachBackend.Business.admi.entities.GimnasioItemId;
import com.smartcoach.smartcoachBackend.Persistence.admi.GimnasioItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class GimnasioItemService {

    @Autowired
    private GimnasioItemRepository gimnasioItemRepository;

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
        gimnasioItemRepository.deleteById(id);
    }

}

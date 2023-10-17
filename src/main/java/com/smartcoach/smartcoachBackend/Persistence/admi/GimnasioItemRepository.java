package com.smartcoach.smartcoachBackend.Persistence.admi;

import com.smartcoach.smartcoachBackend.Business.admi.entities.GimnasioItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GimnasioItemRepository extends JpaRepository<GimnasioItem, Integer> {

    List<GimnasioItem> findByGimnasioid(int gimnasioid);
}

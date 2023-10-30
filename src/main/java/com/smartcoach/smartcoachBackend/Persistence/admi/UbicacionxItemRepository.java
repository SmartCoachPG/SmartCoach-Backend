package com.smartcoach.smartcoachBackend.Persistence.admi;

import com.smartcoach.smartcoachBackend.Business.admi.entities.UbicacionxItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UbicacionxItemRepository extends JpaRepository<UbicacionxItem, Long> {

    List<UbicacionxItem> findByItemid(int itemid);

    List<UbicacionxItem> findByGimnasioid(int gimnasioid);

}

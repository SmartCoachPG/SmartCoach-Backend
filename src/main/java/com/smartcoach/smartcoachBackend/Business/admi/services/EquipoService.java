package com.smartcoach.smartcoachBackend.Business.admi.services;

import com.smartcoach.smartcoachBackend.Business.admi.entities.Equipo;
import com.smartcoach.smartcoachBackend.Persistence.admi.EquipoRepository;
import com.smartcoach.smartcoachBackend.Persistence.admi.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Service
public class EquipoService {

    @Autowired
    private EquipoRepository repository;

    @Autowired
    private ItemRepository itemRepository;


    public Equipo create(Equipo equipo) {
        return repository.save(equipo);
    }

    public Equipo getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<Equipo> getAll() {
        return repository.findAll();
    }

    public Equipo update(Equipo equipo) {
        return repository.save(equipo);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public void deleteByUsuarioClienteId(Integer usuarioClienteId) {
        List<Equipo> equipos = repository.findByUsuarioId(usuarioClienteId);
        for (Equipo equipo : equipos) {
            itemRepository.deleteById(equipo.getId());
        }
        repository.deleteByUsuarioId(usuarioClienteId);

    }

    @PersistenceContext
    EntityManager em;

    public List<Equipo> findEquiposByGimnasioId(Integer gimnasioId) {
        String jpql = "SELECT e FROM Equipo e " +
                "JOIN GimnasioItem gi ON e.id = gi.itemid " +
                "WHERE gi.gimnasioid = :gimnasioId";
        TypedQuery<Equipo> query = em.createQuery(jpql, Equipo.class);
        query.setParameter("gimnasioId", gimnasioId);
        return query.getResultList();
    }

    public List<Equipo> findEquiposByUsuarioId(Integer usuarioId) {
        String jpql = "SELECT e FROM Equipo e WHERE e.usuarioId = :usuarioId";
        TypedQuery<Equipo> query = em.createQuery(jpql, Equipo.class);
        query.setParameter("usuarioId", usuarioId);
        return query.getResultList();
    }

    public Integer findTipoEquipoIdByItemId(Long itemId) {
        Equipo equipo = repository.findById(itemId).orElse(null);
        if (equipo != null) {
            return equipo.getTipoEquipoId();
        }
        return null;
    }

}

package com.wantedbear.movieres.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wantedbear.movieres.entity.Salas;
import com.wantedbear.movieres.repository.SalasRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SalasService {

    @Autowired
    private SalasRepository salasRepository;

    public List<Salas> findAllSalas() {
        return salasRepository.findAll();
    }

    public Salas createSalas(Salas salas) {
        return salasRepository.save(salas);
    }

    public Optional<Salas> getSalas(Long id) {
        return salasRepository.findById(id);
    }

    public Salas updateSalas(Long id, Salas salasDetails) {
        if (salasRepository.existsById(id)) {
            return salasRepository.save(salasDetails);
        }
        return null;
    }

    public void deleteSalas(Long id) {
        salasRepository.deleteById(id);
    }
}

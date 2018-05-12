package com.andersonribeiro.cursomc.services;

import com.andersonribeiro.cursomc.domain.Categoria;
import com.andersonribeiro.cursomc.repositories.CategoriaRepository;
import com.andersonribeiro.cursomc.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Id;
import java.util.Optional;

@Service
public class CategoriaService {

    private CategoriaRepository repo;

    @Autowired
    public CategoriaService(CategoriaRepository repo) {
        this.repo = repo;
    }

    public Categoria buscar(Integer id) {
        Optional<Categoria> obj = this.repo.findById(id);
        if (obj == null) {
            throw new ObjectNotFoundException("Objeto não encontrado Id: " + Id
                + ", Tipo: " + Categoria.class.getName());
        }
        return obj.orElse(null);
    }
}

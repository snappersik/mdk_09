package com.aptproject.springlibraryproject.library.service;

import com.aptproject.springlibraryproject.library.dto.GenericDTO;
import com.aptproject.springlibraryproject.library.mapper.GenericMapper;
import com.aptproject.springlibraryproject.library.model.GenericModel;
import com.aptproject.springlibraryproject.library.repository.GenericRepository;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.time.LocalDateTime;
import java.util.List;

@Service
public abstract class GenericService<E extends GenericModel, D extends GenericDTO> {

    protected final GenericRepository<E> repository;
    protected final GenericMapper<E, D> mapper;

    @SuppressWarnings("SpringJavalnjectionPointsAutowiringInspection")
    public GenericService(GenericRepository<E> repository, GenericMapper<E, D> mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<D> listAll() {
        return mapper.toDTOs(repository.findAll());
    }

    public D getOne(final Long id) {
        return mapper.toDTO(repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Данные по заданному id: " + id + " не найдено!")));
    }

    public D create(D newObject) {
        newObject.setCreatedWhen(LocalDateTime.now());
        return mapper.toDTO(repository.save(mapper.toEntity(newObject)));
    }

    public D update(D updatedObject) {
        return mapper.toDTO(repository.save(mapper.toEntity(updatedObject)));
    }

    public void delete(final Long id) {
        repository.deleteById(id);
    }
}
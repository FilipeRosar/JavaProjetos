package com.livraria.books_on.application.service;


import com.livraria.books_on.domain.dto.publisherDTOs.CreatePublisherDTO;
import com.livraria.books_on.domain.entity.Publisher;
import com.livraria.books_on.domain.repository.PublisherRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PublisherService {

    private final PublisherRepository _publisherRepository;

    public PublisherService(PublisherRepository _publisherRepository) {
        this._publisherRepository = _publisherRepository;
    }

    public Optional<Publisher> getPublisher(UUID id){
        return _publisherRepository.findById(id);
    }
    public List<Publisher> getAllPublisher(){ return _publisherRepository.findAll(); }

    public UUID createPublisher(CreatePublisherDTO publisherDTO){
        Publisher publisher = new Publisher();

        publisher.setName(publisherDTO.name());

        return _publisherRepository.save(publisher).getId();
    }

}

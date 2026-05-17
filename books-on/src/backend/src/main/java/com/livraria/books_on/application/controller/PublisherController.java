package com.livraria.books_on.application.controller;


import com.livraria.books_on.application.service.PublisherService;
import com.livraria.books_on.domain.dto.publisherDTOs.CreatePublisherDTO;
import com.livraria.books_on.domain.dto.publisherDTOs.PublisherResponseDto;
import com.livraria.books_on.domain.entity.Publisher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("v1/publisher")
public class PublisherController {

    private final PublisherService _publisherService;

    public PublisherController(PublisherService _publisherService) {
        this._publisherService = _publisherService;
    }

    @GetMapping("/{publisherId}")
    public ResponseEntity<PublisherResponseDto> getPublisherById(@PathVariable UUID publisherId){
        var id = _publisherService.getPublisher(publisherId);
        return ResponseEntity.of(id);
    }

    @GetMapping
    public ResponseEntity<List<PublisherResponseDto>> getAllpublisher(){
        var allPublishers = _publisherService.getAllPublisher();
        return ResponseEntity.ok(allPublishers);
    }
    @PostMapping
    public ResponseEntity<Publisher> createPublisher(@RequestBody CreatePublisherDTO dto){
        var author = _publisherService.createPublisher(dto);
        return ResponseEntity.created(URI.create("/v1/publisher/"+author.toString())).build();
    }

}

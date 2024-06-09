package com.mitocode.controller;


import com.mitocode.dto.SignalDTO;
import com.mitocode.model.Signal;
import com.mitocode.service.ISignalService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/signals")
@RequiredArgsConstructor
public class SignalController {

    private final ISignalService service;

    @Qualifier("signalMapper")
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<SignalDTO>> findAll(){
        List<SignalDTO> list = service.findAll().stream().map(this::convertToDto).toList();

        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SignalDTO> findById(@PathVariable("id") Integer id){
        SignalDTO obj = convertToDto(service.findById(id));

        return ResponseEntity.ok(obj);
        //return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody SignalDTO dto){
        Signal t = convertToEntity(dto);
        Signal obj = service.save(t);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdSignal()).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<SignalDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody SignalDTO dto){
        dto.setIdSignal(id);
        Signal obj = service.update(id, convertToEntity(dto));

        return ResponseEntity.ok(convertToDto(obj));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id){
        service.delete(id);

        return ResponseEntity.noContent().build(); //204 NO CONTENT
    }

    @GetMapping("/hateoas/{id}")
    public EntityModel<SignalDTO> findByIdHateoas(@PathVariable("id") Integer id){
        EntityModel<SignalDTO> resource = EntityModel.of(convertToDto(service.findById(id)));

        //generar un link informativo
        WebMvcLinkBuilder link1 = linkTo(methodOn(this.getClass()).findById(id));
        WebMvcLinkBuilder link2 = linkTo(methodOn(this.getClass()).findAll());

        resource.add(link1.withRel("signal-info-byId"));
        resource.add(link2.withRel("signal-all-info"));

        return resource;
    }

    private SignalDTO convertToDto(Signal obj){
        return modelMapper.map(obj, SignalDTO.class);
    }

    private Signal convertToEntity(SignalDTO dto){
        return modelMapper.map(dto, Signal.class);
    }






}

package br.com.treinaweb.adoteumpet.api.pet.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.validation.Valid;

import br.com.treinaweb.adoteumpet.api.pet.dtos.PetRequest;
import br.com.treinaweb.adoteumpet.api.pet.dtos.PetResponse;
import br.com.treinaweb.adoteumpet.api.pet.service.PetService;


@RestController
@RequestMapping("/api/pets")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PetController {

  @Autowired
  private PetService petService;

  @GetMapping
  public ResponseEntity<List<PetResponse>> getAll (){
      return ResponseEntity.ok(petService.findAll());
  }

  @PostMapping
  public PetResponse cadastrarPet(@RequestBody @Valid PetRequest petRequest) {
    return petService.cadastrarPet(petRequest);
  }
  
}

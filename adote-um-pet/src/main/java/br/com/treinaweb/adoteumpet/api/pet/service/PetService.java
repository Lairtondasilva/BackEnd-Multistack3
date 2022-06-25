package br.com.treinaweb.adoteumpet.api.pet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.treinaweb.adoteumpet.api.pet.dtos.PetRequest;
import br.com.treinaweb.adoteumpet.api.pet.dtos.PetResponse;
import br.com.treinaweb.adoteumpet.api.pet.mappers.PetMapper;
import br.com.treinaweb.adoteumpet.core.repositories.PetRepository;

@Service
public class PetService {
  
  @Autowired
  private PetMapper petMapper;

  @Autowired
  private PetRepository petRepository;

  public List<PetResponse> findAll(){
    return petRepository.findAll().stream()
      .map(petMapper::toPetResponse)
      .toList();
  }

  public PetResponse cadastrarPet(PetRequest petRequest){
    var petModel = petMapper.toModel(petRequest);
    var pet = petRepository.save(petModel);
    return petMapper.toPetResponse(pet);
  }

}

package br.com.treinaweb.adoteumpet.api.pet.mappers;

import org.springframework.stereotype.Component;

import br.com.treinaweb.adoteumpet.api.pet.dtos.PetRequest;
import br.com.treinaweb.adoteumpet.api.pet.dtos.PetResponse;
import br.com.treinaweb.adoteumpet.core.model.Pet;

@Component
public class PetMapper {

  public PetResponse toPetResponse(Pet pet){
    // PetResponse petResponse = new PetResponse();
    // petResponse.setId(pet.getId());
    // petResponse.setNome(pet.getNome());
    // petResponse.setHistoria(pet.getHistoria());
    // petResponse.setFoto(pet.getFoto());
    // return petResponse;
    return PetResponse.builder()
    .id(pet.getId())
    .nome(pet.getNome())
    .foto(pet.getFoto())
    .historia(pet.getHistoria()).build();
  }

  public Pet toModel(PetRequest petRequest){
    return Pet.builder()
    .nome(petRequest.getNome())
    .historia(petRequest.getHistoria())
    .foto(petRequest.getFoto())
    .build();
    
  }
}
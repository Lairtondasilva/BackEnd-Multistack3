package br.com.treinaweb.adoteumpet.api.adocao.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.treinaweb.adoteumpet.api.adocao.dtos.AdocaoRequest;
import br.com.treinaweb.adoteumpet.api.adocao.dtos.AdocaoResponse;
import br.com.treinaweb.adoteumpet.api.pet.mappers.PetMapper;
import br.com.treinaweb.adoteumpet.core.model.Adocao;
import br.com.treinaweb.adoteumpet.core.repositories.PetRepository;

@Component
public class AdocaoMapper {
  
  @Autowired
  PetRepository petRepository;

  @Autowired
  private PetMapper petMapper;

  public Adocao toModel(AdocaoRequest adoacaoRequest){
    // var adoacao = new Adocao();

    // adoacao.setEmail(adoacaoRequest.getEmail());
    // adoacao.setValor(adoacaoRequest.getValor());
    // adoacao.setPet(petRepository
    //   .findByIdOrElseThrow(adoacaoRequest.getPetId()));
    // return adoacao;
    return Adocao.builder()
    .Email(adoacaoRequest.getEmail())
    .valor(adoacaoRequest.getValor())
    .pet(petRepository.findByIdOrElseThrow(adoacaoRequest.getPetId()))
    .build();
  }

  public AdocaoResponse toResponse(Adocao adocao){
    // var response = new AdocaoResponse();
    // response.setId(adocao.getId());
    // response.setEmail(adocao.getEmail());
    // response.setValor(adocao.getValor());
    // response.setPet(petMapper.toPetResponse(adocao.getPet()));
    // return response;
    return AdocaoResponse.builder()
    .id(adocao.getId())
    .email(adocao.getEmail())
    .valor(adocao.getValor())
    .pet(petMapper.toPetResponse(adocao.getPet()))
    .build();
  }

}

package br.com.treinaweb.adoteumpet.api.adocao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.treinaweb.adoteumpet.api.adocao.dtos.AdocaoRequest;
import br.com.treinaweb.adoteumpet.api.adocao.dtos.AdocaoResponse;
import br.com.treinaweb.adoteumpet.api.adocao.mappers.AdocaoMapper;
import br.com.treinaweb.adoteumpet.core.repositories.AdocaoRepository;

@Service
public class AdocaoService {
  
  @Autowired
  private AdocaoMapper adocaoMapper;

  @Autowired
  private AdocaoRepository adocaoRepository;

  public AdocaoResponse fazerDoacao(AdocaoRequest adocaoRequest){
    var doacao = adocaoMapper.toModel(adocaoRequest);
    var createdDoacao = adocaoRepository.save(doacao);
    return adocaoMapper.toResponse(createdDoacao);
  }

  public List<AdocaoResponse> findAll(){
    return adocaoRepository.findAll()
    .stream().map(adocaoMapper::toResponse).toList();
  }

}

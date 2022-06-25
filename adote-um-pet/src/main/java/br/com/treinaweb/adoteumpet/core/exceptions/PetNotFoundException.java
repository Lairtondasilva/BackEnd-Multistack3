package br.com.treinaweb.adoteumpet.core.exceptions;

import javax.persistence.EntityNotFoundException;

public class PetNotFoundException extends EntityNotFoundException {

  public PetNotFoundException() {
    super("O pet não foi encontrado!");
  }

  public PetNotFoundException(String message) {
    super(message);
  }
  
}

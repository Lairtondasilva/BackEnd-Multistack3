package br.com.treinaweb.adoteumpet.core.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Entity  
@Data //cria métodos getters e setters para todos os atributos
@NoArgsConstructor // cria um construtor vazio
@AllArgsConstructor //cria um construtor com todos os argumentos
@EqualsAndHashCode(onlyExplicitlyIncluded = true)/*cria um método hashcode com o
os atributos que for incluido */
@Builder
public class Pet {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @EqualsAndHashCode.Include
  private Long id;

  @Column(nullable = false, name = "pet_nome") 
  private String nome;

  @Column(nullable = false) 
  private String historia;

  @Column(nullable = false)
  private String foto;
  
}

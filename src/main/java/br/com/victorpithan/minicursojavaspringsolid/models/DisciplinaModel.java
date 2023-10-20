package br.com.victorpithan.minicursojavaspringsolid.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@Table(name = "disciplina")
public class DisciplinaModel {
  
  @Id
  @Column
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(length = 255, unique = true, nullable = false)
  private String nome;

  @Column(nullable = false)
  private Integer semestre;

  @OneToMany(mappedBy = "disciplina")
  @JsonIgnoreProperties("alunos")
  private List<TurmaModel> turmas;
}

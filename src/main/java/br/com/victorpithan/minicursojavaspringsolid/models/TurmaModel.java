package br.com.victorpithan.minicursojavaspringsolid.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@Table(name = "turma")
public class TurmaModel {
  
  @Id
  @Column
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(length = 255, unique = true, nullable = false)
  private String nome;

  @ManyToOne
  @JoinColumn(name = "disciplina_id")
  @JsonIgnoreProperties("turmas")
  private DisciplinaModel disciplina;

  @ManyToMany
  @JoinTable(name = "aluno_turma", joinColumns = @JoinColumn(name = "turma_id"), inverseJoinColumns = @JoinColumn(name = "aluno_id"))
  @JsonIgnoreProperties("turmas")
  private List<AlunoModel> alunos;
  
}

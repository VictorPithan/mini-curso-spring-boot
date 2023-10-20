package br.com.victorpithan.minicursojavaspringsolid.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.victorpithan.minicursojavaspringsolid.models.AlunoModel;

public interface AlunoRepository extends JpaRepository<AlunoModel, Integer> {
  
}

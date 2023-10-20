package br.com.victorpithan.minicursojavaspringsolid.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.victorpithan.minicursojavaspringsolid.models.DisciplinaModel;

public interface DisciplinaRepository extends JpaRepository<DisciplinaModel, Integer> {
  
}

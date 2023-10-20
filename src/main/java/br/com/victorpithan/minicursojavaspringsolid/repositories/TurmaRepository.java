package br.com.victorpithan.minicursojavaspringsolid.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.victorpithan.minicursojavaspringsolid.models.TurmaModel;

public interface TurmaRepository extends JpaRepository<TurmaModel, Integer> {
  
}

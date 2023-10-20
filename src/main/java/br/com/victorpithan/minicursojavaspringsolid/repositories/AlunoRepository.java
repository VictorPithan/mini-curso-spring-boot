package br.com.victorpithan.minicursojavaspringsolid.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.victorpithan.minicursojavaspringsolid.models.AlunoModel;

public interface AlunoRepository extends JpaRepository<AlunoModel, Integer> {
  @Query("SELECT CASE WHEN COUNT(a) > 0 THEN true ELSE false END FROM Aluno a WHERE a.matricula = :matricula")
    boolean existsByMatricula(@Param("matricula") String matricula);
}

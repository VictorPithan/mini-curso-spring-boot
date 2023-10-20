package br.com.victorpithan.minicursojavaspringsolid.services.interfaces;

import br.com.victorpithan.minicursojavaspringsolid.dtos.TurmaDTO;
import br.com.victorpithan.minicursojavaspringsolid.models.TurmaModel;

public interface TurmaService extends CrudService<TurmaModel, TurmaDTO>{
  TurmaModel matricular(int turma_id, int aluno_id);

  TurmaModel cancelarMatricula(int turma_id, int aluno_id);
}

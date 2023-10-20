package br.com.victorpithan.minicursojavaspringsolid.services.interfaces;

import br.com.victorpithan.minicursojavaspringsolid.dtos.AlunoDTO;
import br.com.victorpithan.minicursojavaspringsolid.models.AlunoModel;

public interface AlunoService extends CrudService<AlunoModel, AlunoDTO> {
  AlunoModel save(AlunoModel aluno);
}

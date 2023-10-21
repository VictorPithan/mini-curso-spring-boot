package br.com.victorpithan.minicursojavaspringsolid.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.victorpithan.minicursojavaspringsolid.dtos.TurmaDTO;
import br.com.victorpithan.minicursojavaspringsolid.models.AlunoModel;
import br.com.victorpithan.minicursojavaspringsolid.models.DisciplinaModel;
import br.com.victorpithan.minicursojavaspringsolid.models.TurmaModel;
import br.com.victorpithan.minicursojavaspringsolid.repositories.TurmaRepository;
import br.com.victorpithan.minicursojavaspringsolid.services.exceptions.NotFoundException;
import br.com.victorpithan.minicursojavaspringsolid.services.interfaces.AlunoService;
import br.com.victorpithan.minicursojavaspringsolid.services.interfaces.DisciplinaService;
import br.com.victorpithan.minicursojavaspringsolid.services.interfaces.TurmaService;

@Service
public class TurmaServiceImpl implements TurmaService {

    @Autowired
    private TurmaRepository turmaRepository;

    @Autowired
    private DisciplinaService disciplinaService;

    @Autowired
    private AlunoService alunoService;

    @Override
    public List<TurmaModel> getAll() {
        return turmaRepository.findAll();
    }

    @Override
    public TurmaModel getById(int id) {
        return turmaRepository.findById(id).orElseThrow(() -> new NotFoundException("Turma não encontrada.", 404));
    }

    @Override
    public TurmaModel save(TurmaDTO turmaDto) {
        TurmaModel turma = new TurmaModel();
        DisciplinaModel disciplina = disciplinaService.getById(turmaDto.disciplina_id());

        turma.setNome(turmaDto.nome());
        turma.setDisciplina(disciplina);

        return turmaRepository.save(turma);
    }

    @Override
    public TurmaModel update(int id, TurmaDTO turmaDto) {
        TurmaModel turma = getById(id);
        DisciplinaModel disciplina = disciplinaService.getById(turmaDto.disciplina_id());

        turma.setNome(turmaDto.nome());
        turma.setDisciplina(disciplina);

        return turmaRepository.save(turma);
    }

    @Override
    public boolean delete(int id) {
        if (turmaRepository.existsById(id)) {
            turmaRepository.deleteById(id);
            return true;
        } else {
            throw new NotFoundException(id);
        }
    }

    public TurmaModel matricular(int turma_id, int aluno_id) {
        AlunoModel aluno = alunoService.getById(aluno_id);
        TurmaModel turma = getById(turma_id);

        if (turma.getAlunos().contains(aluno)) {
            throw new IllegalArgumentException("Aluno já está inserido na turma.");
        }

        turma.getAlunos().add(aluno);
        aluno.getTurmas().add(turma);
        turmaRepository.save(turma);
        alunoService.save(aluno);
        return turma;
    }

    public TurmaModel cancelarMatricula(int turma_id, int aluno_id) {
        AlunoModel aluno = alunoService.getById(aluno_id);
        TurmaModel turma = getById(turma_id);

        if (!turma.getAlunos().contains(aluno)) {
            throw new NotFoundException("Aluno não pertence a turma.", aluno_id);
        }

        turma.getAlunos().remove(aluno);
        aluno.getTurmas().remove(turma);
        turmaRepository.save(turma);
        alunoService.save(aluno);
        return turma;
    }

}

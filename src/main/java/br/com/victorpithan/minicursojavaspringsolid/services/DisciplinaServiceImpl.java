package br.com.victorpithan.minicursojavaspringsolid.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.victorpithan.minicursojavaspringsolid.dtos.DisciplinaDTO;
import br.com.victorpithan.minicursojavaspringsolid.models.DisciplinaModel;
import br.com.victorpithan.minicursojavaspringsolid.repositories.DisciplinaRepository;
import br.com.victorpithan.minicursojavaspringsolid.services.interfaces.DisciplinaService;

@Service
public class DisciplinaServiceImpl implements DisciplinaService {

    @Autowired
    private DisciplinaRepository disciplinaRepository;

    @Override
    public List<DisciplinaModel> getAll() {
        return disciplinaRepository.findAll();
    }

    @Override
    public DisciplinaModel getById(int id) {
        return disciplinaRepository.findById(id)
                .orElseThrow();
    }

    @Override
    public DisciplinaModel save(DisciplinaDTO disciplinaDto) {
        DisciplinaModel disciplina = new DisciplinaModel();
        disciplina.setNome(disciplinaDto.nome());
        disciplina.setSemestre(disciplinaDto.semestre());
        return disciplinaRepository.save(disciplina);
    }

    @Override
    public DisciplinaModel update(int id, DisciplinaDTO disciplinaDto) {
        DisciplinaModel disciplina = getById(id);
        disciplina.setNome(disciplinaDto.nome());
        disciplina.setSemestre(disciplinaDto.semestre());
        return disciplinaRepository.save(disciplina);
    }

    @Override
    public boolean delete(int id) {
        if (disciplinaRepository.existsById(id)) {
            disciplinaRepository.deleteById(id);
            return true;
        } else {
            throw new RuntimeException();
        }
    }

}

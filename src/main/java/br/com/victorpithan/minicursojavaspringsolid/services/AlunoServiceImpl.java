package br.com.victorpithan.minicursojavaspringsolid.services;

import java.time.Year;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.victorpithan.minicursojavaspringsolid.dtos.AlunoDTO;
import br.com.victorpithan.minicursojavaspringsolid.models.AlunoModel;
import br.com.victorpithan.minicursojavaspringsolid.repositories.AlunoRepository;
import br.com.victorpithan.minicursojavaspringsolid.services.interfaces.AlunoService;

@Service
public class AlunoServiceImpl implements AlunoService {

  @Autowired
  private AlunoRepository alunoRepository;

  private final Random random = new Random();

  @Override
  public List<AlunoModel> getAll() {
    return alunoRepository.findAll();
  }

  @Override
  public AlunoModel getById(int id) {
   return alunoRepository.findById(id).orElseThrow(null);
  }

  @Override
  public AlunoModel save(AlunoDTO alunoDto) {
    AlunoModel aluno = new AlunoModel();
    aluno.setNome(alunoDto.nome());
    aluno.setSobrenome(alunoDto.sobrenome());

    String matricula = generateMatricula();
    while (alunoRepository.existsByMatricula(matricula)) {
      matricula = generateMatricula();
    }

    aluno.setMatricula(matricula);
    aluno.setEmail(generateEmail(alunoDto.nome(), alunoDto.sobrenome()));
    return alunoRepository.save(aluno);
  }

  @Override
  public AlunoModel save(AlunoModel aluno) {
    return alunoRepository.save(aluno);
  }

  @Override
  public AlunoModel update(int id, AlunoDTO alunoDto) {
    AlunoModel aluno = getById(id);
    aluno.setNome(alunoDto.nome());
    aluno.setSobrenome(alunoDto.sobrenome());
    aluno.setEmail(generateEmail(alunoDto.nome(), alunoDto.sobrenome()));
    return alunoRepository.save(aluno);
  }

  @Override
  public boolean delete(int id) {
    if (alunoRepository.existsById(id)) {
      alunoRepository.deleteById(id);
      return true;
    } else {
      throw new RuntimeException("Falhou");
    }
  }

  private String generateMatricula() {
    return String.format("%d%06d", Year.now().getValue(), random.nextInt(1000000));
  }

  private String generateEmail(String nome, String sobrenome) {
    return String.format("%s.%s@aluno.riogrande.ifrs.edu.br", nome.toLowerCase(), sobrenome.toLowerCase());
  }
  
}

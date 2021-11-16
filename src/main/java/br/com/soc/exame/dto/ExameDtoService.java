package br.com.soc.exame.dto;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.soc.exame.model.Exame;
import br.com.soc.exame.repository.ExameRepository;

@Service
public class ExameDtoService implements ExameDto {

	@Autowired
	private ExameRepository exameRepository;

	@Override
	public List<Exame> listaTodosExames() {
		return exameRepository.findAll(Sort.by(Sort.Direction.ASC, "nomePaciente", "nomeExame"));
	}

	@Override
	public void registraExame(Exame exame) {
		this.exameRepository.save(exame);
	}

	@Override
	public Exame listaExamePorId(Long id) {
		Optional<Exame> optional = exameRepository.findById(id);

		Exame exame = null;

		if (optional.isPresent()) {
			exame = optional.get();
		} else {

			throw new RuntimeException("Exame de ID " + id + " não encontrado");
		}

		return exame;

	}

	@Override
	public void excluiExamePorId(Long id) {
		this.exameRepository.deleteById(id);
	}
}

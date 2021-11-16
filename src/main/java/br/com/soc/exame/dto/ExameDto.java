package br.com.soc.exame.dto;

import java.util.List;

import br.com.soc.exame.model.Exame;

public interface ExameDto {
	List<Exame> listaTodosExames();

	Exame listaExamePorId(Long id);

	void registraExame(Exame exame);

	void excluiExamePorId(Long id);
}

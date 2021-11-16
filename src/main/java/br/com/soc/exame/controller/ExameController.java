package br.com.soc.exame.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.soc.exame.dto.ExameDtoService;
import br.com.soc.exame.model.Exame;

@Controller
@RequestMapping("/exame")
public class ExameController {

	@Autowired
	private ExameDtoService exameDtoService;

	@GetMapping("/lista")
	public String lista(Model model) {

		List<Exame> exames = exameDtoService.listaTodosExames();

		model.addAttribute("exames", exames);

		return "/exame/lista";
	}

	@GetMapping("/cadastro")
	public String cadastro(Exame exame) {

		return "/exame/cadastro";
	}

	@PostMapping("/registra")
	public String registra(Model model, @ModelAttribute("exame") @Valid Exame exame, BindingResult resultado) {

		if (resultado.hasErrors()) {
			return "/exame/cadastro";
		}

		try {

			exameDtoService.registraExame(exame);

		} catch (Exception ex) {

			model.addAttribute("erroMensagem", ex.getMessage());

			return "/error";
		}

		return "redirect:/exame/lista";
	}

	@GetMapping("/altera/{id}")
	public String altera(@PathVariable(value = "id") Long id, Model model) {

		Exame exame = exameDtoService.listaExamePorId(id);

		model.addAttribute("exame", exame);

		return "/exame/altera";
	}

	@GetMapping("/exclui/{id}")
	public String exclui(@PathVariable(value = "id") Long id) {

		this.exameDtoService.excluiExamePorId(id);

		return "redirect:/exame/lista";
	}

}
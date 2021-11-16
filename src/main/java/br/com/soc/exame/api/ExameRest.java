package br.com.soc.exame.api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.soc.exame.model.Exame;
import br.com.soc.exame.repository.ExameRepository;

@RestController
@RequestMapping("/api/exame")
public class ExameRest {

	@Autowired
	private ExameRepository exameRepository;

	@GetMapping("/{id}")
	public ResponseEntity<Exame> getExameDetalhe(@PathVariable Long id) {

		Optional<Exame> optional = exameRepository.findById(id);

		Exame exame = null;

		if (optional.isPresent()) {
			
			exame = optional.get();
			
			return ResponseEntity.ok(exame);
		}

		return ResponseEntity.notFound().build();
	}
}

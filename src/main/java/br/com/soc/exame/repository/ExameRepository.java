package br.com.soc.exame.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.soc.exame.model.Exame;

@Repository
public interface ExameRepository extends JpaRepository<Exame, Long> {
}
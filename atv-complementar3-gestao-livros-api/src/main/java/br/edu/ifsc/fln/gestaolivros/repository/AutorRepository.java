package br.edu.ifsc.fln.gestaolivros.repository;

import br.edu.ifsc.fln.gestaolivros.model.domain.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Integer> {
}

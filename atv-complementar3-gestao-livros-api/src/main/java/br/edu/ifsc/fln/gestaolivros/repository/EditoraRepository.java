package br.edu.ifsc.fln.gestaolivros.repository;

import br.edu.ifsc.fln.gestaolivros.model.domain.Editora;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EditoraRepository extends JpaRepository<Editora, Integer> {
    List<Editora> findByNome(String nome);
    List<Editora> findByNomeContaining(String nome);
}

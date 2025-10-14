package br.edu.ifsc.fln.gestaolivros.api.controller;

import br.edu.ifsc.fln.gestaolivros.model.domain.Autor;
import br.edu.ifsc.fln.gestaolivros.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    private AutorRepository autorRepository;

    @GetMapping
    public List<Autor> findAll() {
        return autorRepository.findAll();
    }

    @PostMapping
    public Autor criarAutor(@RequestBody Autor autor) {
        return autorRepository.save(autor);
    }

    @GetMapping("/{id}")
    public Autor buscarPorId(@PathVariable Integer id) {
        return autorRepository.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Integer id) {
        autorRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public Autor atualizarAutor(@PathVariable Integer id, @RequestBody Autor autor) {
        autor.setId(id);
        return autorRepository.save(autor);
    }

}

package br.edu.ifsc.fln.gestaolivros.api.controller;

import br.edu.ifsc.fln.gestaolivros.model.domain.Livro;
import br.edu.ifsc.fln.gestaolivros.repository.AutorRepository;
import br.edu.ifsc.fln.gestaolivros.repository.EditoraRepository;
import br.edu.ifsc.fln.gestaolivros.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {
    @Autowired
    private LivroRepository livroRepository;
    @Autowired
    private AutorRepository autorRepository;
    @Autowired
    private EditoraRepository editoraRepository;

    @GetMapping
    public List<Livro> listaLivros() {
        return livroRepository.findAll();
    }

    @PostMapping
    public Livro criarLivro(@RequestBody Livro livro) {
        livro.calcularPrecoDeVenda();
        livro = livroRepository.save(livro);
        livro.setAutor(autorRepository.findById(livro.getAutor().getId()).get());
        livro.setEditora(editoraRepository.findById(livro.getEditora().getId()).get());
        return livro;
    }

    @GetMapping("/{id}")
    public Livro buscarLivroPorId(@PathVariable Integer id) {
        return livroRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Livro atualizarLivro(@PathVariable Integer id, @RequestBody Livro livro) {
        livro.setId(id);
        livro.calcularPrecoDeVenda();
        livro = livroRepository.save(livro);
        livro.setAutor(autorRepository.findById(livro.getAutor().getId()).get());
        livro.setEditora(editoraRepository.findById(livro.getEditora().getId()).get());
        return livro;
    }

    @DeleteMapping("/{id}")
    public void deletarLivro(@PathVariable Integer id) {
        livroRepository.deleteById(id);
    }
}

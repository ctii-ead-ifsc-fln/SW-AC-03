package br.edu.ifsc.fln.gestaolivros.api.controller;

import br.edu.ifsc.fln.gestaolivros.model.domain.Editora;
import br.edu.ifsc.fln.gestaolivros.repository.EditoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/editoras")
public class EditoraController {

    @Autowired
    private EditoraRepository editoraRepository;

    @GetMapping
    public List<Editora> listarEditoras() {
        return editoraRepository.findAll();
    }

    @GetMapping("/{id}")
    public Editora getEditora(@PathVariable int id) {
        return editoraRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Editora criarEditora(@RequestBody Editora editora) {
        return editoraRepository.save(editora);
    }

    @PutMapping("/{id}")
    public Editora atualizarEditora(@PathVariable Integer id, @RequestBody Editora editora) {
        editora.setId(id);
        return editoraRepository.save(editora);
    }

    @DeleteMapping("/{id}")
    public void deletarEditora(@PathVariable Integer id) {
        editoraRepository.deleteById(id);
    }

    @GetMapping("/nome/{nome}")
    public List<Editora> procurarEditorasPorNome(@PathVariable String nome) {
        return editoraRepository.findByNomeContaining(nome);
    }
}

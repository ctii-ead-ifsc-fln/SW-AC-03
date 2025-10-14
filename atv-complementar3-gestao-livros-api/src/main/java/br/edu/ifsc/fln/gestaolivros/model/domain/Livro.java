package br.edu.ifsc.fln.gestaolivros.model.domain;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Livro {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String titulo;
    private String isbn;
    private BigDecimal precoDeCusto;
    private BigDecimal precoDeVenda;
    private BigDecimal margemDeLucro;
    private LocalDate dataDeCadastro;

    @Enumerated(EnumType.STRING)
    private StatusLivro status;

    @ManyToOne
    @JoinColumn(name = "id_autor")
    private Autor autor;

    @ManyToOne
    @JoinColumn(name = "id_editora")
    private Editora editora;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public BigDecimal getPrecoDeCusto() {
        return precoDeCusto;
    }

    public void setPrecoDeCusto(BigDecimal precoDeCusto) {
        this.precoDeCusto = precoDeCusto;
    }

    public BigDecimal getPrecoDeVenda() {
        calcularPrecoDeVenda();
        return precoDeVenda;
    }

    public BigDecimal getMargemDeLucro() {
        return margemDeLucro;
    }

    public void setMargemDeLucro(BigDecimal margemDeLucro) {
        this.margemDeLucro = margemDeLucro;
    }

    public LocalDate getDataDeCadastro() {
        return dataDeCadastro;
    }

    public void setDataDeCadastro(LocalDate dataDeCadastro) {
        this.dataDeCadastro = dataDeCadastro;
    }

    public StatusLivro getStatus() {
        return status;
    }

    public void setStatus(StatusLivro status) {
        this.status = status;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Editora getEditora() {
        return editora;
    }

    public void setEditora(Editora editora) {
        this.editora = editora;
    }

    public void calcularPrecoDeVenda() {
        this.precoDeVenda = this.precoDeCusto.add(this.precoDeCusto.multiply(this.margemDeLucro.divide(BigDecimal.valueOf(100))));
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Livro livro = (Livro) o;
        return Objects.equals(id, livro.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return titulo;
    }
}

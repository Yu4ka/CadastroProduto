package dev.java10x.CadastroProduto.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_produto")
@Entity
public class ProdutoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long Id;
    @Column(name = "descrição")
    private String descricao;
    @Column(name = "preço")
    private Double preco;
    @Column(name = "quantidade")
    private int quantidade;
}

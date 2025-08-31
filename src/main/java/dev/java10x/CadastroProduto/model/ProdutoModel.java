package dev.java10x.CadastroProduto.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_produto")
@Entity
@ToString(exclude = "fornecedorModel")
public class ProdutoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "descrição")
    private String descricao;

    @Column(name = "preço")
    private Double preco;

    @Column(name = "quantidade")
    private int quantidade;

    @Column(name = "img_url")
    private String img_url;

    @ManyToOne
    @JoinColumn(name = "fornecedorId")
    private FornecedorModel fornecedorModel;
}

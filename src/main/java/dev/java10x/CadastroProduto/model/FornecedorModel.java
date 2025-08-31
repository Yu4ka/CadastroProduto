package dev.java10x.CadastroProduto.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name = "tb_fornecedor")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class FornecedorModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "email")
    private String email;

    @Column (name = "telefone")
    private String telefone;

    @OneToMany(mappedBy = "fornecedorModel")
    @JsonIgnore
    private List<ProdutoModel> produtos;

}

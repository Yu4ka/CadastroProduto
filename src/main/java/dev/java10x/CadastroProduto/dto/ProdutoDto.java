package dev.java10x.CadastroProduto.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoDto {
    private Long id;
    private String descricao;
    private Double preco;
    private int quantidade;
    private String img_url;
}

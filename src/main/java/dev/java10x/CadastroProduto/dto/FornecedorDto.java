package dev.java10x.CadastroProduto.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FornecedorDto {
    private Long id;
    private String nome;
    private String email;
    private String telefone;
}

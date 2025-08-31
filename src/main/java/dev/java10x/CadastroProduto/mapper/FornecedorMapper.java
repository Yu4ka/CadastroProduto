package dev.java10x.CadastroProduto.mapper;

import dev.java10x.CadastroProduto.dto.FornecedorDto;
import dev.java10x.CadastroProduto.model.FornecedorModel;
import org.springframework.stereotype.Component;

@Component
public class FornecedorMapper {
    public FornecedorDto map(FornecedorModel fornecedorModel){
        FornecedorDto fornecedorDto = new FornecedorDto();
        fornecedorDto.setId(fornecedorModel.getId());
        fornecedorDto.setNome(fornecedorModel.getNome());
        fornecedorDto.setEmail(fornecedorModel.getEmail());
        fornecedorDto.setTelefone(fornecedorModel.getTelefone());
        return fornecedorDto;
    }

    public FornecedorModel map(FornecedorDto fornecedorDto){
        FornecedorModel fornecedorModel = new FornecedorModel();
        fornecedorModel.setId(fornecedorDto.getId());
        fornecedorModel.setNome(fornecedorDto.getNome());
        fornecedorModel.setEmail(fornecedorDto.getEmail());
        fornecedorModel.setTelefone(fornecedorDto.getTelefone());
        return fornecedorModel;
    }
}

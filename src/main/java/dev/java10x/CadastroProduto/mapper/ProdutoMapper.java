package dev.java10x.CadastroProduto.mapper;

import dev.java10x.CadastroProduto.dto.ProdutoDto;
import dev.java10x.CadastroProduto.model.ProdutoModel;
import org.springframework.stereotype.Component;

@Component
public class ProdutoMapper {

    private ProdutoDto map(ProdutoModel produtoModel){
        ProdutoDto produtoDto = new ProdutoDto();
        produtoDto.setId(produtoModel.getId());
        produtoDto.setDescricao(produtoModel.getDescricao());
        produtoDto.setPreco(produtoModel.getPreco());
        produtoDto.setQuantidade(produtoModel.getQuantidade());
        produtoDto.setImg_url(produtoModel.getImg_url());
        return produtoDto;
    }

    private ProdutoModel map(ProdutoDto produtoDto){
        ProdutoModel produtoModel = new ProdutoModel();
        produtoModel.setId(produtoDto.getId());
        produtoModel.setDescricao(produtoDto.getDescricao());
        produtoModel.setPreco(produtoDto.getPreco());
        produtoModel.setQuantidade(produtoDto.getQuantidade());
        produtoModel.setImg_url(produtoDto.getImg_url());
        return produtoModel;
    }
}

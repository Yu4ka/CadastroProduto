package dev.java10x.CadastroProduto.service;

import dev.java10x.CadastroProduto.dto.ProdutoDto;
import dev.java10x.CadastroProduto.mapper.ProdutoMapper;
import dev.java10x.CadastroProduto.model.ProdutoModel;
import dev.java10x.CadastroProduto.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProdutoService {
    private final ProdutoRepository produtoRepository;
    private final ProdutoMapper produtoMapper;

    public ProdutoService(ProdutoRepository produtoRepository, ProdutoMapper produtoMapper) {
        this.produtoRepository = produtoRepository;
        this.produtoMapper = produtoMapper;
    }

    public List<ProdutoDto> listarTodos() {
        return produtoRepository.findAll()
                .stream()
                .map(produtoMapper::map)
                .collect(Collectors.toList());
    }
}

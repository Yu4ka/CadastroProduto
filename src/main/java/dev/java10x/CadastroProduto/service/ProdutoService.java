package dev.java10x.CadastroProduto.service;

import dev.java10x.CadastroProduto.dto.ProdutoDto;
import dev.java10x.CadastroProduto.mapper.ProdutoMapper;
import dev.java10x.CadastroProduto.model.ProdutoModel;
import dev.java10x.CadastroProduto.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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

    public ProdutoDto criarProduto(ProdutoDto produtoDto) {
        ProdutoModel produto = produtoMapper.map(produtoDto);
        produto = produtoRepository.save(produto);
        return produtoMapper.map(produto);
    }

    public ProdutoDto listarPorId(Long id) {
        return produtoRepository.findById(id)
                .map(produtoMapper::map).orElse(null);
    }

    public void deletarProduto(Long id) {
        produtoRepository.deleteById(id);
    }

    public ProdutoDto atualizarProduto(Long id, ProdutoDto produtoDto) {
        Optional<ProdutoModel> produtoExistente = produtoRepository.findById(id);
        if(produtoExistente.isPresent()){
            ProdutoModel produtoAtualizado = produtoMapper.map(produtoDto);
            produtoAtualizado.setId(id);
            ProdutoModel produtoModel = produtoRepository.save(produtoAtualizado);
            return produtoMapper.map(produtoModel);
        }
        return null;
    }
}

package dev.java10x.CadastroProduto.service;

import dev.java10x.CadastroProduto.mapper.FornecedorMapper;
import dev.java10x.CadastroProduto.repository.FornecedorRepository;
import org.springframework.stereotype.Service;

@Service
public class FornecedorService {
    private final FornecedorRepository fornecedorRepository;
    private final FornecedorMapper fornecedorMapper;

    public FornecedorService(FornecedorRepository fornecedorRepository, FornecedorMapper fornecedorMapper) {
        this.fornecedorRepository = fornecedorRepository;
        this.fornecedorMapper = fornecedorMapper;
    }
}

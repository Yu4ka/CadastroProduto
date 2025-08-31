package dev.java10x.CadastroProduto.controller;

import dev.java10x.CadastroProduto.mapper.FornecedorMapper;
import dev.java10x.CadastroProduto.service.FornecedorService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("fornecedor")
public class FornecedorController {
    private final FornecedorService fornecedorService;
    private final FornecedorMapper fornecedorMapper;

    public FornecedorController(FornecedorService fornecedorService, FornecedorMapper fornecedorMapper) {
        this.fornecedorService = fornecedorService;
        this.fornecedorMapper = fornecedorMapper;
    }

}

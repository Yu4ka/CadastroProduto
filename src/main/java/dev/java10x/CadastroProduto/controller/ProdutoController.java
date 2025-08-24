package dev.java10x.CadastroProduto.controller;

import dev.java10x.CadastroProduto.dto.ProdutoDto;
import dev.java10x.CadastroProduto.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("produto")
public class ProdutoController {
    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<ProdutoDto>> listarTodos(){
        List<ProdutoDto> produtoDtoList = produtoService.listarTodos();
        return ResponseEntity.ok(produtoDtoList);
    }
}

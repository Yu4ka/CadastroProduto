package dev.java10x.CadastroProduto.controller;

import dev.java10x.CadastroProduto.dto.ProdutoDto;
import dev.java10x.CadastroProduto.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/listar/{id}")
    public ResponseEntity<ProdutoDto> listarPorId(@PathVariable Long id){
        ProdutoDto produtoDto = produtoService.listarPorId(id);
        return ResponseEntity.ok(produtoDto);
    }

    @PostMapping("/criar")
    public ResponseEntity<String> criarProduto(@RequestBody ProdutoDto produtoDto){
        ProdutoDto produtoNovo = produtoService.criarProduto(produtoDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Produto novo com Id: "+ produtoNovo.getId() + " criado com sucesso!");
    }


}

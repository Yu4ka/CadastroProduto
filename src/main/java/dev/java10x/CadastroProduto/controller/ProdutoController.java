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
    public ResponseEntity<?> listarPorId(@PathVariable Long id) {
        ProdutoDto produtoDto = produtoService.listarPorId(id);
        if (produtoDto != null) {
            return ResponseEntity.ok(produtoDto);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado.");
        }
    }

    @PostMapping("/criar")
    public ResponseEntity<String> criarProduto(@RequestBody ProdutoDto produtoDto){
        ProdutoDto produtoNovo = produtoService.criarProduto(produtoDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Produto novo com Id: %s criado com sucesso!".formatted(produtoNovo.getId()));
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarProduto(@PathVariable Long id){
        if(produtoService.listarPorId(id) != null){
            produtoService.deletarProduto(id);
            return ResponseEntity.ok("Produto com ID: %s deletado com sucesso".formatted(id));
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado.");
        }
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<?> atualizarProduto(@PathVariable Long id, @RequestBody ProdutoDto produtoDto){
        ProdutoDto produtoDtoNovo = produtoService.atualizarProduto(id, produtoDto);
        if(produtoDtoNovo != null){
            return ResponseEntity.ok(produtoDtoNovo);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Produto com ID: %s não encontrado".formatted(id));
        }
    }
}

package dev.java10x.CadastroProduto.controller;

import dev.java10x.CadastroProduto.dto.FornecedorDto;
import dev.java10x.CadastroProduto.mapper.FornecedorMapper;
import dev.java10x.CadastroProduto.service.FornecedorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("fornecedor")
public class FornecedorController {
    private final FornecedorService fornecedorService;
    private final FornecedorMapper fornecedorMapper;

    public FornecedorController(FornecedorService fornecedorService, FornecedorMapper fornecedorMapper) {
        this.fornecedorService = fornecedorService;
        this.fornecedorMapper = fornecedorMapper;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<FornecedorDto>> listarTodos(){
        List<FornecedorDto> fornecedorDtos = fornecedorService.listarTodos();
        return ResponseEntity.ok(fornecedorDtos);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarPorId(@PathVariable Long id){
        FornecedorDto fornecedorDto = fornecedorService.listarPorId(id);
        if(fornecedorDto != null) {
            return ResponseEntity.ok(fornecedorDto);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Fornecedor com ID: %s não encontrado".formatted(id));
        }
    }

    @PostMapping("/criar")
    public ResponseEntity<String> criarFornecedor(@RequestBody FornecedorDto fornecedorDto){
        FornecedorDto fornecedorNovo = fornecedorService.criarFornecedor(fornecedorDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Fornecedor novo com Id: %s criado com sucesso!".formatted(fornecedorNovo.getId()));
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarFornecedor(@PathVariable Long id){
        if(fornecedorService.listarPorId(id) != null){
            fornecedorService.deletarPorId(id);
            return ResponseEntity.ok("Deletado com sucesso!");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Fornecedor com ID: %s não encontrado".formatted(id));
        }
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<?> atualizarFornecedor(@PathVariable Long id, @RequestBody FornecedorDto fornecedorDto){
        FornecedorDto fornecedorNovo = fornecedorService.atualizarFornecedor(id, fornecedorDto);
        if(fornecedorNovo != null){
            return ResponseEntity.ok(fornecedorDto);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Fornecedor com ID: %s não encontrado".formatted(id));
        }
    }
}

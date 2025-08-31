package dev.java10x.CadastroProduto.controller;

import dev.java10x.CadastroProduto.dto.FornecedorDto;
import dev.java10x.CadastroProduto.dto.ProdutoDto;
import dev.java10x.CadastroProduto.service.FornecedorService;
import dev.java10x.CadastroProduto.service.ProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("produto/ui")
public class ProdutoControllerUI {

    private final ProdutoService produtoService;
    private final FornecedorService fornecedorService;

    public ProdutoControllerUI(ProdutoService produtoService, FornecedorService fornecedorService) {
        this.produtoService = produtoService;
        this.fornecedorService = fornecedorService;
    }

    @GetMapping("/listar")
    public String listarTodos(Model model){
        List<ProdutoDto> produtoDtoList = produtoService.listarTodos();
        model.addAttribute("produtos", produtoDtoList);
        return "listarProdutos";
    }

    @GetMapping("/listar/{id}")
    public String listarPorId(@PathVariable Long id, Model model) {
        ProdutoDto produtoDto = produtoService.listarPorId(id);
        if (produtoDto != null) {
            model.addAttribute("produto", produtoDto);
            return "detalheProduto";
        }else{
            model.addAttribute("mensagem", "Produto não encontrado");
            return "listarProdutos";
        }
    }

    @GetMapping("/adicionar")
    public String mostrarFormulario(Model model){
        model.addAttribute("produto", new ProdutoDto());
        List<FornecedorDto> fornecedorDtos = fornecedorService.listarTodos();
        model.addAttribute("fornecedores", fornecedorDtos);
        return "adicionarProduto";
    }

    @PostMapping("/salvar")
    public String criarProduto(@ModelAttribute ProdutoDto produtoDto, RedirectAttributes redirectAttributes){
        produtoService.criarProduto(produtoDto);
        redirectAttributes.addFlashAttribute("mensagem", "Produto criado com sucesso!");
        return "redirect:/produto/ui/listar";
    }

    @GetMapping("/atualizar/{id}")
    public String atualizarFormulario(@PathVariable Long id, Model model){
        ProdutoDto produtoDto = produtoService.listarPorId(id);
        model.addAttribute("produto", produtoDto);
        List<FornecedorDto> fornecedorDtos = fornecedorService.listarTodos();
        model.addAttribute("fornecedores", fornecedorDtos);
        return "atualizarProduto";
    }

    @PutMapping("/editar")
    public String editar(@ModelAttribute ProdutoDto produtoDto){
        ProdutoDto produtoDtoNovo = produtoService.atualizarProdutoUI(produtoDto);
        return "redirect:/produto/ui/listar";
    }



    @GetMapping("/deletar/{id}")
    public String deletarProduto(@PathVariable Long id){
        produtoService.deletarProduto(id);
        return "redirect:/produto/ui/listar";
    }
}

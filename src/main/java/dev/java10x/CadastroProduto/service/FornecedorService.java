package dev.java10x.CadastroProduto.service;

import dev.java10x.CadastroProduto.dto.FornecedorDto;
import dev.java10x.CadastroProduto.mapper.FornecedorMapper;
import dev.java10x.CadastroProduto.model.FornecedorModel;
import dev.java10x.CadastroProduto.repository.FornecedorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FornecedorService {
    private final FornecedorRepository fornecedorRepository;
    private final FornecedorMapper fornecedorMapper;

    public FornecedorService(FornecedorRepository fornecedorRepository, FornecedorMapper fornecedorMapper) {
        this.fornecedorRepository = fornecedorRepository;
        this.fornecedorMapper = fornecedorMapper;
    }

    public List<FornecedorDto> listarTodos() {
        return fornecedorRepository.findAll().stream()
                .map(fornecedorMapper::map)
                .collect(Collectors.toList());
    }

    public FornecedorDto criarFornecedor(FornecedorDto fornecedorDto) {
        FornecedorModel fornecedorModel = fornecedorMapper.map(fornecedorDto);
        fornecedorModel = fornecedorRepository.save(fornecedorModel);
        return fornecedorMapper.map(fornecedorModel);
    }

    public FornecedorDto listarPorId(Long id) {
        return fornecedorRepository.findById(id)
                .map(fornecedorMapper::map)
                .orElse(null);
    }

    public void deletarPorId(Long id) {
        fornecedorRepository.deleteById(id);
    }

    public FornecedorDto atualizarFornecedor(Long id, FornecedorDto fornecedorDto) {
        Optional<FornecedorModel> fornecedorModel = fornecedorRepository.findById(id);
        if(fornecedorModel.isPresent()){
            FornecedorModel fornecedorNovo = fornecedorMapper.map(fornecedorDto);
            fornecedorNovo.setId(id);
            FornecedorModel fornecedorAtualizado = fornecedorRepository.save(fornecedorNovo);
            return fornecedorMapper.map(fornecedorAtualizado);
        }
        return null;
    }
}

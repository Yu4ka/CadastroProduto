package dev.java10x.CadastroProduto.repository;

import dev.java10x.CadastroProduto.model.FornecedorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FornecedorRepository extends JpaRepository<FornecedorModel, Long> {
}

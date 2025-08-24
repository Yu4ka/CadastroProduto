package dev.java10x.CadastroProduto.repository;

import dev.java10x.CadastroProduto.model.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Long, ProdutoModel> {
}

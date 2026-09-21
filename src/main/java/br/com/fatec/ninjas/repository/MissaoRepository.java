package br.com.fatec.ninjas.repository;

import br.com.fatec.ninjas.model.Missao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MissaoRepository extends JpaRepository<Missao, Long> {
    void deleteById(Long id_missao);

    Missao save(Missao missao);

    List<Missao> findAll();

    Optional<Missao> findById(Long id_missao);

    Missao findByTitulo(String titulo);

    List<Missao> findByDescricaoContaining(String descricao);
}

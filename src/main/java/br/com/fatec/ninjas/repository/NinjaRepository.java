package br.com.fatec.ninjas.repository;

import br.com.fatec.ninjas.model.Ninja;
import org.springframework.data.jpa.repository.JpaRepository;

// interface servem como contratos para os métodos
// Herdamos do Jpa todas as operações (query methods), como save, delete etc
public interface NinjaRepository extends JpaRepository<Ninja, Long> {
}

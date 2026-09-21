package br.com.fatec.ninjas.controller;


import br.com.fatec.ninjas.model.Missao;
import br.com.fatec.ninjas.service.MissaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/missao")
public class MissaoController {

    @Autowired
    private MissaoService missaoService;

    @PostMapping
    public Missao cadastrarMissao(@Valid @RequestBody Missao missao){
        return missaoService.cadastrarMissao(missao);
    }

    @GetMapping
    public List<Missao> listarMissao() {
        return missaoService.listarMissao();
    }

    @GetMapping("/id/{id}")
    public Optional<Missao> pesquisarMissao(@PathVariable("id") Long id_missao){
        return missaoService.pesquisarMissao(id_missao);
    }

    @GetMapping("/titulo/{titulo}")
    public Missao pesquisarMissaoPorNome(@PathVariable String titulo){
        return missaoService.pesquisarMissaoPorNome(titulo);
    }

    @GetMapping("/descricao/{descricao}")
    public List<Missao> pesquisarMissaoPorParteDoNome(@PathVariable String descricao){
        return missaoService.pesquisarMissaoPorParteDoNome(descricao);
    }

    @PutMapping("/{id}")
    public Missao atualizarMissao (@PathVariable("id") Long id_missao, @Valid @RequestBody Missao missao) {
        return missaoService.atualizarMissao(id_missao, missao);
    }

    @DeleteMapping("/{id}")
    public void deletarMissao(@PathVariable("id") Long id_missao){
        missaoService.deletarMissao(id_missao);
    }
}

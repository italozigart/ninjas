package br.com.fatec.ninjas.service;

import br.com.fatec.ninjas.model.Missao;
import br.com.fatec.ninjas.repository.MissaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MissaoService {

    //injeção de dependência do repositório Aluno (como se importasse a Repository para cá, afim de usar seus métodos)
    @Autowired // anotação que indica que estamos injetando uma dependência
    private MissaoRepository missaoRepository;

    // um met. publico que retorna o objeto Ninja. Recebe como parâmetros o Objeto (classe ninja) e instancia um novo objeto
    public Missao cadastrarMissao(Missao missao){
        return missaoRepository.save(missao); // salva o novo objeto
    }

    public void deletarMissao(Long id_missao) {
        missaoRepository.deleteById(id_missao);
    }

    public List<Missao> findAll() {
        return missaoRepository.findAll();
    }

    public Object findById(Long id_missao) { return missaoRepository.findById(id_missao).orElse(null); }

    public List<Missao> listarMissao() {
        return missaoRepository.findAll();
    }

    public Optional<Missao> pesquisarMissao(Long id_missao) { return missaoRepository.findById(id_missao); }

    public Missao pesquisarMissaoPorNome(String titulo) { return missaoRepository.findByTitulo(titulo); }

    public List<Missao> pesquisarMissaoPorParteDoNome(String descricao) { return missaoRepository.findByDescricaoContaining(descricao); }

    public Missao atualizarMissao (Long id_missao, Missao missaoAtualizado){
        Optional<Missao>missaoCadastrado = missaoRepository.findById(id_missao);

        if (missaoCadastrado.isPresent()){
            Missao missao = missaoCadastrado.get();

            missao.setTitulo(missaoAtualizado.getTitulo());
            missao.setDescricao(missaoAtualizado.getDescricao());
            missao.setRank(missaoAtualizado.getRank());
            missao.setStatus(missaoAtualizado.getStatus());
            missao.setRecompensa(missaoAtualizado.getRecompensa());

            return missaoRepository.save(missao);
        }
        return null;
    }
}

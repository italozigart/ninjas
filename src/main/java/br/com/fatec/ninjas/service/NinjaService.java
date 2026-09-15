package br.com.fatec.ninjas.service;

import br.com.fatec.ninjas.model.Ninja;
import br.com.fatec.ninjas.repository.NinjaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    //injeção de dependência do repositório Aluno (como se importasse a Repository para cá, afim de usar seus métodos)
    @Autowired // anotação que indica que estamos injetando uma dependência
    private NinjaRepository ninjaRepository;

    // um met. publico que retorna o objeto Ninja. Recebe como parâmetros o Objeto (classe ninja) e instancia um novo objeto
    public Ninja cadastrarNinja(Ninja ninja){
        return ninjaRepository.save(ninja); // salva o novo objeto
    }

    public void deletarNinja(Long id) {
        ninjaRepository.deleteById(id);
    }

    public List<Ninja> findAll() {
        return ninjaRepository.findAll();
    }
    
    public Ninja findById(Long id) {
        return ninjaRepository.findById(id).orElse(null);
    }

    public List<Ninja> listarNinjas() {
        return ninjaRepository.findAll();
    }

    public Optional<Ninja> pesquisarNinja(Long id) {
        return ninjaRepository.findById(id);
    }

    public Ninja pesquisarNinjaPorNome(String nome) { return ninjaRepository.findByNome(nome); }

    public Ninja pesquisarNinjaPorParteDoNome(String nome) { return ninjaRepository.findByNomeContaining(nome); }

    public Ninja atualizarNinja (Long id, Ninja ninjaAtualizado){
        Optional<Ninja>ninjaCadastrado = ninjaRepository.findById(id);

        if (ninjaCadastrado.isPresent()){
            Ninja ninja = ninjaCadastrado.get();

            ninja.setNome(ninjaAtualizado.getNome());
            ninja.setCpf(ninjaAtualizado.getCpf());
            ninja.setEmail(ninjaAtualizado.getEmail());

            return ninjaRepository.save(ninja);
        }
        return null;
    }
}

package br.com.fatec.ninjas.service;

import br.com.fatec.ninjas.model.Ninja;
import br.com.fatec.ninjas.repository.NinjaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}

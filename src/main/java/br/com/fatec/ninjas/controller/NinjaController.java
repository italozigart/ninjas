package br.com.fatec.ninjas.controller;


import br.com.fatec.ninjas.model.Ninja;
import br.com.fatec.ninjas.service.NinjaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    @Autowired
    private NinjaService ninjaService;

    @PostMapping
    public Ninja cadastrarNinja(@Valid @RequestBody Ninja ninja){
        return ninjaService.cadastrarNinja(ninja);
    }
}

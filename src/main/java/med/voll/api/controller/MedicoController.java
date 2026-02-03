package med.voll.api.controller;

import med.voll.api.medico.DadosCadastroMedico;
import med.voll.api.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    //Atributos
    @Autowired
    private MedicoRepository repository;

    // Metodo
    @PostMapping
    public void cadastrar(@RequestBody DadosCadastroMedico dados) {
//        System.out.println(dados);


    }


}

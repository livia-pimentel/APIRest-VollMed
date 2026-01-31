package med.voll.api.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    // Metodo
    @PostMapping
    public void cadastrar(@RequestBody String json) {
        System.out.println(json);
    }


}

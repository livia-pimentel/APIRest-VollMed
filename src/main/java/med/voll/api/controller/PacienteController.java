package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.medico.DadosDetalhamentoMedico;
import med.voll.api.paciente.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    // Atributos
    @Autowired
    private PacienteRepository pacienteRepository;

    // Metodo
    @PostMapping
    @Transactional
    public ResponseEntity cadastrarPaciente(@RequestBody @Valid DadosCadastroPaciente dados) {
//        System.out.println(dados);
        pacienteRepository.save(new Paciente(dados));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemPaciente>> listarPaciente(@PageableDefault(size = 10, sort = {"nome"})Pageable paginacao) {
        var page =  pacienteRepository.findAllByAtivoTrue(paginacao)
                .map(DadosListagemPaciente::new);

        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizarPaciente(@RequestBody @Valid DadosAtualizarPaciente dados) {
        var paciente = pacienteRepository.getReferenceById(dados.id());

        paciente.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosDetalhamentoPaciente(paciente));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluirPaciente(@PathVariable Long id) {
        // Recupera a informação do paciente no banco
        var paciente = pacienteRepository.getReferenceById(id);

        // Configura para deixar paciente inativo
        paciente.excluirPaciente();

        return ResponseEntity.noContent().build();
    }

}

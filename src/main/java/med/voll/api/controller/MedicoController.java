package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.endereco.Endereco;
import med.voll.api.medico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    //Atributos
    @Autowired
    private MedicoRepository repository;

    // Metodo
    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroMedico dados) {
//        System.out.println(dados);
        repository.save(new Medico(dados));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemMedico>> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
         var page = repository.findAllByAtivoTrue(paginacao)
                .map(DadosListagemMedico::new);

         return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoMedico dados) {
        // Carregar o objeto do banco de dados
        var medico = repository.getReferenceById(dados.id());

        // Atualiza com as informações que vem do DTO
        medico.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosDetalhamentoMedico(medico));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        // Dessa forma excluí mesmo o registro do banco de dados
//        repository.deleteById(id);

        // Faz exclusão lógico para fica como inativo e não excluir o registro do banco
        // Recupera o medico no banco de dados
        var medico = repository.getReferenceById(id);

        // Configura para deixar inativo
        medico.excluir();

        return ResponseEntity.noContent().build();
    }
}

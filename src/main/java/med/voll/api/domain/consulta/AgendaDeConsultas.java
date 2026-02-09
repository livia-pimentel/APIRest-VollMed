package med.voll.api.domain.consulta;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.medico.MedicoRepository;
import med.voll.api.domain.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgendaDeConsultas {
    // Atributos
    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    // Metodos
    public void agendar(DadosAgendamentoConsulta dados) {

        // Se não existe o id, interrompe a aplicação
        if (!pacienteRepository.existsById(dados.idPaciente())) {
            throw new ValidacaoException("Id do paciente informado não existe!");
        }

        if (dados.idMedico() != null &&!medicoRepository.existsById(dados.idMedico())) {
            throw new ValidacaoException("Id do médico informado não existe!");
        }
        // Recupera os dados medico e paciente por id
        var paciente = pacienteRepository.findById(dados.idPaciente()).get(); // Devolve um Optional, usa o get() pegar o obejto que foi carregado

        var medico = medicoRepository.findById(dados.idMedico()).get();

        var consulta = new Consulta(null, medico, paciente, dados.data());
        consultaRepository.save(consulta);
    }

}

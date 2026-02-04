package med.voll.api.paciente;

public record DadosListagemPaciente(String nome, String cpf, String email) {
    // Construtor
    public DadosListagemPaciente(Paciente paciente) {
        this(paciente.getNome(), paciente.getCpf(), paciente.getEmail());
    }
}

package bethacode.clinimais.resource;

import bethacode.clinimais.model.Paciente;

import java.time.LocalDate;

public class PacienteDTO {
    private String id;
    private String nome;
    private String telefone;
    private LocalDate dataNascimento;
    private String cpf;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public static PacienteDTO toDTO(Paciente paciente){
        PacienteDTO dto = new PacienteDTO();
        dto.setId(paciente.getId().toString());
        dto.setNome(paciente.getNome());
        dto.setTelefone(paciente.getTelefone());
        dto.setDataNascimento(paciente.getDataNascimento());
        dto.setCpf(paciente.getCpf());

        return dto;
    }

    public static Paciente fromDTO(PacienteDTO dto){
        Paciente entity = new Paciente();
        entity.setId(Long.getLong(dto.getId()));
        entity.setNome(dto.getNome());
        entity.setTelefone(dto.getTelefone());
        entity.setDataNascimento(dto.getDataNascimento());
        entity.setCpf(dto.getCpf());

        return entity;
    }
}

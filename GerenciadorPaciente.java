package models;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorPaciente {
    private List<Paciente> pacientes;

    public GerenciadorPaciente() {
        this.pacientes = new ArrayList<>();
    }

    public void cadastrarPaciente(Paciente paciente) {
        pacientes.add(paciente);
        System.out.println("Paciente cadastrado com sucesso: " + paciente.getNome());
    }

    public Paciente buscarPacientePorCPF(String cpf) {
        for (Paciente paciente : pacientes) {
            if (paciente.getCpf().equals(cpf)) {
                return paciente;
            }
        }
        return null;
    }

    public List<Paciente> listarPacientes() {
        return pacientes;
    }
}


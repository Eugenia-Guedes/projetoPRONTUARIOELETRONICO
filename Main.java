package main;

import models.Paciente;
import models.Consulta;
import models.services.Exame;
import enums.TipoExame;
import models.GerenciadorPaciente;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    private static GerenciadorPaciente gerenciador = new GerenciadorPaciente(); // Serviço de gerenciamento
    private static Scanner scanner = new Scanner(System.in); // Entrada do usuário

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== Prontuário Eletrônico ===");
            System.out.println("1. Cadastrar Paciente");
            System.out.println("2. Registrar Consulta");
            System.out.println("3. Registrar Exame");
            System.out.println("4. Visualizar Histórico de Paciente");
            System.out.println("5. Listar Todos os Pacientes");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> cadastrarPaciente();
                case 2 -> registrarConsulta();
                case 3 -> registrarExame();
                case 4 -> visualizarHistorico();
                case 5 -> listarPacientes();
                case 6 -> {
                    System.out.println("Encerrando o sistema...");
                    return;
                }
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void cadastrarPaciente() {
        System.out.println("\n=== Cadastro de Paciente ===");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Idade: ");
        int idade = scanner.nextInt();
        scanner.nextLine();

        Paciente paciente = new Paciente(nome, cpf, idade);
        gerenciador.cadastrarPaciente(paciente);
        System.out.println("Paciente cadastrado com sucesso!");
    }

    private static void registrarConsulta() {
        System.out.println("\n=== Registro de Consulta ===");
        System.out.print("CPF do Paciente: ");
        String cpf = scanner.nextLine();

        Paciente paciente = gerenciador.buscarPacientePorCPF(cpf);
        if (paciente == null) {
            System.out.println("Paciente não encontrado.");
            return;
        }

        System.out.print("Diagnóstico: ");
        String diagnostico = scanner.nextLine();
        System.out.print("Receita: ");
        String receita = scanner.nextLine();

        Consulta consulta = new Consulta(new Date(), diagnostico, receita);
        paciente.adicionarConsulta(consulta);
        System.out.println("Consulta registrada com sucesso!");
    }

    private static void registrarExame() {
        System.out.println("\n=== Registro de Exame ===");
        System.out.print("CPF do Paciente: ");
        String cpf = scanner.nextLine();

        Paciente paciente = gerenciador.buscarPacientePorCPF(cpf);
        if (paciente == null) {
            System.out.println("Paciente não encontrado.");
            return;
        }

        System.out.println("Tipos de Exame Disponíveis:");
        for (TipoExame tipo : TipoExame.values()) {
            System.out.println("- " + tipo);
        }

        System.out.print("Escolha o tipo de exame: ");
        String tipoExameStr = scanner.nextLine();
        TipoExame tipoExame;
        try {
            tipoExame = TipoExame.valueOf(tipoExameStr.toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("Tipo de exame inválido.");
            return;
        }

        System.out.print("Data de Agendamento (dd/MM/yyyy): ");
        String dataAgendamentoStr = scanner.nextLine();
        Date agendamento;
        try {
            agendamento = new SimpleDateFormat("dd/MM/yyyy").parse(dataAgendamentoStr);
        } catch (Exception e) {
            System.out.println("Data inválida.");
            return;
        }

        System.out.print("Resultado (opcional): ");
        String resultado = scanner.nextLine();

        Exame exame = new Exame(tipoExame, agendamento, resultado);
        paciente.adicionarExame(exame);
        System.out.println("Exame registrado com sucesso!");
    }

    private static void visualizarHistorico() {
        System.out.println("\n=== Histórico do Paciente ===");
        System.out.print("CPF do Paciente: ");
        String cpf = scanner.nextLine();

        Paciente paciente = gerenciador.buscarPacientePorCPF(cpf);
        if (paciente == null) {
            System.out.println("Paciente não encontrado.");
            return;
        }

        System.out.println("Histórico de " + paciente.getNome() + ":");

        System.out.println("\nConsultas:");
        if (paciente.getConsultas().isEmpty()) {
            System.out.println("- Nenhuma consulta registrada.");
        } else {
            for (Consulta consulta : paciente.getConsultas()) {
                System.out.println("- Data: " + consulta.getData() +
                        ", Diagnóstico: " + consulta.getDiagnostico() +
                        ", Receita: " + consulta.getReceita());
            }
        }

        System.out.println("\nExames:");
        if (paciente.getExames().isEmpty()) {
            System.out.println("- Nenhum exame registrado.");
        } else {
            for (Exame exame : paciente.getExames()) {
                System.out.println("- Tipo: " + exame.getTipo() +
                        ", Agendamento: " + exame.getAgendamento() +
                        ", Resultado: " + exame.getResultado());
            }
        }
    }

    private static void listarPacientes() {
        System.out.println("\n=== Lista de Pacientes ===");
        if (gerenciador.listarPacientes().isEmpty()) {
            System.out.println("Nenhum paciente cadastrado.");
        } else {
            for (Paciente paciente : gerenciador.listarPacientes()) {
                System.out.println("- Nome: " + paciente.getNome() +
                        ", CPF: " + paciente.getCpf() +
                        ", Idade: " + paciente.getIdade());
            }
        }
    }
}




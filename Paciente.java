package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import models.Consulta;

public class Paciente {
    private String nome;
    private String cpf;
    private int idade;
    private List<Consulta> consultas;
    private List<models.services.Exame> exames;

    public Paciente(String nome, String cpf, int idade) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.consultas = new ArrayList<>();
        this.exames = new ArrayList<>();
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public int getIdade() { return idade; }
    public void setIdade(int idade) { this.idade = idade; }

    public List<Consulta> getConsultas() { return consultas; }
    public List<models.services.Exame> getExames() { return exames; }

    public void adicionarConsulta(Consulta consulta) {
        consultas.add(consulta);
    }

    public void adicionarExame(models.services.Exame exame) {
        exames.add(exame);
    }
}







package models.services;

import enums.TipoExame;
import models.Consulta;

import java.util.Date;

public class Exame {
    private TipoExame tipo;
    private Date agendamento;
    private String resultado;

    public Exame(TipoExame tipo, Date agendamento, String resultado) {
        this.tipo = tipo;
        this.agendamento = agendamento;
        this.resultado = resultado;
    }

    public static Consulta[] getConsulta() {
        Consulta[] Consulta = new Consulta[0];
        return Consulta;}

    public TipoExame getTipo() { return tipo; }
    public void setTipo(TipoExame tipo) { this.tipo = tipo; }

    public Date getAgendamento() { return agendamento; }
    public void setAgendamento(Date agendamento) { this.agendamento = agendamento; }

    public String getResultado() { return resultado; }
    public void setResultado(String resultado) { this.resultado = resultado; }

    public boolean isProximo() {
        if (agendamento == null) {
            return false;
        }

        long diff = agendamento.getTime() - new Date().getTime();
        return diff <= 7 * 24 * 60 * 60 * 1000 && diff >= 0;
    }

    @Override
    public String toString() {
        return "Exame{" +
                "tipo=" + tipo +
                ", agendamento=" + agendamento +
                ", resultado='" + resultado + '\'' +
                '}';
    }

    public boolean isEmpty() {
    return false;}
}




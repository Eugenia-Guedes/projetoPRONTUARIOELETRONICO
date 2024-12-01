package models;

import java.util.Date;

public class Consulta {
    private Date data;
    private String diagnostico;
    private String receita;

    public Consulta(Date data, String diagnostico, String receita) {
        this.data = data;
        this.diagnostico = diagnostico;
        this.receita = receita;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getReceita() {
        return receita;
    }

    public void setReceita(String receita) {
        this.receita = receita;
    }

    @Override
    public String toString() {
        return "Consulta{" +
                "data=" + data +
                ", diagnostico='" + diagnostico + '\'' +
                ", receita='" + receita + '\'' +
                '}';
    }
}



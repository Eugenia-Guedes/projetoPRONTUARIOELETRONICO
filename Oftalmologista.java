package models;

public class Oftalmologista extends Medico {
    public Oftalmologista(String nome, String crm) {
        super(nome, crm);
    }

    @Override
    public void realizarAtendimento() {
        System.out.println("Realizando consulta oftalmológica.");
    }
}

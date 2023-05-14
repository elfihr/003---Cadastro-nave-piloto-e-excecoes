package Classes;

public class Aeronave {

    private String modelo;
    private String numeroSerie;

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public String naves() {
        return "\nMODELO: " + modelo + " NUMERO DE SERIE:" + numeroSerie;
    }
}

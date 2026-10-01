package br.com.starlog.model;

import java.util.Locale;
import java.util.Objects;

public class Carga {
    private String codigoRastreio;
    private String categoria;
    private double pesoKg;
    private double valorSeguro;

    public Carga(String codigoRastreio, String categoria, double pesoKg, double valorSeguro) {
        if (codigoRastreio == null || codigoRastreio.trim().isEmpty()){
            throw new IllegalArgumentException(
                    "Codigo de rastreio da carga nao pode ser nulo ou vazio."
            );
        }

        if(pesoKg <= 0){
            throw new IllegalArgumentException("Peso da carga deve ser maior que zero.");
        }

        this.codigoRastreio = codigoRastreio;
        this.categoria = categoria;
        this.pesoKg = pesoKg;
        this.valorSeguro = valorSeguro;
    }

    public String getCodigoRastreio() {
        return codigoRastreio;
    }

    public String getCategoria() {
        return categoria;
    }

    public double getPesoKg() {
        return pesoKg;
    }

    public double getValorSeguro() {
        return valorSeguro;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setPesoKg(double pesoKg) {
        this.pesoKg = pesoKg;
    }

    public void setValorSeguro(double valorSeguro) {
        this.valorSeguro = valorSeguro;
    }

    @Override
    public String toString() {
        return String.format(Locale.US, //como q printa double
                "Carga [rastreio=%s, categoria=%s, peso=%.1fKg, seguro=R$%.2f]", //descobri
                codigoRastreio, categoria, pesoKg, valorSeguro);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Carga carga = (Carga) o;
        return Objects.equals(codigoRastreio, carga.codigoRastreio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigoRastreio);
    }
}

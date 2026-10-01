package br.com.starlog.model;

import br.com.starlog.exception.CapacidadeExcedidaException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

    public class ModuloCarga {
        private String idModulo;
        private int capacidadeMaxima;
        private List<Carga> cargas = new ArrayList<>();

        public ModuloCarga(String idModulo, int capacidadeMaxima) {
            this.idModulo = idModulo;
            this.capacidadeMaxima = capacidadeMaxima;
        }

        public void carregarCarga(Carga carga) throws CapacidadeExcedidaException {
            Objects.requireNonNull(carga, "Item nao pode ser nulo.");
            if(cargas.size() >= capacidadeMaxima) {
                throw new CapacidadeExcedidaException(
                        "Excecao capturada: Modulo '" + idModulo + "' atingiu a capacidade maxima de " + capacidadeMaxima + " cargas."
                );
            }
            cargas.add(carga);
        }

        public double calcularSeguroTotal() {
            return cargas.stream()
                    .mapToDouble(Carga::getValorSeguro)
                    .sum();
        }

        public long contarPorCategoria(String categoria) {
            return cargas.stream()
                    .filter(c -> categoria != null &&
                            categoria.equalsIgnoreCase(c.getCategoria()))
                    .count();
        }

        public double calcularSeguroPesadas(String categoria, double pesoMinimo){
            return cargas.stream()
                    .filter(c -> categoria != null &&
                            categoria.equalsIgnoreCase(c.getCategoria()) &&
                            c.getPesoKg() > pesoMinimo)
                    .mapToDouble(Carga::getValorSeguro)
                    .sum();
        }

        public String getIdModulo() {
            return idModulo;
        }

        public int getCapacidadeMaxima() {
            return capacidadeMaxima;
        }

        public List<Carga> getCargas() {
            return cargas;
        }
    }

package br.com.starlog.model;

import java.util.HashMap;
import java.util.Map;

public class BaseLancamento {
    private Map<String, ModuloCarga> modulos = new HashMap<>();

    public BaseLancamento() {
        this.modulos = new HashMap<>();
    }

    public void cadastrarModulo(ModuloCarga modulo) {
        modulos.put(modulo.getIdModulo(), modulo);
    }

    public Map<String, ModuloCarga> getModulos() {
        return modulos;
    }

    public ModuloCarga buscarModulo(String idModulo) {
        return modulos.get(idModulo);
    }
}

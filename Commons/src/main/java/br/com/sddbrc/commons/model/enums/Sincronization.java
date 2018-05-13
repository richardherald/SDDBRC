package br.com.sddbrc.commons.model.enums;

public enum Sincronization {
    NAO_SINCRONIZADO(1), SINCRONIZADO(2);
    private int codigo;

    Sincronization(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return this.codigo;
    }
}

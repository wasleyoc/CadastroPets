package services;

public enum Tipos {
    GATO("Gato"),
    CACHORRO("Cachorro"),
    PASSARO("Pássaro"),
    PEIXE("Peixe"),
    REPTIL("Réptil"),
    OUTRO("Outro");

    private String tipo;

    Tipos(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }
}

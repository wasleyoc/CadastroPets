package src;

public enum PetsType {
    CACHORRO(1,"Cachorro"),
    GATO(2, "Gato");

    private int id;
    private String name;

    PetsType(int id, String name) {
        this.id = id;
        this.name = name;
    }

}

package src;

public enum PetsSex {
    MACHO(1, "Macho"),
    FEMEA(2,"Fêmea");

    private int i;
    private String sexo;


    PetsSex(int i, String sexo) {
        i = this.i;
        sexo = this.sexo;
    }
}

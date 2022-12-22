package fr.revoltinvoc.vatiraskyrun.kits;

public enum KitsManager {
    DEFAULT(0, "Default"),
    RUSHEUR(1, "Rusheur"),
    HEALER(2, "Healer");

    private int id;
    private String name;


    KitsManager(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

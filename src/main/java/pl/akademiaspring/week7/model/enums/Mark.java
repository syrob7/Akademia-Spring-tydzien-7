package pl.akademiaspring.week7.model.enums;

public enum Mark {
    ALFA_ROMEO("Alfa Romeo"),
    HONDA("Honda"),
    OPEL("Opel"),
    FORD("Ford"),
    MERCEDES("Mercedes"),
    RENAULT("Renault"),
    TOYOTA("Toyota");

    private String mark;

    Mark(String mark) {
        this.mark = mark;
    }

    public String getMark() {
        return mark;
    }
}

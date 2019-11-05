package pl.akademiaspring.week7.model.enums;

public enum Color {
    WHITE("White"),
    RED("Red"),
    BLACK("Black"),
    BLUE("Blue");

    private final String color;

    private Color(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

}

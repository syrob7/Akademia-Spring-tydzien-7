package pl.akademiaspring.week7.model;

import pl.akademiaspring.week7.model.enums.Color;
import pl.akademiaspring.week7.model.enums.Mark;

public class Car {

    private long carId;
    private Mark mark;
    private String model;
    private Color color;
    private int productionYear;

    public Car(long carId, String mark, String model, String color, int productionYear) {
        this.carId = carId;
        this.mark = Mark.valueOf(mark);
        this.model = model;
        this.color = Color.valueOf(color);
        this.productionYear = productionYear;
    }

    public Car(Mark mark, String model, Color color, int productionYear) {
        this.mark = mark;
        this.model = model;
        this.color = color;
        this.productionYear = productionYear;
    }

    public Car() {
    }

    public long getCarId() {
        return carId;
    }

    public void setCarId(long carId) {
        this.carId = carId;
    }

    public Mark getMark() {
        return mark;
    }

    public void setMark(Mark mark) {
        this.mark = mark;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carId=" + carId +
                ", mark='" + mark + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", productionYear=" + productionYear +
                '}';
    }
}

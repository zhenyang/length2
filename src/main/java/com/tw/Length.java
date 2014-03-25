package com.tw;

public class Length {
    private final Unit unit;
    private double quantity;

    public Length(double quantity, Unit unit) {
        this.quantity = quantity;
        this.unit = unit;
    }

    @Override
    public boolean equals(Object o) {
        Length length = (Length) o;
        double lengthQuantityInM = length.unit.quantityInM(length.quantity);
        double thisQuantityInM = this.unit.quantityInM(this.quantity);
        return Double.compare(lengthQuantityInM, thisQuantityInM) == 0;
    }

}

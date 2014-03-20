package com.tw;

public class Length {
    private double quantity;
    private String unit;

    public Length(double quantity, String unit) {
        this.quantity = quantity;
        this.unit = unit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Length length = (Length) o;
        double lengthQuantityInM = quantityInM(length.quantity, length.unit);
        double thisQuantityInM = quantityInM(this.quantity, this.unit);
        return Double.compare(lengthQuantityInM, thisQuantityInM) == 0;
    }

    private double quantityInM(double quantity1, String unit1) {
        double lengthQuantityInM = quantity1;
        if (unit1.equals("cm")) {
            lengthQuantityInM = quantity1 / 100;
        }
        if (unit1.equals("mm")) {
            lengthQuantityInM = quantity1 / 1000;
        }
        return lengthQuantityInM;
    }

}

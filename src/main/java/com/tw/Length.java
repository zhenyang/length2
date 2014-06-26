package com.tw;

public class Length {

    private final double value;
    private final String unit;

    public Length(double value, String unit) {
        this.value = value;
        this.unit = unit;
    }

    @Override
    public boolean equals(Object obj) {
        Length length = (Length) obj;
        return toMM(this) == toMM(length);
    }

    public Length add(Length added) {
        return new Length(toMM(this) + toMM(added), "mm");
    }

    public Length subtract(Length another) {
        return new Length(toMM(this) - toMM(another), "mm");
    }

    private double toMM(Length length) {
        if (length.unit.equals("m")) {
            return 1000 * length.value;
        }
        if (length.unit.equals("cm")) {
            return 10 * length.value;
        }
        return length.value;
    }
}

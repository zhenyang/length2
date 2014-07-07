package com.tw;

public class Length {

    private final double value;
    private final Unit unit;

    public Length(double value, Unit unit) {
        this.value = value;
        this.unit = unit;
    }

    @Override
    public boolean equals(Object obj) {
        Length length = (Length) obj;
        return this.unit.toMM(this.value) == length.unit.toMM(length.value);
    }

    public Length add(Length added) {
        return new Length(this.unit.toMM(this.value) + added.unit.toMM(added.value), Unit.mm);
    }

    public Length subtract(Length another) {
        return new Length(this.unit.toMM(this.value) - another.unit.toMM(another.value), Unit.mm);
    }

}

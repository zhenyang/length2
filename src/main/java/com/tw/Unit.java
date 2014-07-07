package com.tw;

enum Unit {
    m(1000), cm(10), mm(1);
    private final int rate;

    Unit(int rate) {
        this.rate = rate;
    }

    public double toMM(double value) {
        return rate * value;
    }
}

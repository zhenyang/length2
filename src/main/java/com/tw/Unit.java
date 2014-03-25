package com.tw;

enum Unit {
    m(1), cm(100), mm(1000);

    private double rate;

    Unit(int rate) {
        this.rate = rate;
    }

    public double quantityInM(double quantity) {
        return quantity / rate;
    }
}

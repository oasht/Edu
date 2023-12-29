package org.example;

public final class Fraction extends Number {
    private final int numerator;
    private final int denominator;

    public Fraction(int numerator, int denominator) {
        if (denominator >= 0) {
            this.numerator = numerator;
            this.denominator = denominator;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public Fraction(int numerator) {
        this(numerator, 1);
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public Fraction sum(Fraction fraction) {
        if (Math.abs(this.denominator) == Math.abs(fraction.denominator)) {
            return new Fraction(this.numerator + fraction.numerator, fraction.denominator);
        } else {
            return new Fraction(
                    this.numerator * fraction.denominator + fraction.numerator * this.denominator,
                    this.denominator * fraction.denominator);
        }
    }

    public Fraction minus(Fraction fraction) {
        return this.sum(new Fraction(-fraction.numerator, fraction.denominator));
    }

    public Fraction multiply(Fraction fraction) {
        int numerator = this.numerator * fraction.numerator;
        int denominator = this.denominator * fraction.denominator;
        return new Fraction(numerator, denominator);
    }

    public Fraction divide(Fraction fraction) {
        return this.multiply(new Fraction(fraction.denominator, fraction.numerator));
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    @Override
    public int intValue() {
        return numerator / denominator;
    }

    @Override
    public long longValue() {
        return numerator / denominator;
    }

    @Override
    public float floatValue() {
        return (float) numerator / denominator;
    }

    @Override
    public double doubleValue() {
        return (double) numerator / denominator;
    }
}

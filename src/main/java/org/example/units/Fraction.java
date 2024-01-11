package org.example.units;

import java.util.Objects;

public final class Fraction extends Number implements Cloneable {
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

    public boolean equals(Object obj){
        if(this==obj)return true;
        if(obj==null)return false;
        if(getClass()!=obj.getClass()) return false;
        Fraction f=(Fraction)obj;
        return this.numerator == f.numerator && this.denominator == f.denominator;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numerator, denominator);
    }
@Override
public Fraction clone(){
    try {
        return (Fraction) super.clone();
    } catch (CloneNotSupportedException e) {
        throw new AssertionError();
    }
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

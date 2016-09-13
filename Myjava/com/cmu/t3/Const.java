package com.cmu.t3;

public class Const extends Node {
    private double value;
    public Const(double d)
    { value = d; }
    public double eval() { return value; }
}

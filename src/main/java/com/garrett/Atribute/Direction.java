package com.garrett.Atribute;

public class Direction implements Atribute{
    private String value;
    public static final String ATR_NAME = "Direction";

    public Direction(String value) {
        this.value = value;
    }

    @Override
    public String getAtributeName() {
        return ATR_NAME;
    }
    @Override
    public String getAtributeValue() {
        return value;
    }
}

package com.garrett.Atribute;

public class Likelihood implements Atribute {
    private String value;
    public static final String ATR_NAME = "Likelihood";

    public Likelihood(String value) {
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

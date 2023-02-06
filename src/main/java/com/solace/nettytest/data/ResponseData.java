package com.solace.nettytest.data;

public class ResponseData {
    private int intValue;

    public void setIntValue(int intValue) {
        this.intValue = intValue;
    }

    public int getIntValue() {
        return intValue;
    }

    @Override
    public String toString() {
        return "ResponseData{" +
                "intValue=" + intValue +
                '}';
    }
}

package com.taobao.yiwei.oo;

public enum Planet {
    MERCURY(100),
    VENUS(200),
    EARTH(300),
    MARS(400),
    JUPITER(500),
    SATURN(600),
    URANUS(700),
    NEPTUNE(800);

    private final int code;

    Planet(int code) {
        this.code = code;
    }

    public int code() {
        return this.code;
    }
}

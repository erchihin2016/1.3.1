package com.example.a131monitoringzdorov;

public class UserDat {
    private String fio;
    private int age;

    public UserDat(String fio, int age) {
        this.fio = fio;
        this.age = age;
    }

    public String getFio() {
        return fio;
    }

    public int getAge() {
        return age;
    }
}

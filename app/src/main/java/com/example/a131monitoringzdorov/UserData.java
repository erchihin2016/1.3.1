package com.example.a131monitoringzdorov;

public class UserData {
    private String fio;
    private int age;

    public UserData(String fio, int age) {
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

package com.example.firebaserealtimedatabase26112020;

public class Sinhvien {
    private String name;
    private Integer age;

    public Sinhvien(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Sinhvien() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}

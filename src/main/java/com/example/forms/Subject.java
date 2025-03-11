package com.example.forms;

public class Subject {

    //Iniciando variáveis
    private String name;
    private int cpf;
    private int rg;
    private char gender;
    private String birthDate;

    //Construtor vazio
    public Subject() {}
    //Construtor
    public Subject(String name, int cpf, int rg, char gender, String birthDate) {
        this.name = name;
        this.cpf = cpf;
        this.rg = rg;
        this.gender = gender;
        this.birthDate = birthDate;
    }

    //Getters e Setters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getCpf() {
        return cpf;
    }
    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public int getRg() {
        return rg;
    }
    public void setRg(int rg) {
        this.rg = rg;
    }

    public char getGender() {
        return gender;
    }
    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
}

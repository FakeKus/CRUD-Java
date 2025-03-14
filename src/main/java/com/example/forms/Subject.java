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
    
    //Construtor privado para o builder
    private Subject(Builder builder) {
        this.name = builder.name;
        this.cpf = builder.cpf;
        this.rg = builder.rg;
        this.gender = builder.gender;
        this.birthDate = builder.birthDate;
    }
    // Builder estático
    public static class Builder {
        private String name;
        private int cpf;
        private int rg;
        private char gender;
        private String birthDate;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setCpf(int cpf) {
            this.cpf = cpf;
            return this;
        }

        public Builder setRg(int rg) {
            this.rg = rg;
            return this;
        }

        public Builder setGender(char gender) {
            this.gender = gender;
            return this;
        }

        public Builder setBirthDate(String birthDate) {
            this.birthDate = birthDate;
            return this;
        }

        public Subject build() {
            return new Subject(this);
        }
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

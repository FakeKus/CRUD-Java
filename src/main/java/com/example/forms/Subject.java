package com.example.forms;

import java.sql.Date;

import javafx.beans.property.SimpleStringProperty;

public class Subject {

    // Iniciando variáveis
    private String name;
    private Long cpf;
    private int rg;
    private char gender;
    private Date birthDate;

    // Construtor vazio
    public Subject() {}

    // Construtor privado para o builder
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
        private Long cpf;
        private int rg;
        private char gender;
        private Date birthDate;

        // Método para definir o nome e retornar o builder
        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        // Método para definir o CPF e retornar o builder
        public Builder setCpf(Long cpf) {
            this.cpf = cpf;
            return this;
        }

        // Método para definir o RG e retornar o builder
        public Builder setRg(int rg) {
            this.rg = rg;
            return this;
        }

        // Método para definir o gênero e retornar o builder
        public Builder setGender(char gender) {
            this.gender = gender;
            return this;
        }

        // Método para definir a data de nascimento e retornar o builder
        public Builder setBirthDate(Date birthDate) {
            this.birthDate = birthDate;
            return this;
        }

        // Método para construir o objeto Subject
        public Subject build() {
            return new Subject(this);
        }
    }

    // Getters e Setters
    public String getName() {
        return name;
    }
    // Método para obter o nome como SimpleStringProperty (útil para bindings no JavaFX)
    public SimpleStringProperty getNameSimple() {
        SimpleStringProperty simpleStringProperty = new SimpleStringProperty(name);
        return simpleStringProperty;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Long getCpf() {
        return cpf;
    }
    // Método para obter o CPF como SimpleStringProperty (útil para bindings no JavaFX)
    public SimpleStringProperty getCpfSimple() {
        SimpleStringProperty simpleStringProperty = new SimpleStringProperty(String.valueOf(cpf));
        return simpleStringProperty;
    }
    public void setCpf(Long cpf) {
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

    public Date getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}
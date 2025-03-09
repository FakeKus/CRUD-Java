package com.example.forms;

public class Student {

    //Iniciando variáveis
    private String name;
    private char studentClass;

    //Construtor vazio
    public Student() {}
    //Construtor
    public Student(String name, char studentClass) {
        this.name = name;
        this.studentClass = studentClass;
    }

    //Getters e Setters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public char getStudentClass() {
        return studentClass;
    }
    public void setStudentClass(char studentClass) {
        this.studentClass = studentClass;
    }
}

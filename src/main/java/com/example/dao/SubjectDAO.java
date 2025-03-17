package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.example.connection.ConnectionFactory;
import com.example.forms.Subject;

public class SubjectDAO {

    //Iniciando variavés
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    private List<Subject> listSubjects = new ArrayList<>();

    private final String insert         = "INSERT INTO subject (name, cpf, rg, gender, date) VALUES (?, ?, ?, ?, ?)";
    private final String select         = "SELECT * FROM subject";
    private final String selectWhere    = "SELECT * FROM subject WHERE cpf = ?";
    private final String update         = "UPDATE subject SET name = ?, rg = ?, gender = ?, date = ? WHERE cpf = ?";
    private final String delete         = "DELETE FROM subject";
    private final String deleteWhere    = "DELETE FROM subject WHERE cpf = ?";

    public SubjectDAO() {

        connection = null;
        preparedStatement = null;
        resultSet = null;

        connection = ConnectionFactory.connectDB();
    }

    public void insertData(Subject subject) {        
        try {

            preparedStatement = connection.prepareStatement(insert);
            preparedStatement.setString(1, subject.getName());
            preparedStatement.setLong(2, subject.getCpf());
            preparedStatement.setInt(3, subject.getRg());
            preparedStatement.setString(4, String.valueOf(subject.getGender()));
            preparedStatement.setDate(5, subject.getBirthDate());

            preparedStatement.executeUpdate();
        } catch (Exception e) {

            System.out.println("Erro ao inserir dados Subject: 001\n" + e);
        } finally {

            try {

                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                
                System.out.println("Erro ao fechar conexão Subject: 001\n" + e);
            }
        }
    }
    public List<Subject> getData() {
        try {
            
            preparedStatement = connection.prepareStatement(select);
            
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                Subject subject = new Subject.Builder()
                    .setName(resultSet.getString("name"))
                    .setCpf(resultSet.getLong("cpf"))
                    .setRg(resultSet.getInt("rg"))
                    .setGender(resultSet.getString("gender").charAt(0))
                    .setBirthDate(resultSet.getDate("date"))
                    .build();

                listSubjects.add(subject);
            }

            return listSubjects;
        } catch (Exception e) {

            System.out.println("Erro ao buscar dados Subject: 002\n" + e);
        } finally {

            try {

                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                
                System.out.println("Erro ao fechar conexão Subject: 002\n" + e);
            }
        }

        return null;
    }
    public Subject getData(Long longCpf) {
        try {

            preparedStatement = connection.prepareStatement(selectWhere);
            preparedStatement.setLong(1, longCpf);

            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {

                Subject subject = new Subject.Builder()
                    .setName(resultSet.getString("name"))
                    .setCpf(resultSet.getLong("cpf"))
                    .setRg(resultSet.getInt("rg"))
                    .setGender(resultSet.getString("gender").charAt(0))
                    .setBirthDate(resultSet.getDate("date"))
                    .build();

                return subject;
            }
        } catch (Exception e) {

            System.out.println("Erro ao buscar dados Subject: 003\n" + e);
        } finally {

            try {

                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                
                System.out.println("Erro ao fechar conexão Subject: 003\n" + e);
            }
        }

        return null;
    }

    public void updateData(Subject subject) {
        try {

            preparedStatement = connection.prepareStatement(update);
            preparedStatement.setString(1, subject.getName());
            preparedStatement.setInt(2, subject.getRg());
            preparedStatement.setString(3, String.valueOf(subject.getGender()));
            preparedStatement.setDate(4, subject.getBirthDate());
            preparedStatement.setLong(5, subject.getCpf());

            preparedStatement.executeUpdate();
        } catch (Exception e) {

            System.out.println("Erro ao atualizar dados Subject: 004\n" + e);
        } finally {

            try {

                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                
                System.out.println("Erro ao fechar conexão Subject: 004\n" + e);
            }
        }
    }

    public void deleteData() {        
        try {

            preparedStatement = connection.prepareStatement(delete);

            preparedStatement.executeUpdate();
        } catch (Exception e) {

            System.out.println("Erro ao deletar dados Subject: 005\n" + e);
        } finally {

            try {

                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                
                System.out.println("Erro ao fechar conexão Subject: 005\n" + e);
            }
        }
    }
    public void deleteData(Long longCpf) {        
        try {

            preparedStatement = connection.prepareStatement(deleteWhere);
            preparedStatement.setLong(1, longCpf);

            preparedStatement.executeUpdate();
        } catch (Exception e) {

            System.out.println("Erro ao deletar dados Subject: 006\n" + e);
        } finally {

            try {

                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                
                System.out.println("Erro ao fechar conexão Subject: 006\n" + e);
            }
        }
    }

    public boolean existsData(Long longCpf) {
        try {

            preparedStatement = connection.prepareStatement(selectWhere);
            preparedStatement.setLong(1, longCpf);

            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {

                return true;
            }
        } catch (Exception e) {

            System.out.println("Erro ao buscar dados Subject: 007\n" + e);
        } finally {

            try {

                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                
                System.out.println("Erro ao fechar conexão Subject: 007\n" + e);
            }
        }

        return false;
    }
}

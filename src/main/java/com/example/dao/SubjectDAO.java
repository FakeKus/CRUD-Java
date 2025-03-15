package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.example.connection.ConnectionFactory;
import com.example.forms.Subject;

public class SubjectDAO {

    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    private List<Subject> listSubjects = new ArrayList<>();

    public SubjectDAO() {

        connection = null;
        preparedStatement = null;
        resultSet = null;

        connection = ConnectionFactory.connectDB();
    }

    public void insertData(Subject subject) {
        
        try {

            String insert = "INSERT INTO subject (name, cpf, rg, gender, date) VALUES (?, ?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(insert);
            preparedStatement.setString(1, subject.getName());
            preparedStatement.setLong(2, subject.getCpf());
            preparedStatement.setInt(3, subject.getRg());
            preparedStatement.setString(4, String.valueOf(subject.getGender()));
            preparedStatement.setDate(5, subject.getBirthDate());

            preparedStatement.executeUpdate();
        } catch (Exception e) {

            System.out.println("Erro ao inserir dados Role: 002\n" + e);
        } finally {

            try {

                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                
                System.out.println("Erro ao fechar conexão Role: 003\n" + e);
            }
        }
    }
    /*
    public List<Roles> getData() {

        try {
            
            String select = "SELECT * FROM roles";
            preparedStatement = connection.prepareStatement(select);
            
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                Roles roles = new Roles.Builder()
                    .setRoleId(resultSet.getLong("roleId"))
                    .setRoleName(resultSet.getString("roleName"))
                    .setInGuildId(resultSet.getLong("inGuildId"))
                    .build();

                listRoles.add(roles);
            }

            return listRoles;
        } catch (Exception e) {

            System.out.println("Erro ao buscar dados Role: 004\n" + e);
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
                
                System.out.println("Erro ao fechar conexão Role: 005\n" + e);
            }
        }

        return null;
    }
    public Roles getData(Long roleId) {

        try {

            String select = "SELECT * FROM roles WHERE roleId = ?";
            preparedStatement = connection.prepareStatement(select);
            preparedStatement.setLong(1, roleId);

            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {

                Roles role = new Roles.Builder()
                    .setRoleId(resultSet.getLong("roleId"))
                    .setRoleName(resultSet.getString("roleName"))
                    .setInGuildId(resultSet.getLong("inGuildId"))
                    .build();

                return role;
            }
        } catch (Exception e) {

            System.out.println("Erro ao buscar dados Role: 004\n" + e);
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
                
                System.out.println("Erro ao fechar conexão Role: 005\n" + e);
            }
        }

        return null;
    }

    public void updateData(Roles role) {

        try {

            String update = "UPDATE roles SET roleName = ?, inGuildId = ? WHERE roleId = ?";
            preparedStatement = connection.prepareStatement(update);
            preparedStatement.setString(1, role.getRoleName());
            preparedStatement.setLong(2, role.getInGuildId());
            preparedStatement.setLong(3, role.getRoleId());

            preparedStatement.executeUpdate();
        } catch (Exception e) {

            System.out.println("Erro ao atualizar dados Role: 006\n" + e);
        } finally {

            try {

                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                
                System.out.println("Erro ao fechar conexão Role: 007\n" + e);
            }
        }
    }

    public void deleteData() {
        
        try {

            String delete = "DELETE FROM roles";
            preparedStatement = connection.prepareStatement(delete);

            preparedStatement.executeUpdate();
        } catch (Exception e) {

            System.out.println("Erro ao deletar dados Role: 008\n" + e);
        } finally {

            try {

                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                
                System.out.println("Erro ao fechar conexão Role: 009\n" + e);
            }
        }
    }
    public void deleteData(Long roleId) {
        
        try {

            String delete = "DELETE FROM roles WHERE roleId = ?";
            preparedStatement = connection.prepareStatement(delete);
            preparedStatement.setLong(1, roleId);

            preparedStatement.executeUpdate();
        } catch (Exception e) {

            System.out.println("Erro ao deletar dados Role: 010\n" + e);
        } finally {

            try {

                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                
                System.out.println("Erro ao fechar conexão Role: 011\n" + e);
            }
        }
    }

    public boolean existsData(Long roleId) {

        try {

            String select = "SELECT * FROM roles WHERE roleId = ?";
            preparedStatement = connection.prepareStatement(select);
            preparedStatement.setLong(1, roleId);

            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {

                return true;
            }
        } catch (Exception e) {

            System.out.println("Erro ao buscar dados Role: 012\n" + e);
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
                
                System.out.println("Erro ao fechar conexão Role: 013\n" + e);
            }
        }

        return false;
    }*/
}

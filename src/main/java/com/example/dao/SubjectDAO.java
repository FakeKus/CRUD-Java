package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.example.connection.ConnectionFactory;
import com.example.forms.Subject;

public class SubjectDAO {

    // Iniciando variáveis
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    private List<Subject> listSubjects = new ArrayList<>();

    // Declaração das consultas SQL
    private final String insert         = "INSERT INTO subject (name, cpf, rg, gender, date) VALUES (?, ?, ?, ?, ?)";
    private final String select         = "SELECT * FROM subject";
    private final String selectWhere    = "SELECT * FROM subject WHERE cpf = ?";
    private final String update         = "UPDATE subject SET name = ?, rg = ?, gender = ?, date = ? WHERE cpf = ?";
    private final String delete         = "DELETE FROM subject";
    private final String deleteWhere    = "DELETE FROM subject WHERE cpf = ?";

    public SubjectDAO() {
        // Inicializa a conexão com o banco de dados
        connection = null;
        preparedStatement = null;
        resultSet = null;

        connection = ConnectionFactory.connectDB();
    }

    public void insertData(Subject subject) {        
        try {
            // Prepara a consulta de inserção
            preparedStatement = connection.prepareStatement(insert);
            preparedStatement.setString(1, subject.getName());
            preparedStatement.setLong(2, subject.getCpf());
            preparedStatement.setInt(3, subject.getRg());
            preparedStatement.setString(4, String.valueOf(subject.getGender()));
            preparedStatement.setDate(5, subject.getBirthDate());

            // Executa a inserção
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            // Trata exceções e exibe mensagem de erro
            System.out.println("Erro ao inserir dados Subject: 001\n" + e);
        } finally {
            // Fecha a conexão e os recursos
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
            // Prepara a consulta de seleção
            preparedStatement = connection.prepareStatement(select);
            
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                // Cria um objeto Subject a partir dos dados do ResultSet
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
            // Trata exceções e exibe mensagem de erro
            System.out.println("Erro ao buscar dados Subject: 002\n" + e);
        } finally {
            // Fecha a conexão e os recursos
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
            // Prepara a consulta de seleção com filtro
            preparedStatement = connection.prepareStatement(selectWhere);
            preparedStatement.setLong(1, longCpf);

            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                // Cria um objeto Subject a partir dos dados do ResultSet
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
            // Trata exceções e exibe mensagem de erro
            System.out.println("Erro ao buscar dados Subject: 003\n" + e);
        } finally {
            // Fecha a conexão e os recursos
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
            // Prepara a consulta de atualização
            preparedStatement = connection.prepareStatement(update);
            preparedStatement.setString(1, subject.getName());
            preparedStatement.setInt(2, subject.getRg());
            preparedStatement.setString(3, String.valueOf(subject.getGender()));
            preparedStatement.setDate(4, subject.getBirthDate());
            preparedStatement.setLong(5, subject.getCpf());

            // Executa a atualização
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            // Trata exceções e exibe mensagem de erro
            System.out.println("Erro ao atualizar dados Subject: 004\n" + e);
        } finally {
            // Fecha a conexão e os recursos
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
            // Prepara a consulta de exclusão
            preparedStatement = connection.prepareStatement(delete);

            // Executa a exclusão
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            // Trata exceções e exibe mensagem de erro
            System.out.println("Erro ao deletar dados Subject: 005\n" + e);
        } finally {
            // Fecha a conexão e os recursos
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
            // Prepara a consulta de exclusão com filtro
            preparedStatement = connection.prepareStatement(deleteWhere);
            preparedStatement.setLong(1, longCpf);

            // Executa a exclusão
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            // Trata exceções e exibe mensagem de erro
            System.out.println("Erro ao deletar dados Subject: 006\n" + e);
        } finally {
            // Fecha a conexão e os recursos
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
            // Prepara a consulta de verificação de existência
            preparedStatement = connection.prepareStatement(selectWhere);
            preparedStatement.setLong(1, longCpf);

            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return true;
            }
        } catch (Exception e) {
            // Trata exceções e exibe mensagem de erro
            System.out.println("Erro ao buscar dados Subject: 007\n" + e);
        } finally {
            // Fecha a conexão e os recursos
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
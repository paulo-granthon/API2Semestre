package JavaFiles;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Statement;

import Classes.Appointment;

public class QueryLibs {

    public static void simpleSelect(Connection conexao) throws SQLException {
        // método que executa um select simples
        // recebe como parâmetro uma conexão com o banco de dados
        // e pode lançar uma exceção SQLException

        // string que carrega o comando em sql
        String sql = "SELECT * FROM tabela";

        // execução da query
        try (PreparedStatement statement = conexao.prepareStatement(sql)) {
            // prepara a declaração SQL para ser executada usando a conexão fornecida
            // e executa a consulta
            ResultSet result = statement.executeQuery();

            // processa o resultado aqui...
            while (result.next()) {
                // itera sobre cada linha retornada pela consulta
                // e extrai os valores das colunas necessárias
                String coluna1 = result.getString("nome_da_coluna_1");
                int coluna2 = result.getInt("nome_da_coluna_2");
                double coluna3 = result.getDouble("nome_da_coluna_3");

                // imprime os valores das colunas no terminal
                System.out.println(coluna1 + " - " + coluna2 + " - " + coluna3);
            }
        }
    }

    public static void insertTable(Connection conexao, Appointment Apt) throws SQLException {

        // código sql a ser executado, passando "?" como parâmetro de valors
       // código sql a ser executado, passando "?" como parâmetro de valors
        String sql = "INSERT INTO apontamento (hora_inicio, hora_fim, usr_id, projeto, cliente, tipo, justificativa, cr_id) values (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = conexao.prepareStatement(sql)) {
            // substituindo os parâmetros "?" para valores desejados
            // statement.setInt(1, Apt.getId());
            statement.setDateTime(1, Apt.getStartDate());
            statement.setString(2, Apt.getEndDate());
            statement.setInt(3, Apt.getRequester());
            statement.setString(4, Apt.getProject());
            statement.setString(5, Apt.getClient());
            statement.setString(6, Apt.getType().toString());
            statement.setString(7, Apt.getJustification());
            statement.setString(8, Apt.getSquad());

            // executa o update
            statement.executeUpdate();
            // exibe erros ao executar a query
        } catch (Exception ex) {
            System.out.println("Erro ao executar a query: " + ex.getMessage());
        }
    }

    public static void executeSqlFile(Connection conexao, String arquivoSql) throws SQLException, IOException {
        // Verifica se a conexão não é nula
        if (conexao == null) {
            System.out.println("Conexão é nula");
            return; // Encerra o método se a conexão for nula
        }
        try (BufferedReader br = new BufferedReader(new FileReader(arquivoSql))) {
            String linha;
            StringBuilder sb = new StringBuilder();
            while ((linha = br.readLine()) != null) {
                // adiciona a linha ao StringBuilder
                sb.append(linha);
                sb.append(System.lineSeparator()); // Adiciona quebra de linha ao final de cada linha lida
            }
            String sql = sb.toString(); // Converte o StringBuilder em uma String
            try (Statement statement = conexao.createStatement()) {
                // executa as instruções SQL contidas no arquivo
                statement.execute(sql);
            }
        }
    }

    public static void collaboratorSelect(Connection conexao, int usuario_id) throws SQLException, IOException {
        // verificação se a conexão é nula
        if (conexao == null) {
            System.out.println("Conexão é nula");
            return; // Encerra o método se a conexão for nula
        }
        // string que carrega o comando em sql
        String sql = "SELECT * FROM vw_apontamento WHERE usr_id = ?";

        // execução da query
        try (PreparedStatement statement = conexao.prepareStatement(sql)) {
            // substitui "?" pelo id passado no parâmetro
            statement.setInt(1, usuario_id);
            // executa a query e salva o resultado na variável "result"
            ResultSet result = statement.executeQuery();

            // cabeçalho
            System.out.println(
                    "Usuário - hora início - hora fim - projeto - cliente - atividade - justificativa - centro resultado");
            while (result.next()) {
                // itera sobre cada linha retornada pela consulta
                // e extrai os valores das colunas necessárias
                String hora_inicio = result.getString("hora_inicio");
                String hora_fim = result.getString("hora_fim");
                String usuario = result.getString("usuario_nome");
                String projeto = result.getString("projeto");
                String cliente = result.getString("cliente");
                String tipo = result.getString("tipo");
                String justif = result.getString("justificativa");
                String centroR = result.getString("cr_nome");

                // imprime os valores das colunas no terminal
                System.out.println(usuario + " - " + hora_inicio + " - " + hora_fim + " - " + projeto + " - " + cliente
                        + " - " + tipo + " - " + justif + " - " + centroR);
            }
        }
    }
}
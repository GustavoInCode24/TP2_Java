package br.edu.fatecpg.gestaotarefas.controller;

import br.edu.fatecpg.gestaotarefas.model.Tarefa;
import br.edu.fatecpg.gestaotarefas.model.Consulta;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TarefaController {

    public String inserirtarefa(String nm_tarefa, String nm_categoria, boolean ic_tarefa_feito_naofeito, String dt_tarefa) {
      
        String query = "INSERT INTO tarefa(nm_tarefa, nm_categoria, ic_tarefa_feito_naofeito, dt_tarefa) VALUES(?, ?, ?, ?)";

        try (var conexao = Tarefa.conectar()) {
            PreparedStatement stmt = conexao.prepareStatement(query);
            stmt.setString(1, nm_tarefa);
            stmt.setString(2, nm_categoria);
            stmt.setBoolean(3, ic_tarefa_feito_naofeito);
            stmt.setString(4, dt_tarefa);
            stmt.execute();
            return "Gravado com sucesso!";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public String selecionarTarefa() {
        String query = "SELECT * FROM tarefa";
        List<Consulta> consultas = new ArrayList<>();

        try (var conexao = Tarefa.conectar()) {
            PreparedStatement stmt = conexao.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                consultas.add(new Consulta(
                        rs.getString("nm_tarefa"),
                        rs.getString("nm_categoria"),
                        rs.getString("nm_categoria"), rs.getBoolean("ic_tarefa_feito_naofeito"),
                        rs.getString("dt_tarefa")
                ));
            }
            return consultas.toString();
        } catch (Exception e) {
            return e.getMessage();
        }

    }

    public String editarTarefa(int id,String nm_tarefa, String nm_categoria, boolean ic_tarefa_feito_naofeito, String dt_tarefa) throws SQLException {
        String query = "UPDATE tarefa SET nm_tarefa = ?, nm_categoria = ?, ic_tarefa_feito_naofeito = ? , String dt_tarefa Where id = ?";

        try (var conexao = Tarefa.conectar()) {
            PreparedStatement stmt = conexao.prepareStatement(query);
            stmt.setString(1, nm_tarefa);
            stmt.setString(2, nm_categoria);
            stmt.setBoolean(3, ic_tarefa_feito_naofeito);
            stmt.setString(4, dt_tarefa);
            stmt.setInt(6, id);

            int rowsUpdate = stmt.executeUpdate();
            if (rowsUpdate > 0){
                return "Tarefa atualizada com sucesso";
            }
            else {
                return "Tarefa não encontrada";
            }

        }catch (Exception e){
            e.printStackTrace();
            return e.getMessage();
        }

    }

    public String selecionarTarefasCategoria(String nm_categoria){

        String query = "SELECT * FROM tb_tarefas WHERE nm_categoria = ?";
        List<Consulta> consultas= new ArrayList<>();
        try (var conexao = Tarefa.conectar()){
            PreparedStatement stmt = conexao.prepareStatement(query);
            stmt.setString(1,nm_categoria);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                consultas.add(new Consulta(rs.getString("nm_tarefa"),
                        rs.getString("ds_tarefa"),
                        rs.getString("nm_categoria"),
                        rs.getBoolean("ic_tarefa_feito_naofeito"),
                        rs.getString("dt_tarefa")));
            }
            return consultas.toString();
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public String selecionarTarefasStatus(boolean ic_status_concluido_naoconcluido){

        String query = "SELECT * FROM tarefas WHERE ic_status_concluido_naoconcluido = ?";
        List<Consulta> consultas = new ArrayList<>();
        try (var conexao = Tarefa.conectar()){
            PreparedStatement stmt = conexao.prepareStatement(query);
            stmt.setBoolean(1,ic_status_concluido_naoconcluido);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                consultas.add(new Consulta(rs.getString("nm_tarefa"),
                        rs.getString("ds_tarefa"),
                        rs.getString("nm_categoria"),
                        rs.getBoolean("ic_status_concluido_naoconcluido"),
                        rs.getString("dt_tarefa")));
            }
            return consultas.toString();
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public String excluirTarefa(int id){
        String query = "DELETE * FROM tarefa Where = id ?";

        try(var conexao = Tarefa.conectar()){

            PreparedStatement stmt = conexao.prepareStatement(query);
            stmt.setInt(1,id);
            int rowsUpdate = stmt.executeUpdate();
            if (rowsUpdate > 0){
                return "Tarefa deletada com sucesso";
            }
            else {
                return "Tarefa não encontrada";
            }


        } catch (SQLException e) {
           e.printStackTrace();
            return e.getMessage();
        }
    }

}

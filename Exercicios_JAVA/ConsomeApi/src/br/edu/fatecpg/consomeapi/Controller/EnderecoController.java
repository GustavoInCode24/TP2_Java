package br.edu.fatecpg.consomeapi.Controller;

import br.edu.fatecpg.consomeapi.model.Banco;
import br.edu.fatecpg.consomeapi.model.Endereco;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EnderecoController {

    public String inseriredereco(Endereco endereco){

        String query = "INSERT INTO tb_endereco(cep,rua,bairro,localidade,estado) VALUES (?, ?, ?, ?, ?)";

        try (var conexao = Banco.conectar()) {
            PreparedStatement stmt = conexao.prepareStatement(query);
            stmt.setString(1, endereco.getCep() );
            stmt.setString(2, endereco.getRua() );
            stmt.setString(3, endereco.getBairro());
            stmt.setString(4, endereco.getLocalidade());
            stmt.setString(5, endereco.getEstado());
            stmt.execute();
            return "Gravado com sucesso!";
        } catch (Exception e) {
            return e.getMessage();
        }

    }

    public String exibirendereco(){
        String query = "SELECT * FROM db_endereco";
        List<Endereco>  enderecos = new ArrayList<>();

        try (var conexao = Banco.conectar()) {
            PreparedStatement stmt = conexao.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                enderecos.add(new Endereco(
                        rs.getString("cep"),
                        rs.getString("rua"),
                        rs.getString("bairro"),
                        rs.getString("localidade"),
                        rs.getString("estado")
                ));
            }
            return enderecos.toString();
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public String excluirEndereco(String cep) {
        String query = "DELETE FROM endereco WHERE cep = ?";

        try (var conexao = Banco.conectar()) {
            PreparedStatement stmt = conexao.prepareStatement(query);

            stmt.setString(1, cep);
            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                return "Endereço excluído com sucesso.";
            } else {
                return "Nenhuma endereço encontrado.";
            }
        } catch (Exception e) {
            return "Erro: " + e.getMessage();
        }

    }
}

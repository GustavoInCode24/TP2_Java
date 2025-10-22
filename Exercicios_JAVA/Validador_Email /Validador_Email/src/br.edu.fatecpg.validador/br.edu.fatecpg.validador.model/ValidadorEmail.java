package br.edu.fatecpg.validador.model;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidadorEmail {
    public boolean emailValido(String email){
        String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+com$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    public List<String> juncaoEmails() {
        String apiUrl = "https://jsonplaceholder.typicode.com/comments";
        List<String> emails = new ArrayList<>();
        try {
            // Realiza a requisição para a API
            HttpURLConnection connection = (HttpURLConnection) new URL(apiUrl).openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);

            // Lê o JSON de resposta
            InputStreamReader reader = new InputStreamReader(connection.getInputStream());
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(reader);

            // Extrai os e-mails dos comentários
            for (JsonNode comment : rootNode) {
                String email = comment.get("email").asText();
                emails.add(email);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return emails;
    }

    // Função para validar todos os e-mails e contar válidos e inválidos
    public int[] validarEmails(List<String> emails) {
        int validCount = 0;
        int invalidCount = 0;

        for (String email : emails) {
            if (emailValido(email)) {
                validCount++;
            } else {
                invalidCount++;
            }
        }

        return new int[]{validCount, invalidCount};
    }
}


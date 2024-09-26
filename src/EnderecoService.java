import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class EnderecoService {
    Gson gson = new GsonBuilder()
        .setPrettyPrinting()
        .create();
        
    public Endereco consultarEnderecoPorCEP (String cep) throws Exception {
        String url = "https://viacep.com.br/ws/" + cep.replace("-", "") + "/json/";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();

        try {
            HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
            String json = response.body();
            EnderecoRecord enderecoRecord = gson.fromJson(json, EnderecoRecord.class);
            return new Endereco(enderecoRecord);
        } catch (Exception e) {
            throw new Exception("Houve um problema ao fazer a requisição.");
        }
    }
}

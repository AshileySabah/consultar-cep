import java.io.BufferedWriter;
import java.io.FileWriter;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        BufferedWriter writer;

        Gson gson = new GsonBuilder()
        .setPrettyPrinting()
        .create();

        String cep = "";

        List<Endereco> enderecos = new ArrayList<Endereco>();

        int continuar = 1;

        while (continuar == 1) {
            System.out.println("0 - Sair");
            System.out.println("1 - Continuar");
            continuar = scanner.nextInt();
            scanner.nextLine();

            if (continuar == 1) {
                System.out.println("Digite o cep: ");
                cep = scanner.nextLine();
        
                String url = "https://viacep.com.br/ws/" + cep.replace("-", "") + "/json/";
        
                HttpClient client = HttpClient.newHttpClient();
        
                HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();
        
                HttpResponse<String> response = client.send(request, BodyHandlers.ofString());

                String json = response.body();
        
                EnderecoRecord enderecoRecord = gson.fromJson(json, EnderecoRecord.class);
                Endereco endereco = new Endereco(enderecoRecord);
                enderecos.add(endereco);
            }
        }

        writer = new BufferedWriter(new FileWriter("lista-enderecos.txt"));
        for (Endereco endereco : enderecos) {
            writer.write(endereco.toString());
            writer.newLine();
        }
        writer.close();

        writer = new BufferedWriter(new FileWriter("lista-enderecos.json"));
        writer.write(gson.toJson(enderecos));
        writer.close();

        System.out.println(enderecos);

        scanner.close();
    }
}

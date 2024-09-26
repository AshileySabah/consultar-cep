import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GerenciadorArquivo {
    BufferedWriter writer;

    Gson gson = new GsonBuilder()
        .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
        .setPrettyPrinting()
        .create();

    public void gerarArquivoTXT (List<Endereco> enderecos) {
        try {
            writer = new BufferedWriter(new FileWriter("lista-enderecos.txt"));
            for (Endereco endereco : enderecos) {
                writer.write(endereco.toString());
                writer.newLine();
            }
            writer.close();
        } catch (Exception e) {
            System.out.println("Houve um erro ao tentar gerar o arquivo lista-enderecos.txt.");
        }
    }

    public void gerarArquivoJSON (List<Endereco> enderecos) {
        try {
            writer = new BufferedWriter(new FileWriter("lista-enderecos.json"));
            writer.write(gson.toJson(enderecos));
            writer.close();
        } catch (Exception e) {
            System.out.println("Houve um erro ao tentar gerar o arquivo lista-enderecos.json.");
        }
    }
}

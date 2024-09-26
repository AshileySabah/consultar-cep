import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        Gson gson = new GsonBuilder()
        .setPrettyPrinting()
        .create();

        List<Endereco> enderecos = new ArrayList<Endereco>();

        int continuar = 1;

        while (continuar == 1) {
            System.out.println("0 - Sair");
            System.out.println("1 - Continuar");
            continuar = scanner.nextInt();
            scanner.nextLine();

            if (continuar == 1) {
                System.out.println("Digite o cep: ");
                String cep = scanner.nextLine();

                String json = new EnderecoService().consultarEnderecoPorCEP(cep);
        
                EnderecoRecord enderecoRecord = gson.fromJson(json, EnderecoRecord.class);
                Endereco endereco = new Endereco(enderecoRecord);
                enderecos.add(endereco);
            }
        }

        new GerenciadorArquivo().gerarArquivoTXT(enderecos);

        new GerenciadorArquivo().gerarArquivoJSON(enderecos);

        System.out.println(enderecos);

        scanner.close();
    }
}

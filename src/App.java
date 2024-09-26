import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        boolean continuar = true;

        Console console = new Console();
        GerenciadorArquivo gerenciadorArquivo = new GerenciadorArquivo();

        List<Endereco> enderecos = new ArrayList<Endereco>();

        while (continuar) {
            continuar = console.mostrarMenu();

            if (continuar) {
                String cep = console.solicitarCep();
                Endereco endereco = new EnderecoService().consultarEnderecoPorCEP(cep);
                enderecos.add(endereco);
            }
        }

        gerenciadorArquivo.gerarArquivoTXT(enderecos);
        gerenciadorArquivo.gerarArquivoJSON(enderecos);
        
        System.out.println(enderecos);
    }
}

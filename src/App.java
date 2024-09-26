import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        List<Endereco> enderecos = new ArrayList<Endereco>();
        boolean continuar = true;

        while (continuar) {
            continuar = new Console().mostrarMenu();

            if (continuar) {
                String cep = new Console().solicitarCep();
                Endereco endereco = new EnderecoService().consultarEnderecoPorCEP(cep);
                enderecos.add(endereco);
            }
        }

        new GerenciadorArquivo().gerarArquivoTXT(enderecos);
        new GerenciadorArquivo().gerarArquivoJSON(enderecos);
        System.out.println(enderecos);
    }
}


public class Endereco {
    private String cep;
    private String logradouro;
    private String siglaEstado;
    private String cidade;
    private String bairro;

    public Endereco (String cep, String logradouro, String siglaEstado, String cidade, String bairro) {
        this.cep = cep;
        this.logradouro = logradouro;
        this.siglaEstado = siglaEstado;
        this.cidade = cidade;
        this.bairro = bairro;
    }

    public Endereco (EnderecoRecord enderecoRecord) {
        this.cep = enderecoRecord.cep();
        this.logradouro = enderecoRecord.logradouro();
        this.siglaEstado = enderecoRecord.uf();
        this.cidade = enderecoRecord.localidade();
        this.bairro = enderecoRecord.bairro();
    }

    @Override
    public String toString() {
        return 
        "\nEndereco:\n" +
        "- cep: " + this.cep + "\n" +
        "- logradouro: " + this.logradouro + "\n" +
        "- siglaEstado: " + this.siglaEstado + "\n" +
        "- cidade: " + this.cidade + "\n" +
        "- bairro: " + this.bairro + "\n";
    }
}

import java.util.Scanner;

public class Console {
    Scanner scanner = new Scanner(System.in);

    public boolean mostrarMenu () {
        System.out.println("0 - Sair");
        System.out.println("1 - Continuar");
        int option = scanner.nextInt();
        scanner.nextLine();
        return option == 1;
    }

    public String solicitarCep () {
        System.out.println("Digite o cep: ");
        return scanner.nextLine();
    }
}

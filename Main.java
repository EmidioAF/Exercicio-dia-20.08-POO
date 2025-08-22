import java.util.ArrayList;
import java.util.Scanner;

class Pessoa {
    public String nome;
    public int idade;
    public String telefone;
    public String email;
}

public class Main {
    public static void main(String[] args) {
        ArrayList<Pessoa> pessoas = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("Menu:");
            System.out.println("1. Cadastrar nova pessoa");
            System.out.println("2. Listar todas as pessoas");
            System.out.println("3. Buscar pessoa por nome");
            System.out.println("4. Atualizar dados de uma pessoa");
            System.out.println("5. Remover pessoa pelo nome");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opcao: ");
            opcao = sc.nextInt();
            sc.nextLine();

            if (opcao == 1){
                Pessoa p = new Pessoa();
                System.out.println("Nome: ");
                p.nome = sc.nextLine();
                sc.nextLine();
                System.out.println("Idade: ");
                p.idade = sc.nextInt();
                sc.nextLine();
                System.out.println("Telefone: ");
                p.telefone = sc.nextLine();
                sc.nextLine();
                System.out.println("Email: ");
                p.email = sc.nextLine();
                sc.nextLine();
                pessoas.add(p);
            }

            else if (opcao == 2){
                if (pessoas.isEmpty()) {
                    System.out.println("Ninguem com esse nome esta cadastrado");
                } 
                else {
                    for (Pessoa pessoa : pessoas) { // perguntar depois porque isso e feito assim
                        System.out.println("Nome: " + pessoa.nome + ", Idade: " + pessoa.idade + ", Telefone: " + pessoa.telefone + ", Email: " + pessoa.email);
                    }
                }
            }

            else if (opcao == 3) {
                System.out.print("Digite o nome que quer buscar: ");
                String buscarNome = sc.nextLine();
                boolean encontrado = false;
                for (Pessoa pessoa : pessoas) {
                    if (pessoa.nome.equalsIgnoreCase(buscarNome)) { // mesma coisa pra ca
                        System    .out.println("Nome: " + pessoa.nome + ", Idade: " + pessoa.idade + ", Telefone: " + pessoa.telefone + ", Email: " + pessoa.email);
                        encontrado = true;
                    }
                }
                if (!encontrado) {
                    System.out.println("Pessoa nao encontrada.");
                }
            }

            else if (opcao == 4) {
                System.out.print("Digite o nome da pessoa para atualizar: ");
                String nomeAtualizar = sc.nextLine();
                boolean achou = false;
                for (Pessoa pessoa : pessoas) {
                    if (pessoa.nome.equalsIgnoreCase(nomeAtualizar)) { // copy from quickref
                        System.out.print("Novo nome: ");
                        pessoa.nome = sc.nextLine();
                        System.out.print("Nova idade: ");
                        pessoa.idade = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Novo telefone: ");
                        pessoa.telefone = sc.nextLine();
                        System.out.print("Novo email: ");
                        pessoa.email = sc.nextLine();
                        System.out.println("Dados atualizados!");
                        achou = true;
                        break;
                    }
                }
            }

            else if (opcao == 5) {
                System.out.print("Digite o nome da pessoa que quer remover: ");
                String nomeRemover = sc.nextLine();
                boolean removido = false;
                for (int i = 0; i < pessoas.size(); i++) { // copy from quickref
                    if (pessoas.get(i).nome.equalsIgnoreCase(nomeRemover)) {
                        pessoas.remove(i);
                        System.out.println("Pessoa removida");
                        removido = true;
                        break;
                    }
                }
                if (!removido) {
                    System.out.println("Pessoa nao encontrada.");
                }
            }  

            else if (opcao == 6) {
                System.out.println("Sair");
                break; // sai do loop
            }
        }
    }

}

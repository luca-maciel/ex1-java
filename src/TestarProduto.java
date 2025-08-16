import java.util.Scanner;
import java.util.ArrayList;

class Produto{
    String nome;
    double preco;

    public static Scanner input = new Scanner(System.in);

    Produto(String nome, double preco){
        this.nome = nome;
        this.preco = preco;
    }

    void informarNome(){
        System.out.printf("O nome do produto é: %s\n", this.nome);
    }
    void informarPreco(){
        System.out.printf("O preço do produto é: R$%.2f\n", this.preco);
    }

    void fazerPromocao(){
        if (this.preco >= 1){
            this.preco -= 1;
        }
        else{
            this.preco = 0;
        }

    }

    void mudarNome(){
        System.out.print("Novo nome para o produto: ");
        this.nome = input.nextLine();
        System.out.printf("Nome alterado para: %s\n", this.nome);
    }

    void mudarPreco(){
        System.out.print("Novo preço para o produto: ");
        this.preco = input.nextDouble();
        input.nextLine();
        System.out.printf("Preço alterado para: R$%.2f\n", this.preco);
    }
}

public class TestarProduto {
    static int option;
    static ArrayList <Produto> produtos = new ArrayList<>();
    static int position, optionProductEdit;
    public static void main(String[] args) {
        while (option != 99){
            System.out.println("Escolha uma opção\n[1] - Listar produtos\n[2] - Adicionar produto\n[3] - Editar um produto\n[4] - Excluir um produto\n[5] - Fazer promoção\n[99] - Sair");
            option = Produto.input.nextInt();
            Produto.input.nextLine();

            switch (option){
                case 1:
                    if (!produtos.isEmpty()){
                        for (Produto produto : produtos){
                            position = 0;
                            System.out.printf("[%d] - Nome do produto: %s. Preço: R$%.2f\n", position+1, produto.nome, produto.preco);
                            position++;
                        }
                    }
                    else{
                        System.out.println("Lista de produtos vazia.");
                    }
                    break;

                case 2:
                    System.out.print("Nome do produto: ");
                    String nome = Produto.input.nextLine();
                    System.out.print("Preço do produto: R$");
                    double preco = Produto.input.nextDouble();
                    Produto.input.nextLine();
                    produtos.add(new Produto(nome, preco));
                    System.out.println("Produto adicionado à lista.");
                    break;

                case 3:
                    System.out.print("Digite a posição do produto que você deseja editar: ");
                    position = Produto.input.nextInt();
                    Produto.input.nextLine();
                    try{
                        Produto produto = produtos.get(position-1);
                        System.out.println("Qual informação deseja editar?\n[1] - Nome\n[2] - Preço");
                        optionProductEdit = Produto.input.nextInt();
                        Produto.input.nextLine();
                        if (optionProductEdit == 1){
                            produto.mudarNome();
                        } else if (optionProductEdit == 2) {
                            produto.mudarPreco();
                        }
                        else{
                            System.err.println("Informe uma opção válida");
                        }
                    } catch (IndexOutOfBoundsException e) {
                        System.err.println("Nenhum produto nessa posição da lista.");
                    }
                    break;

                case 4:
                    if (!produtos.isEmpty()){
                        try{
                            System.out.print("Digite a posição do produto que você deseja excluir: ");
                            position = Produto.input.nextInt();
                            Produto.input.nextLine();
                            produtos.remove(position-1);
                            System.out.println("Produto removido com sucesso.");
                        }
                        catch(IndexOutOfBoundsException e){
                            System.err.println("Nenhum produto nessa posição.");
                        }

                    }
                    else{
                        System.err.println("Lista de produtos vazia.");
                    }
                    break;

                case 5:
                    if (!produtos.isEmpty()) {
                        try {
                            System.out.print("Digite a posição do produto que você deseja fazer a promoção: ");
                            position = Produto.input.nextInt();
                            Produto.input.nextLine();
                            produtos.get(position - 1).fazerPromocao();
                        } catch (IndexOutOfBoundsException e) {
                            System.err.println("Escolha uma opção válida.");
                        }
                    }
                    else{
                            System.err.println("Lista vazia");
                    }
                    break;

                case 99:
                    System.out.println("Finalizado.");
                    System.exit(0);
                default:
                    System.err.println("Escolha uma opção válida");
                    break;
            }
        }

//        System.out.print("Nome para o produto: ");
//        String nome = Produto.input.nextLine();
//        System.out.print("Preço para o produto: R$");
//        double preco = Produto.input.nextDouble();
//        Produto.input.nextLine();
//
//        Produto produtoTeste = new Produto(nome, preco);
//        produtoTeste.informarNome();
//        produtoTeste.informarPreco();
//        produtoTeste.fazerPromocao();
//        produtoTeste.informarPreco();
    }
}
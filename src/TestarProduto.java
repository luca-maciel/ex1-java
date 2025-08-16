import java.util.Scanner;

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
        this.nome = input.nextLine();
        System.out.printf("Nome alterado para: %s\n", this.nome);
    }

    void mudarPreco(){
        this.preco = input.nextDouble();
        input.nextLine();
        System.out.printf("Preço alterado para: R$%.2f\n", this.preco);
    }
}

public class TestarProduto {

    public static void main(String[] args) {
        System.out.print("Nome para o produto: ");
        String nome = Produto.input.nextLine();
        System.out.print("Preço para o produto: R$");
        double preco = Produto.input.nextDouble();
        Produto.input.nextLine();

        Produto produtoTeste = new Produto(nome, preco);
        produtoTeste.informarNome();
        produtoTeste.informarPreco();
        produtoTeste.fazerPromocao();
        produtoTeste.informarPreco();
    }
}
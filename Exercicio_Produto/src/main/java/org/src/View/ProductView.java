package View;

import Controller.ProductController;
import Model.Product;

import java.util.Scanner;

public class ProductView {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ProductController controller = new ProductController();
        int opcao;
        do {
            System.out.println("=======MENU=======");
            System.out.println("1-Cadastrar produto");
            System.out.println("2-Lista Produtos");
            System.out.println("0-Sair");
            System.out.println();
            System.out.println("Digite a opção desejada: ");

            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Id do produto: ");
                    int id = sc.nextInt();

                    System.out.println("Nome do produto: ");
                    String nome = sc.nextLine();

                    System.out.println("Preço do produto: ");
                    double preco = sc.nextDouble();

                    sc.nextLine();

                    controller.adicionaProduct(new Product(id, nome, preco));

                    break;
                case 2:
                    controller.listarProdutos();
                    break;
                case 0:
                    System.out.println("Encerrando...");
                    break;
                default:
                    System.out.println("Opção invalida");
            }

        } while (opcao != 0);
        sc.close();

    }
}

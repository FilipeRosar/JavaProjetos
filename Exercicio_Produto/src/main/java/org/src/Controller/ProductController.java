package Controller;

import Model.Product;

public class ProductController {
    private Product[] product = new Product[5];
    int count = 0;

    public Product criarProduto(int id,String nome, double price){
        return new Product(id,nome,price);
    }
    public String mostrarProdutos(Product product){
        return product.exibirProdutos();
    }
    public void adicionaProduct(Product p){
        if(count < product.length){
            product[count] = p;
            count++;
            System.out.println("Produto cadastrado");
        } else{
            System.out.println("Limite de cadastro atingido");
        }
    }
    public void listarProdutos(){
        if(count == 0){
            System.out.println("Não tem produtos cadastrados");
        }
        else{
            for (int i = 0; i < count; i++) {
                System.out.println(product[i].exibirProdutos());
                System.out.println("----------------");
            }
        }
    }
}

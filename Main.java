import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        
        Loja loja = new Loja();

        int opcao;

        do{
            System.out.println();
            System.out.println("=================================");
            System.out.println("       SISTEMA DE GESTAO");
            System.out.println("              LOJA");
            System.out.println("=================================");
            System.out.println("1 - Adicionar produto");
            System.out.println("2 - Listar produtos");
            System.out.println("3 - Adicionar cliente");
            System.out.println("4 - Listar clientes");
            System.out.println("5 - Fazer compra");
            System.out.println("6 - Listar compras");
            System.out.println("7 - Histórico de um cliente");
            System.out.println("0 - Sair");
            System.out.println("=================================");
            System.out.print("Escolha uma opçao: ");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    scanner.nextLine();

                    System.out.print("Nome do produto: ");
                    String nomeProduto = scanner.nextLine();

                    System.out.print("Preço: ");
                    double preco = scanner.nextDouble();

                    System.out.print("Quantidade em stock: ");
                    int quantidadeStock = scanner.nextInt();

                    scanner.nextLine();

                    System.out.print("Categoria: ");
                    String categoria = scanner.nextLine();

                    Produto produto = new Produto(nomeProduto, preco, quantidadeStock, categoria);
                    loja.adicionarProduto(produto);

                    System.out.println("Produto adicionado com sucesso!");
                    break;
                case 2:
                    loja.listarProdutos();
                    break;
                case 3:
                    scanner.nextLine();

                    System.out.print("Nome do cliente: ");
                    String nomeCliente = scanner.nextLine();

                    System.out.print("Contacto: ");
                    int contacto = scanner.nextInt();

                    System.out.print("Saldo inicial: ");
                    double saldo = scanner.nextDouble();

                    Cliente cliente = new Cliente(nomeCliente, contacto, saldo);

                    loja.adicionarCliente(cliente);

                    System.out.println("Cliente adicionado com sucesso!");
                    break;
                case 4:
                    loja.listarClientes();
                    break;
                case 5:
                    scanner.nextLine();

                    System.out.print("Nome do cliente: ");
                    String nomeClienteCompra = scanner.nextLine();

                    Cliente clienteCompra = loja.procurarCliente(nomeClienteCompra);

                    if (clienteCompra == null) {
                        System.out.println("Cliente não encontrado.");
                        break;
                    }

                    System.out.print("Nome do produto: ");
                    String nomeProdutoCompra = scanner.nextLine();

                    Produto produtoCompra = loja.procurarProduto(nomeProdutoCompra);

                    if (produtoCompra == null) {
                        System.out.println("Produto não encontrado.");
                        break;
                    }

                    System.out.print("Quantidade: ");
                    int quantidadeCompra = scanner.nextInt();

                    if (quantidadeCompra <= 0) {
                        System.out.println("A quantidade deve ser superior a zero.");
                        break;
                    }

                    loja.realizarCompra(clienteCompra, produtoCompra, quantidadeCompra);
                    break;
                case 6:
                    loja.listarCompras();
                    break;
                case 7:
                    scanner.nextLine();

                    System.out.print("Nome do cliente: ");
                    String nomeClienteHistorico = scanner.nextLine();

                    Cliente clienteHistorico = loja.procurarCliente(nomeClienteHistorico);

                    if (clienteHistorico == null) {
                        System.out.println("Cliente não encontrado.");
                        break;
                    }

                    System.out.println("\n===== HISTORICO DE COMPRAS =====");
                    loja.listarHistoricoCliente(clienteHistorico);

                    break;
                case 0:
                    System.out.println("A sair...");
                    break;
                
                default:
                    System.out.println("Opcao invalida.");
            }
        } while(opcao != 0);

        scanner.close();
    }
}

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
            System.out.println("8 - Aplicar desconto a um produto");
            System.out.println("0 - Sair");
            System.out.println("=================================");
            System.out.print("Escolha uma opçao: ");

            if (!scanner.hasNextInt()) {
                System.out.println("[ERRO] A opçao deve ser um numero inteiro.");
                scanner.nextLine();
                opcao = -1;
                continue;
            }

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    scanner.nextLine();

                    System.out.print("Nome do produto: ");
                    String nomeProduto = scanner.nextLine();

                    if (nomeProduto.trim().isEmpty()) {
                        System.out.println("[ERRO] O nome do produto nao pode estar vazio.");
                        break;
                    }

                    System.out.print("Preço: ");
                    if (!scanner.hasNextDouble()) {
                        System.out.println("[ERRO] O preço deve ser um numero.");
                        scanner.nextLine();
                        break;
                    }

                    double preco = scanner.nextDouble();

                    if (preco <= 0) {
                        System.out.println("[ERRO] O preço deve ser superior a zero.");
                        break;
                    }

                    System.out.print("Quantidade em stock: ");

                    if (!scanner.hasNextInt()) {
                        System.out.println("[ERRO] A quantidade deve ser um numero inteiro.");
                        scanner.nextLine();
                        break;
                    }

                    int quantidadeStock = scanner.nextInt();

                    if (quantidadeStock < 0) {
                        System.out.println("[ERRO] A quantidade nao pode ser negativa.");
                        break;
                    }

                    scanner.nextLine();

                    System.out.print("Categoria: ");
                    String categoria = scanner.nextLine();

                    if (categoria.trim().isEmpty()) {
                        System.out.println("[ERRO] A categoria nao pode estar vazia.");
                        break;
                    }

                    Produto produto = new Produto(nomeProduto, preco, quantidadeStock, categoria);
                    loja.adicionarProduto(produto);

                    System.out.println("[OK] Produto adicionado com sucesso!");
                    break;
                case 2:
                    loja.listarProdutos();
                    break;
                case 3:
                    scanner.nextLine();

                    System.out.print("Nome do cliente: ");
                    String nomeCliente = scanner.nextLine();

                    if (nomeCliente.trim().isEmpty()) {
                        System.out.println("[ERRO] O nome do cliente nao pode estar vazio.");
                        break;
                    }

                    System.out.print("Contacto: ");

                    if (!scanner.hasNextInt()) {
                        System.out.println("[ERRO] O contacto deve ser um numero inteiro.");
                        scanner.nextLine();
                        break;
                    }
                    
                    int contacto = scanner.nextInt();

                    if (contacto <= 0) {
                        System.out.println("[ERRO] O contacto deve ser superior a zero.");
                        break;
                    }

                    System.out.print("Saldo inicial: ");

                    if (!scanner.hasNextDouble()) {
                        System.out.println("[ERRO] O saldo deve ser um numero.");
                        scanner.nextLine();
                        break;
                    }

                    double saldo = scanner.nextDouble();

                    if (saldo < 0) {
                        System.out.println("[ERRO] O saldo nao pode ser negativo.");
                        break;
                    }

                    Cliente cliente = new Cliente(nomeCliente, contacto, saldo);

                    loja.adicionarCliente(cliente);

                    System.out.println("[OK] Cliente adicionado com sucesso!");
                    break;
                case 4:
                    loja.listarClientes();
                    break;
                case 5:
                    scanner.nextLine();

                    System.out.print("Nome do cliente: ");
                    String nomeClienteCompra = scanner.nextLine();

                    if (nomeClienteCompra.trim().isEmpty()) {
                        System.out.println("[ERRO] O nome do cliente nao pode estar vazio.");
                        break;
                    }

                    Cliente clienteCompra = loja.procurarCliente(nomeClienteCompra);

                    if (clienteCompra == null) {
                        System.out.println("Cliente nao encontrado.");
                        break;
                    }

                    System.out.print("Nome do produto: ");
                    String nomeProdutoCompra = scanner.nextLine();

                    if (nomeProdutoCompra.trim().isEmpty()) {
                        System.out.println("[ERRO] O nome do produto nao pode estar vazio.");
                        break;
                    }

                    Produto produtoCompra = loja.procurarProduto(nomeProdutoCompra);

                    if (produtoCompra == null) {
                        System.out.println("[ERRO] Produto nao encontrado.");
                        break;
                    }

                    System.out.print("Quantidade: ");

                    if (!scanner.hasNextInt()) {
                        System.out.println("[ERRO] A quantidade deve ser um numero inteiro.");
                        scanner.nextLine();
                        break;
                    }

                    int quantidadeCompra = scanner.nextInt();

                    if (quantidadeCompra <= 0) {
                        System.out.println("[ERRO] A quantidade deve ser superior a zero.");
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
                        System.out.println("Cliente nao encontrado.");
                        break;
                    }

                    System.out.println("\n===== HISTORICO DE COMPRAS =====");
                    loja.listarHistoricoCliente(clienteHistorico);

                    break;
                case 8:
                    scanner.nextLine();

                    System.out.print("Nome do produto: ");
                    String nomeProdutoDesconto = scanner.nextLine();
     
                    if (nomeProdutoDesconto.trim().isEmpty()) {
                        System.out.println("[ERRO] O nome do produto nao pode estar vazio.");
                        break;
                    }

                    Produto produtoDesconto = loja.procurarProduto(nomeProdutoDesconto);

                    if (produtoDesconto == null) {
                        System.out.println("[ERRO] Produto nao encontrado.");
                        break;
                    }

                    System.out.print("Percentagem de desconto: ");

                    if (!scanner.hasNextDouble()) {
                        System.out.println("[ERRO] A percentagem deve ser um numero.");
                        scanner.nextLine();
                        break;
                    }
                    
                    double percentagem = scanner.nextDouble();

                    double novoPreco = produtoDesconto.aplicarDesconto(percentagem);

                    if (novoPreco == -1) {
                        System.out.println("[ERRO] A percentagem deve estar entre 0 e 100.");
                    } else {
                        System.out.println("[OK] Desconto aplicado com sucesso!");
                        System.out.println("Novo preço: "
                                + String.format("%.2f", novoPreco));
                    }

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

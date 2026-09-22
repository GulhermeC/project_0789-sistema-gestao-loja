public class Loja {
    private Produto produtos[];
    private Cliente clientes[];
    private Compra compras[];

    public Loja() {
        produtos = new Produto[100];
        clientes = new Cliente[100];
        compras = new Compra[100];
    }

    public void adicionarProduto(Produto produto) {
        for (int i = 0; i < produtos.length; i++) {
            if (produtos[i] == null) {
                produtos[i] = produto;
                return;
            }
        }
    }

    public void adicionarCliente(Cliente cliente) {
        for (int i = 0; i < clientes.length; i++) {
            if (clientes[i] == null) {
                clientes[i] = cliente;
                return;
            }
        }
    }

    public void adicionarCompra(Compra compra) {
        for (int i = 0; i < compras.length; i++) {
            if (compras[i] == null) {
                compras[i] = compra;
                return;
            }
        }
    }

    public void listarProdutos() {

        System.out.println("\n===== LISTA DE PRODUTOS =====");

        boolean encontrou = false;

        for (int i = 0; i < produtos.length; i++) {

            if (produtos[i] != null) {

                System.out.println(produtos[i].getInfo());
                System.out.println("-----------------------------");

                encontrou = true;
            }
        }

        if (!encontrou) {
            System.out.println("Não existem produtos registados.");
        }
    }

    public void listarClientes() {

        System.out.println("\n===== LISTA DE CLIENTES =====");

        boolean encontrou = false;

        for (int i = 0; i < clientes.length; i++) {

            if (clientes[i] != null) {

                System.out.println(clientes[i].getInfo());
                System.out.println("-----------------------------");

                encontrou = true;
            }
        }

        if (!encontrou) {
            System.out.println("Não existem clientes registados.");
        }
    }

    public void listarCompras() {

        System.out.println("\n===== LISTA DE COMPRAS =====");

        boolean encontrou = false;

        for (int i = 0; i < compras.length; i++) {

            if (compras[i] != null) {

                System.out.println(compras[i].getInfo());
                System.out.println("-----------------------------");

                encontrou = true;
            }
        }

        if (!encontrou) {
            System.out.println("Não existem compras registadas.");
        }
    }

    public Cliente procurarCliente(String nome) {

        for (int i = 0; i < clientes.length; i++) {

            if (clientes[i] != null && clientes[i].getNome().equals(nome)) {
                return clientes[i];
            }
        }

        return null;
    }

    public Produto procurarProduto(String nome) {

        for (int i = 0; i < produtos.length; i++) {

            if (produtos[i] != null && produtos[i].getNome().equals(nome)) {
                return produtos[i];
            }
        }

        return null;
    }

    public void listarHistoricoCliente(Cliente cliente) {

        boolean encontrou = false;

        for (int i = 0; i < compras.length; i++) {

            if (compras[i] != null
                    && compras[i].getCliente().equals(cliente)) {

                System.out.println(compras[i].getInfo());
                System.out.println("-----------------------------");

                encontrou = true;
            }
        }

        if (!encontrou) {
            System.out.println("Este cliente ainda não tem compras.");
        }
    }

    public void realizarCompra(Cliente cliente, Produto produto, int quantidade) {
        if (produto.getQuantidadeEmStock() < quantidade) {
            System.out.println("Sem stock suficiente");
            System.out.println("Stock disponível: " + produto.getQuantidadeEmStock());
            return;
        }

        double valorTotal = produto.getPreco() * quantidade;

        if (cliente.getSaldo() < valorTotal) {
            System.out.println("Saldo insuficiente");
            System.out.println("Saldo disponível: " + cliente.getSaldo());
            System.out.println("Valor da compra: " + valorTotal);
            return;
        }

        produto.setQuantidadeEmStock(produto.getQuantidadeEmStock() - quantidade);

        cliente.setSaldo(cliente.getSaldo() - valorTotal);

        Compra compra = new Compra(cliente, produto, valorTotal, quantidade);

        adicionarCompra(compra);

        System.out.println("Compra realizada com sucesso!");
        System.out.println("Valor total: " + valorTotal);
    }
}

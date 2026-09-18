public class Compra {
    private Cliente cliente;
    private Produto produto;
    private int valorTotal;
    private int quantidade;
    
    public Compra() {
    }
    
    public Compra(Cliente cliente, Produto produto, int valorTotal, int quantidade) {
        this.cliente = cliente;
        this.produto = produto;
        this.valorTotal = valorTotal;
        this.quantidade = quantidade;
    }
    
    public Cliente getCliente() {
        return cliente;
    }
    
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public Produto getProduto() {
        return produto;
    }
    
    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    
    public int getValorTotal() {
        return valorTotal;
    }
    
    public void setValorTotal(int valorTotal) {
        this.valorTotal = valorTotal;
    }
    
    public int getQuantidade() {
        return quantidade;
    }
    
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getInfo() {
        return "Cliente: " + getCliente().getInfo() + "\nProduto: " + getProduto().getInfo() + "\nQuantidade: " + getQuantidade() + "\nValor Total: " + getValorTotal() + "\n";
    }
}

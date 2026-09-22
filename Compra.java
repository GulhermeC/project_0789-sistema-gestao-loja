import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Compra {
    private Cliente cliente;
    private Produto produto;
    private double valorTotal;
    private int quantidade;
    private LocalDateTime data;
    
    public Compra() {
    }
    
    public Compra(Cliente cliente, Produto produto, double valorTotal, int quantidade) {
        this.cliente = cliente;
        this.produto = produto;
        this.valorTotal = valorTotal;
        this.quantidade = quantidade;
        this.data = LocalDateTime.now();
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
    
    public double getValorTotal() {
        return valorTotal;
    }
    
    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
    
    public int getQuantidade() {
        return quantidade;
    }
    
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getInfo() {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        return "Compra"
                + "\n  Cliente: " + getCliente().getNome()
                + "\n  Produto: " + getProduto().getNome()
                + "\n  Quantidade: " + getQuantidade()
                + "\n  Valor total: " + getValorTotal()
                + "\n  Data: " + getData().format(formato)
                + "\n";
    }

    public LocalDateTime getData() {
        return data;
    }
}

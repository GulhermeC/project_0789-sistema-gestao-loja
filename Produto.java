public class Produto implements Descontavel {
    private String nome;
    private double preco;
    private int quantidadeEmStock;
    private String categoria;

    public Produto(String nome, double preco, int quantidadeEmStock, String categoria) {
        this.nome = nome;
        this.preco = preco;
        this.quantidadeEmStock = quantidadeEmStock;
        this.categoria = categoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidadeEmStock() {
        return quantidadeEmStock;
    }

    public void setQuantidadeEmStock(int quantidadeEmStock) {
        this.quantidadeEmStock = quantidadeEmStock;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double aplicarDesconto(double percentagem) {
        if (percentagem < 0 || percentagem > 100) {
            return -1;
        }

        double novoPreco = preco * (1 - percentagem / 100);

        setPreco(novoPreco);

        return novoPreco;
    }

    public String getInfo() {
        return "Produto: " + getNome()
                + "\n  Preço: " + getPreco()
                + "\n  Stock: " + getQuantidadeEmStock()
                + "\n  Categoria: " + getCategoria();
    }
}
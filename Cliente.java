public class Cliente extends Pessoa {
    private double saldo;

    public Cliente() {
    }

    public Cliente(String nome, int contacto, double saldo) {
        super(nome, contacto);
        this.saldo = saldo;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getInfo() {
        return "Nome: " + getNome() + "\nContacto: " + getContacto() + "\nSaldo: " + getSaldo() + "\n";
    }
}

public class Cliente extends Pessoa {
    private double saldo;

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
        return "Cliente: " + getNome()
                + "\n  Contacto: " + getContacto()
                + "\n  Saldo: " + getSaldo();
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Cliente)) {
            return false;
        }

        Cliente outroCliente = (Cliente) obj;

        return getNome().equalsIgnoreCase(outroCliente.getNome())
                && getContacto() == outroCliente.getContacto();
    }
}

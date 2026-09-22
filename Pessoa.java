public class Pessoa {
    protected String nome;
    protected int contacto;
    
    public Pessoa(String nome, int contacto) {
        this.nome = nome;
        this.contacto = contacto;
    }
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getContacto() {
        return contacto;
    }
    public void setContacto(int contacto) {
        this.contacto = contacto;
    }
}

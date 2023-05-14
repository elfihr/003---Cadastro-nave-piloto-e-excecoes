package Classes;

public class Pessoa extends Piloto{
    private String nome;
    private String cpf;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String breve() {
        return "PILOTO: " + nome + " CPF:" + cpf +
                "\nNUMERO DA LICENÇA: " + getNumLicenca() + "\n----------------------------------------";
    }
}

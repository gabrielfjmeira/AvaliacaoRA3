public class Registro {

    //Atributo do código de registro
    private int codRegistro;

    //Atributo do próximo registro
    private Registro proximo;

    //Método Construtor
    public Registro(int codRegistro) {
        this.codRegistro = codRegistro;
        this.proximo = null;
    }

    //Função que retorna o código de registro do registro em questão
    public int getCodRegistro() {
        return this.codRegistro;
    }

    //Função que define o código de registro do registro em questão
    public void setCodRegistro(int codRegistro) {
        this.codRegistro = codRegistro;
    }

    //Função que retorna o próximo registro do registro em questão
    public Registro getProximo() {
        return this.proximo;
    }

    //Função que define o próximo registro do registro em questão
    public void setProximo(Registro proximo) {
        this.proximo = proximo;
    }
}


public class TabelaHash {

    //Atributo do tamanho da tabela hash
    private int tamanho;

    //Atributo do vetor da tabela hash
    private Registro[] tabelaHash;


    //Método construtor
    public TabelaHash(int tamanho){
        this.tamanho = tamanho;
        this.tabelaHash = new Registro[this.tamanho];
    }

    //Método de inserção da tabela hash
    public long insercaoTabelaHash(Registro noInserido, int metodo){
        //Definição de variáveis
        int index = -1;
        int codRegistro = noInserido.getCodRegistro();

        //Seleção do index referente ao método escolhido
        if (metodo == 1){
            //Index do vetor baseado no método de resto de divisão
            index = codRegistro % this.tamanho;
        }else if(metodo == 2){
            //Index do vetor baseado no método de multiplicação (Fibonacci Hashing)
            index = (int) (this.tamanho * ((codRegistro * 0.618) % 1));
        } else if (metodo == 3) {
            //Index do vetor baseado no método de dobramento
            int codRegistroAux = codRegistro;
            int soma = 0;
            while (codRegistroAux > 0) {
                //Seleciona os dois últimos dígitos de cada bloco
                soma = soma + (codRegistroAux % 100);
                //Atualiza a chave auxiliar (diminuindo suas casas decimais)
                codRegistroAux = codRegistroAux / 100;
            }
            //Gera o index baseado no método de dobramento (resto da divisão da soma dos dois dígitos de cada bloco pelo tamanho da tabela hash)
            index = soma % this.tamanho;
        }

        //Inserção no vetor
        long colisoes = 0;
        if (index != -1){
            if (this.tabelaHash[index] == null){
                this.tabelaHash[index] = noInserido;
            }else {
                //Lista encadeada
                //Sem nenhum elemento na lista
                if (this.tabelaHash[index].getProximo() == null){
                    this.tabelaHash[index].setProximo(noInserido);
                }else {
                    //A lista já possuí elementos
                    Registro noAnterior = this.tabelaHash[index];
                    Registro noAtual = this.tabelaHash[index].getProximo();
                    Registro noAtualAux = null;
                    Registro noPosterior = null;
                    Registro noPosteriorAux = null;
                    if (noAtual.getProximo() != null){
                        noPosterior = noAtual.getProximo();
                    }

                    //Loop para posicionar o novo registro que foi inserido
                    while (true){
                        //Com mais elementos na lista
                        if (noPosterior != null){
                            //Verifica se o nó atual é maior que o elemento inserido
                            if (noAtual.getCodRegistro() > noInserido.getCodRegistro()) {
                                noAnterior.setProximo(noInserido);
                                noInserido.setProximo(noAtual);
                                break;
                            //Verifica o valor do código de registro para ordenar de forma crescente
                            }else if (noAtual.getCodRegistro() <= noInserido.getCodRegistro() && noPosterior.getCodRegistro() > noInserido.getCodRegistro()){
                                //Insere o nó inserido entre os nós
                                noAtual.setProximo(noInserido);
                                noInserido.setProximo(noPosterior);
                                break;
                            }else{
                                //Atualiza os nós e continua o loop;
                                noAtualAux = noAtual;
                                noPosteriorAux = noPosterior;

                                noAnterior = noAtualAux;
                                noAtual = noPosteriorAux;
                                noPosterior = noAtual.getProximo();
                                colisoes ++;
                            }
                            //fim da lista
                        }else{
                            //Verifica o valor do código de registro para ordenar de forma crescente
                            if (noAtual.getCodRegistro() <= noInserido.getCodRegistro()){
                                //Insere o nó inserido após o último nó
                                noAtual.setProximo(noInserido);
                            }else{
                                //Insere o nó inserido antes o último nó
                                noAnterior.setProximo(noInserido);
                                noInserido.setProximo(noAtual);
                            }
                            break;
                        }
                    }
                }
            }
        }

        return colisoes;
    }

    //Método de busca
    public boolean buscaCodRegistroTabelaHash(int codRegistro, int metodo){
        //Definição do index
        int index = -1;

        //Definição da variável de metodoString
        String metodoString = "";
        if (metodo == 1){
            metodoString = "resto de divisão";
        }else if (metodo == 2) {
            metodoString = "multiplicação";
        }else if (metodo == 3) {
            metodoString = "dobramento";
        }

        //Definição do index referente ao método escolhido
        if (metodo == 1){
            //Index do vetor baseado no método de resto de divisão
            index = codRegistro % this.tamanho;
        }else if(metodo == 2){
            //Index do vetor baseado no método de multiplicação (Fibonacci Hashing)
            index = (int) (this.tamanho * ((codRegistro * 0.618) % 1));
        } else if (metodo == 3) {
            //Index do vetor baseado no método de dobramento
            int codRegistroAux = codRegistro;
            int soma = 0;
            while (codRegistroAux > 0) {
                //Seleciona os dois últimos dígitos de cada bloco
                soma = soma + (codRegistroAux % 100);
                //Atualiza a chave auxiliar (diminuindo suas casas decimais)
                codRegistroAux = codRegistroAux / 100;
            }
            //Gera o index baseado no método de dobramento (resto da divisão da soma dos dois dígitos de cada bloco pelo tamanho da tabela hash)
            index = soma % this.tamanho;
        }

        //Se possuir um index diferente de -1 verifica se o elemento está na tabela
        if (index != -1){
            //Percorre lista encadeada no index
            long colisoes = 0;
            Registro noAtual = this.tabelaHash[index];
            while (noAtual.getCodRegistro() != codRegistro && noAtual != null){
                noAtual = noAtual.getProximo();
                colisoes ++;
            }
            //Verifica se encontrou o elemento
            if (noAtual.getCodRegistro() == codRegistro){
                //Imprime resultado da busca
                System.out.println("O código de registro: " + codRegistro + ", foi encontrado utilizando o método de " + metodoString + " no index: " + index + ". Total de colisões: " + colisoes + ".");
                //Retorna verdadeiro
                return true;
            }
        }

        //Imprime resultado da busca
        System.out.println("O código de registro: " + codRegistro + ", não foi encontrado utilizando o método de " + metodoString + " no index: " + index + ".");
        //Retorna falso
        return false;
    }

    //Método de remoção
    public void remocaoTabelaHash(int codRegistro, int metodo){

        //Busca o elemento para ver se ele está inserido para realizar a remoção
        boolean achouCodigoRegistro = buscaCodRegistroTabelaHash(codRegistro, metodo);

        //Definição da variável de metodoString
        String metodoString = "";
        if (metodo == 1){
            metodoString = "resto de divisão";
        }else if (metodo == 2) {
            metodoString = "multiplicação";
        }else if (metodo == 3) {
            metodoString = "dobramento";
        }

        //Se o elemento estiver na tabela hash, ele pode ser removido
        //Definição do index
        int index = -1;

        //Definição do index referente ao método escolhido
        if (metodo == 1){
            //Index do vetor baseado no método de resto de divisão
            index = codRegistro % this.tamanho;
        }else if(metodo == 2){
            //Index do vetor baseado no método de multiplicação (Fibonacci Hashing)
            index = (int) (this.tamanho * ((codRegistro * 0.618) % 1));
        } else if (metodo == 3) {
            //Index do vetor baseado no método de dobramento
            int codRegistroAux = codRegistro;
            int soma = 0;
            while (codRegistroAux > 0) {
                //Seleciona os dois últimos dígitos de cada bloco
                soma = soma + (codRegistroAux % 100);
                //Atualiza a chave auxiliar (diminuindo suas casas decimais)
                codRegistroAux = codRegistroAux / 100;
            }
            //Gera o index baseado no método de dobramento (resto da divisão da soma dos dois dígitos de cada bloco pelo tamanho da tabela hash)
            index = soma % this.tamanho;
        }

        //Verifica se encontrou o nó
        if (achouCodigoRegistro == true){
            if (index != -1) {
                //Percorre lista encadeada no index
                Registro noAnterior = null;
                Registro noAtual = this.tabelaHash[index];
                Registro noPosterior = null;
                if (noAtual.getProximo() != null) {
                    noPosterior = noAtual.getProximo();
                }
                long colisoes = 0;

                //Busca o registro a ser removido
                while (noAtual.getCodRegistro() != codRegistro && noAtual != null) {
                    noAnterior = noAtual;
                    noAtual = noPosterior;
                    if (noAtual.getProximo() != null) {
                        noPosterior = noAtual.getProximo();
                    } else {
                        noPosterior = null;
                    }
                    //Atualiza o número de colisões
                    colisoes ++;
                }

                //Remove o registro
                //É o primeiro elemento da lista
                if (this.tabelaHash[index] == noAtual) {
                    this.tabelaHash[index] = noPosterior;
                //Não é o primeiro elemento da lista
                } else {
                    noAnterior.setProximo(noPosterior);
                }

                //Impressão do resultado da remoção
                System.out.println("O código de registro: " + codRegistro + ", foi removida utilizando o método de " + metodoString + " no index: " + index + ". Total de colisões: " + colisoes + ".");
            }
        }else{
            //Impressão do resultado da remoção
            System.out.println("O código de registro: " + codRegistro + ", não foi encontrada para remoção utilizando o método de " + metodoString + " no index: " + index + ".");
        }
    }

    //Impressão da tabela hash
    public void imprimeTabelaHash(){
        for (int i = 0; i < tamanho; i++) {
            //Nó atual
            Registro noAtual = this.tabelaHash[i];
            if (noAtual != null){
                System.out.print("Posição: "+ i + " - " + noAtual.getCodRegistro() + " => ");

                //Nó posterior
                Registro noPosterior = null;
                if (noAtual.getProximo() != null){
                    noPosterior = noAtual.getProximo();
                }

                //Concatena a lista encadeada
                while (noPosterior != null){
                    System.out.print(noPosterior.getCodRegistro() + " => ");
                    noAtual = noPosterior;
                    if (noAtual != null){
                        noPosterior = noAtual.getProximo();
                    }else{
                        noPosterior = null;
                    }
                }

                //Termina a impressão da lista
                System.out.println("null");
            }else{
                //Imprime o elemento vazio
                System.out.println("null");
            }
        }
    }
}

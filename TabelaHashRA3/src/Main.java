import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Criação do Scanner
        Scanner sc = new Scanner(System.in);

        //Criação do gerador de números aleatórios
        Random gerador = new Random();
        int valorMin = 100000000;
        int valorMax = 999999999;

        //Criação das tabelas hash
        TabelaHash tabelaHashRD = null;
        TabelaHash tabelaHashM = null;
        TabelaHash tabelaHashD = null;

        //Variáveis de tempo
        long comecoRD = 0;
        long fimRD = 0;
        long tempoTotalRD = 0;

        long comecoM = 0;
        long fimM = 0;
        long tempoTotalM = 0;

        long comecoD = 0;
        long fimD = 0;
        long tempoTotalD = 0;

        //Menu de criação da tabela hash
        int opcaoTamanho = -1;
        while (opcaoTamanho != 0){
            //Seleção do tamanho da tabela hash
            System.out.println("0. Sair");
            System.out.println("1. 10");
            System.out.println("2. 100");
            System.out.println("3. 1.000");
            System.out.println("4. 10.000");
            System.out.println("5. 100.000");
            System.out.println("SELECIONE O TAMANHO DA TABELA HASH:");
            int escolhaTamanho = sc.nextInt();

            switch (escolhaTamanho){
                case 0:
                    //Para a execução do programa
                    System.exit(0);
                    break;
                case 1:
                    //Definições dos tamanho das tabelas hash
                    tabelaHashRD = new TabelaHash(10);
                    tabelaHashM = new TabelaHash(10);
                    tabelaHashD = new TabelaHash(10);
                    opcaoTamanho = 0;
                    break;
                case 2:
                    //Definições dos tamanho das tabelas hash
                    tabelaHashRD = new TabelaHash(100);
                    tabelaHashM = new TabelaHash(100);
                    tabelaHashD = new TabelaHash(100);
                    opcaoTamanho = 0;
                    break;
                case 3:
                    //Definições dos tamanho das tabelas hash
                    tabelaHashRD = new TabelaHash(1000);
                    tabelaHashM = new TabelaHash(1000);
                    tabelaHashD = new TabelaHash(1000);
                    opcaoTamanho = 0;
                    break;
                case 4:
                    //Definições dos tamanho das tabelas hash
                    tabelaHashRD = new TabelaHash(10000);
                    tabelaHashM = new TabelaHash(10000);
                    tabelaHashD = new TabelaHash(10000);
                    opcaoTamanho = 0;
                    break;
                case 5:
                    //Definições dos tamanho das tabelas hash
                    tabelaHashRD = new TabelaHash(100000);
                    tabelaHashM = new TabelaHash(100000);
                    tabelaHashD = new TabelaHash(100000);
                    opcaoTamanho = 0;
                    break;
                default:
                    //Opção inválida
                    System.out.println("Selecione uma opção válida!");
                    break;
            }
        }

        //Menu de operações na tabela hash
        int opcaoOperacao = -1;
        while (opcaoOperacao != 0){

            //Seleção da operação
            System.out.println("0. Sair");
            System.out.println("1. Impressão");
            System.out.println("2. Gerar Seed");
            System.out.println("3. Gerar Tabelas Hash");
            System.out.println("4. Buscar");
            System.out.println("5. Remover");
            System.out.println("6. Inserir um elemento nas três tabelas");
            System.out.println("SELECIONE A OPERAÇÃO:");
            int escolhaOperacao = sc.nextInt();

            switch (escolhaOperacao){
                case 0:
                    //Interrompe a execução do sistema
                    System.exit(0);
                    break;
                case 1:
                    //Seleção da tabela hash para impressão
                    int opcaoImpressao = -1;
                    while (opcaoImpressao != 0){
                        System.out.println("0. Voltar");
                        System.out.println("1. Resto de Divisão");
                        System.out.println("2. Multiplicação");
                        System.out.println("3. Dobramento");
                        System.out.println("SELECIONE UMA OPÇÃO: ");
                        opcaoImpressao = sc.nextInt();

                        switch (opcaoImpressao){
                            case 0:
                                //Volta para o menu de operações
                                break;
                            case 1:
                                //Imprime a tabela hash de resto de divisão
                                tabelaHashRD.imprimeTabelaHash();
                                opcaoImpressao = 0;
                                break;
                            case 2:
                                //Imprime a tabela hash de Multiplicação
                                tabelaHashM.imprimeTabelaHash();
                                opcaoImpressao = 0;
                                break;
                            case 3:
                                //Imprime a tabela hash de Dobramento
                                tabelaHashD.imprimeTabelaHash();
                                opcaoImpressao = 0;
                                break;
                            default:
                                //Opção inválida
                                System.out.println("Selecione uma opção válida!");
                                break;
                        }
                    }
                    break;
                case 2:
                    //Insercao na tabela hash
                    int qtdElementos = 0;
                    int opcaoNumeroElementos = -1;
                    while (opcaoNumeroElementos != 0){
                        //Seleção da quantidade de elementos a serem inseridos
                        System.out.println("1. 50 mil");
                        System.out.println("2. 100 mil");
                        System.out.println("3. 250 mil");
                        System.out.println("4. 500 mil");
                        System.out.println("5. 1 milhão");
                        System.out.println("SELECIONE A QUANTIDADE DE ELEMENTOS:");
                        int escolhaElementos = sc.nextInt();

                        switch (escolhaElementos){
                            case 1:
                                //50 mil elementos
                                qtdElementos = 50000;
                                opcaoNumeroElementos = 0;
                                break;
                            case 2:
                                //100 mil elementos
                                qtdElementos = 100000;
                                opcaoNumeroElementos = 0;
                                break;
                            case 3:
                                //250 mil elementos
                                qtdElementos = 250000;
                                opcaoNumeroElementos = 0;
                                break;
                            case 4:
                                //500 mil elementos
                                qtdElementos = 500000;
                                opcaoNumeroElementos = 0;
                                break;
                            case 5:
                                //1 milhão de elementos
                                qtdElementos = 1000000;
                                opcaoNumeroElementos = 0;
                                break;
                            default:
                                //Opção inválida
                                System.out.println("Selecione uma opção válida!");
                                break;
                        }
                    }

                    try{
                        //Criação do arquivo TXT
                        FileWriter fw = new FileWriter("seed.txt");
                        PrintWriter pw = new PrintWriter(fw);

                        //Popula os elementos no vetor
                        for (int i = 0; i < qtdElementos; i++){
                            int numero = gerador.nextInt(valorMax + 1);
                            pw.println(numero);
                        }

                        //Salva e fecha o txt
                        pw.flush();
                        pw.close();
                        fw.close();

                    }catch (Exception e){
                        System.out.println("Erro ao gerar seed!");
                    }

                    break;
                case 3:
                    //Leitura de arquivo TXT com os dados
                    Path caminho = Paths.get("C:\\Users\\Gabriel F\\Documents\\Faculdade\\4º Período\\Estrutura de Dados\\TabelaHashRA3\\seed.txt");

                    int opcaoGerarTabelaHash = -1;
                    while (opcaoGerarTabelaHash != 0){
                        long colisoesTotais = 0;

                        //Gerar tabela hash
                        System.out.println("0. Voltar");
                        System.out.println("1. Resto de Divisão");
                        System.out.println("2. Multiplicação ");
                        System.out.println("3. Dobramento");
                        System.out.println("GERAR TABELA HASH NÚMERO: ");
                        opcaoGerarTabelaHash = sc.nextInt();

                        switch (opcaoGerarTabelaHash){
                            case 0:
                                //Volta para o menu de operações
                                break;
                            case 1:
                                //Começa a contagem do tempo
                                comecoRD = System.nanoTime();
                                try {
                                    //Percorre arquivo de seed
                                    Scanner scF = new Scanner(caminho);
                                    while(scF.hasNextLine()){
                                        Registro novoRegistro = new Registro(Integer.parseInt(scF.nextLine()));
                                        colisoesTotais += tabelaHashRD.insercaoTabelaHash(novoRegistro, 1);
                                    }
                                }catch (Exception e){
                                    System.out.println("Erro ao gerar tabela hash usando resto de divisão!");
                                }
                                //Finaliza a contagem do tempo
                                fimRD = System.nanoTime();

                                //Calcula o tempo total da execução
                                tempoTotalRD = (fimRD - comecoRD) / 1000; // Converter para microssegundos

                                //Imprime o tempo total da execução
                                System.out.println("Tempo total da geração da tabela hash RD: " + tempoTotalRD + " microssegundos. Colisões totais: " + colisoesTotais + ".");
                                opcaoGerarTabelaHash = 0;
                                break;
                            case 2:
                                //Começa a contagem do tempo
                                comecoM = System.nanoTime();
                                try {
                                    //Percorre arquivo de seed
                                    Scanner scF = new Scanner(caminho);
                                    while(scF.hasNextLine()){
                                        Registro novoRegistro = new Registro(Integer.parseInt(scF.nextLine()));
                                        colisoesTotais += tabelaHashM.insercaoTabelaHash(novoRegistro, 2);
                                    }
                                }catch (Exception e){
                                    System.out.println("Erro ao gerar tabela hash usando multiplicação!");
                                }
                                //Finaliza a contagem do tempo
                                fimM = System.nanoTime();

                                //Calcula o tempo total da execução
                                tempoTotalM = (fimM - comecoM) / 1000; // Converter para microssegundos

                                //Imprime o tempo total da execução
                                System.out.println("Tempo total da geração da tabela hash M: " + tempoTotalM + " microssegundos. Colisões totais: " + colisoesTotais + ".");
                                opcaoGerarTabelaHash = 0;
                                break;
                            case 3:
                                //Começa a contagem do tempo
                                comecoD = System.nanoTime();
                                try {
                                    //Percorre arquivo de seed
                                    Scanner scF = new Scanner(caminho);
                                    while(scF.hasNextLine()){
                                        Registro novoRegistro = new Registro(Integer.parseInt(scF.nextLine()));
                                        colisoesTotais += tabelaHashD.insercaoTabelaHash(novoRegistro, 3);
                                    }
                                }catch (Exception e){
                                    System.out.println("Erro ao gerar tabela hash usando dobramento!");
                                }
                                //Finaliza a contagem do tempo
                                fimD = System.nanoTime();

                                //Calcula o tempo total da execução
                                tempoTotalD = (fimD - comecoD) / 1000; // Converter para microssegundos

                                //Imprime o tempo total da execução
                                System.out.println("Tempo total da geração da tabela hash D: " + tempoTotalD + " microssegundos. Colisões totais: " + colisoesTotais + ".");
                                opcaoGerarTabelaHash = 0;
                                break;
                            default:
                                //Opção inválida
                                System.out.println("Selecione uma opção válida!");
                                break;
                        }
                    }
                    break;
                case 4:
                    //Busca de registro
                    System.out.println("INSIRA O REGISTRO A SER BUSCADO: ");
                    int registroBusca = sc.nextInt();

                    //Chama os métodos de busca
                    //Resto de divisão
                    comecoRD = System.nanoTime();
                    tabelaHashRD.buscaCodRegistroTabelaHash(registroBusca, 1);
                    fimRD = System.nanoTime();
                    tempoTotalRD = (fimRD - comecoRD) / 1000; // Converter para microssegundos
                    System.out.println("Tempo total da busca na tabela hash RD: " + tempoTotalRD + " microssegundos");

                    //Multiplicação
                    comecoM = System.nanoTime();
                    tabelaHashM.buscaCodRegistroTabelaHash(registroBusca, 2);
                    fimM = System.nanoTime();
                    tempoTotalM = (fimM - comecoM) / 1000; // Converter para microssegundos
                    System.out.println("Tempo total da busca na tabela hash M: " + tempoTotalM + " microssegundos");

                    //Dobramento
                    comecoD = System.nanoTime();
                    tabelaHashD.buscaCodRegistroTabelaHash(registroBusca, 3);
                    fimD = System.nanoTime();
                    tempoTotalD = (fimD - comecoD) / 1000; // Converter para microssegundos
                    System.out.println("Tempo total da remoção na tabela hash D: " + tempoTotalD + " microssegundos");

                    break;
                case 5:
                    //Remoção de registro da tabela hash
                    System.out.println("INSIRA O REGISTRO A SER REMOVIDO: ");
                    int registroRemocao = sc.nextInt();

                    //Chama os métodos de remoção
                    //Resto de Divisão
                    comecoRD = System.nanoTime();
                    tabelaHashRD.remocaoTabelaHash(registroRemocao, 1);
                    fimRD = System.nanoTime();
                    tempoTotalRD = (fimRD - comecoRD) / 1000; // Converter para microssegundos
                    System.out.println("Tempo total da remoção na tabela hash RD: " + tempoTotalRD + " microssegundos");

                    //Multiplicação
                    comecoM = System.nanoTime();
                    tabelaHashM.remocaoTabelaHash(registroRemocao, 2);
                    fimM = System.nanoTime();
                    tempoTotalM = (fimM - comecoM) / 1000; // Converter para microssegundos
                    System.out.println("Tempo total da remoção na tabela hash M: " + tempoTotalM + " microssegundos");

                    //Dobramento
                    comecoD = System.nanoTime();
                    tabelaHashD.remocaoTabelaHash(registroRemocao, 3);
                    fimD = System.nanoTime();
                    tempoTotalD = (fimD - comecoD) / 1000; // Converter para microssegundos
                    System.out.println("Tempo total da remoção na tabela hash D: " + tempoTotalD + " microssegundos");

                    break;
                case 6:
                    //Inserir registro nas três tabelas hash
                    System.out.println("INSIRA O CÓDIGO DE REGISTRO A SER INSERIDO NAS TABELAS: ");
                    int codigo = sc.nextInt();
                    Registro registro = new Registro(codigo);
                    tabelaHashRD.insercaoTabelaHash(registro, 1);
                    tabelaHashM.insercaoTabelaHash(registro, 2);
                    tabelaHashD.insercaoTabelaHash(registro, 3);
                    System.out.println(codigo + " inserido nas tabelas hash!");
                    break;
                default:
                    //Opção inválida
                    System.out.println("Selecione uma opção válida!");
                    break;
            }
        }
    }
}
package caixaeletronico;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CaixaEletronico {
    
    public static void limpaTela(){
        for (int count = 0 ; count < 100 ; count++){
            System.out.println("");
        }
    }
    
    public static void main(String[] args){
        String cpf = "123.456.789-00";
        String senha = "01020304";
        int saldo = 1000, operacao = 0, deposito, saque, transferencia;
        String cpfUser, senhaUser;
        Scanner ler = new Scanner(System.in);
        List valor = new ArrayList(0);
        List lancamento = new ArrayList(0);
        
        while (operacao == 0){
            System.out.println("==========================");
            System.out.println("     CAIXA ELETRÔNICO     ");
            System.out.println("     Seja bem vindo(a)     ");
            System.out.println("==========================");

            System.out.print("Informe seu CPF: ");
            cpfUser = ler.next();
            if (cpfUser.equals(cpf)){
                tentativas: {
                    for (int count = 0 ; count < 2 ; count++){
                        System.out.print("Informe sua senha: ");
                        senhaUser = ler.next();
                        if (senhaUser.equals(senha)) break tentativas;
                        else switch (count){
                            case 0:
                                System.out.println("");
                                System.out.println("Senha incorreta! Resta mais uma tentativa.");
                                break;
                            case 1:
                                System.out.println("");
                                System.out.println("Senha incorreta! Conta bloqueada!");
                                System.exit(0);
                        }
                    }
                }
                limpaTela();
                
                System.out.println("================");
                System.out.println("      MENU      ");
                System.out.println("================");
                System.out.println("[1] - Saldo");
                System.out.println("[2] - Depósito");
                System.out.println("[3] - Saque");
                System.out.println("[4] - Transferência");
                System.out.println("[5] - Extrato");
                System.out.println("[0] - Sair");
                System.out.println("================");

                do{
                    System.out.println("");
                    System.out.print("Informe a operação que deseja: ");
                    operacao = ler.nextInt();
                    switch (operacao){
                        case 1:
                            System.out.println("Seu Saldo atual: R$" + saldo);
                            lancamento.add("Saldo atual  ");
                            valor.add(saldo);
                            break;
                        case 2:
                            System.out.print("Informe o valor do depósito: R$");
                            deposito = ler.nextInt();
                            saldo += deposito;
                            lancamento.add("Depósito     ");
                            valor.add(deposito);
                            break;
                        case 3:
                            System.out.print("Informe o valor do saque: R$");
                            saque = ler.nextInt();
                            saldo -= saque;
                            lancamento.add("Saque        ");
                            valor.add(saque);
                            break;
                        case 4:
                            System.out.print("Valor da transferência: R$");
                            transferencia = ler.nextInt();
                            System.out.print("Número da conta: ");
                            int conta = ler.nextInt();
                            System.out.print("Agência: ");
                            int agencia = ler.nextInt();
                            System.out.print("Banco: ");
                            String banco = ler.next();
                            saldo -= transferencia;
                            lancamento.add("Transferência");
                            valor.add(transferencia);
                            break;
                        case 5:
                            System.out.println("===========EXTRATO===========");
                            System.out.println("Lançamento             Valor \n");
                            System.out.println("Saldo anterior         R$1000");
                            for (int count = 0; count < valor.size() ; count++){
                                System.out.println(lancamento.get(count) + "          R$" + valor.get(count));
                            }
                            System.out.println("=============================");
                            break;
                        case 0:
                            limpaTela();
                            break;
                        default:
                            System.out.println("Opção inválida! Tente novamente.");
                            break;
                    }
                } while(operacao != 0);
            } else {
                    System.out.println("Tela de acesso não permitida!");
                    System.exit(0);
            }
        }
    }
}
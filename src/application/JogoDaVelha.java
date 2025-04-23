package application;

import java.util.Scanner;

public class JogoDaVelha {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char[][] Campos = new char[3][3];
        boolean jogo = true;
        int cont = 2;
        int contx = 0;
        boolean jogada = true;
        boolean vez = true;
        boolean partida = false;

        int vezx;
        int vezy;

        criartabu(Campos);

        System.out.println("%n bem vindos ao jogo da velha do tiago");

        do {
criartabu(Campos);

            while (jogo) {

                if (cont % 2 == 0) {
                    System.out.println("vez do X");


                } else {
                    System.out.println("vez do O");

                }
                printtabu(Campos);
                //printa o tabuleiro!
                vezx = scan.nextInt();              //escolhe o quadrante
                vezy = scan.nextInt();
                while (!verificador(Campos, vezx, vezy)) {
                    System.out.println("Posição invalida! tente novamente:");
                    vezx = scan.nextInt();
                    vezy = scan.nextInt();

                }
        /// 
                if (jogada) {

                    Campos[vezx][vezy] = 'X';
                } else {

                    Campos[vezx][vezy] = 'O';
                }
                if (!vitoriaX(Campos)) {
                    contx++;
                }

                if (vitoriaX(Campos)) {
                    break;
                }
                if (vitoriaO(Campos)) {
                    break;
                }

                cont++;

                if (contx == 9) {
                    break;
                }

                jogada = !jogada;
            } //fim do while principal!
            printtabu(Campos);
            if (vitoriaX(Campos)) {
                System.out.println("Fim de jogo o =X= é o vencedor! ");
            }
            if (vitoriaO(Campos)) {
                System.out.println("Fim de jogo o =BolaO= é o vencedor! ");
            }
            if (contx == 9) {
                System.out.println("FIM DE JOGO O RESULTADO FOI VELHA!");
            }


            System.out.println("deseja jogar novamente? s/n");
            String res = scan.next();
            if (res.charAt(0) == 'n') {
                partida = false;
            }
            else if(res.charAt(0) =='s') {
                partida = true;
            }
        }while(partida);
    }
    public static void criartabu(char[][] tabu){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tabu [i][j] = ' ';
            }

        }


    }

    public static void printtabu(char[][] tabu) {
        System.out.println("    0-  1-  2-");
        System.out.println(" 0- " + tabu[0][0] + " | " + tabu[0][1] + " | " + tabu[0][2]);
        System.out.println("  -------------");
        System.out.println(" 1- " + tabu[1][0] + " | " + tabu[1][1] + " | " + tabu[1][2]);
        System.out.println("  -------------");
        System.out.println(" 2- " + tabu[2][0] + " | " + tabu[2][1] + " | " + tabu[2][2]);

    }

    public static boolean verificador (char[][] list, int vezx, int vezy){
        if (list[vezx][vezy] != ' '){
            return false;
        }
        return true;
    }

    public static boolean vitoriaX(char [][] list){
        if (list[0][0] == 'X' && list[0][1] =='X' && list[0][2] == 'X'){
            return true;
        }
        if (list[1][0] == 'X' && list[1][1] =='X' && list[1][2] == 'X'){
            return true;
        }
        if (list[2][0] == 'X' && list[2][1] =='X' && list[2][2] == 'X'){
            return true;
        } if (list[0][0] == 'X' && list[1][0] =='X' && list[2][0] == 'X'){
            return true;
        }
        if (list[0][1] == 'X' && list[1][1] =='X' && list[2][1] == 'X'){
            return true;
        } if (list[0][2] == 'X' && list[1][2] =='X' && list[2][2] == 'X'){
            return true;
        }
        if (list[0][0] == 'X' && list[1][1] =='X' && list[2][2] == 'X'){
            return true;
        }
        if (list[0][2] == 'X' && list[1][1] =='X' && list[2][0] == 'X'){
            return true;
        }

        return false;
    }

    public static boolean vitoriaO(char [][] list){
        if (list[0][0] == 'O' && list[0][1] =='O' && list[0][2] == 'O'){
            return true;
        }
        if (list[1][0] == 'O' && list[1][1] =='O' && list[1][2] == 'O'){
            return true;
        }
        if (list[2][0] == 'O' && list[2][1] =='O' && list[2][2] == 'O'){
            return true;
        } if (list[0][0] == 'O' && list[1][0] =='O' && list[2][0] == 'O'){
            return true;
        }
        if (list[0][1] == 'O' && list[1][1] =='O' && list[2][1] == 'O'){
            return true;
        } if (list[0][2] == 'O' && list[1][2] =='O' && list[2][2] == 'O'){
            return true;
        }
        if (list[0][0] == 'O' && list[1][1] =='O' && list[2][2] == 'O'){
            return true;
        }
        if (list[0][2] == 'O' && list[1][1] =='O' && list[2][0] == 'O'){
            return true;
        }

        return false;
    }



}
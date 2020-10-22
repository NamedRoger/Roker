package com.NamedRoger;

import java.util.Scanner;

public class Game {
    private Poker poker;
    private int vecesJugadas;
    private boolean isPlayign;

    Game(){
        poker = new Poker();
    }

    public void play(){
        isPlayign = true;
        vecesJugadas = 1;
        do{
            showMenu();
            try {
                var op = inputOption();

                if(op != 0)
                    showDivision();

                evaluateOp(op);

                if(op != 0)
                    showDivision();

            }catch (Exception exception){
                System.out.println(exception.getMessage());
                showDivision();
            }
        }while (isPlayign);
    }

    public void showMenu(){
        if(vecesJugadas == 1)
            System.out.println("\tBienvenido a Roker!");

        System.out.println("Seleeciona una opción: \n");
        System.out.println("(1) Mezclar Deck");
        System.out.println("(2) Sacar una carta");
        System.out.println("(3) Carta al azar");
        System.out.println("(4) Generar una mano de 5 cartas");
        System.out.println("(5) Reiniciar el juego");
        System.out.println("(0) Salir");
    }

    private int inputOption() throws Exception{
        Scanner scn = new Scanner(System.in);
        var op = scn.nextInt();
        if(op <0 || op >5 )
            throw new Exception("Introduce una opción Valida");

        return op;
    }

    private static void showDivision(){
        System.out.println("-------------------------------");
    }

    private void evaluateOp(int op) throws Exception {
        switch (op){
            case 1:
                poker.shuffle();
                vecesJugadas++;
                break;
            case 2:
                poker.head();
                vecesJugadas++;
                break;
            case 3:
                poker.pick();
                vecesJugadas++;
                break;
            case 4:
                poker.hand();
                vecesJugadas++;
                break;
            case 5:
                poker.reset();
                vecesJugadas = 1;
                break;
            default:
                isPlayign = false;
                break;
        }
    }

}

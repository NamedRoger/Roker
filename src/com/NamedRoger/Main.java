package com.NamedRoger;

import java.util.*;

public class Main {


    public static void main(String[] args) {
        Deck deck = new Deck();
        boolean isRunning = true;
        int r = 1;
        deck.init();

        do{
            try{
                var op = showMenu(r);
                if(op <0 || op > 4){
                    throw new Exception("Introduce una opción valida");
                }
                switch (op){
                    case 1:
                        deck.shuffle();
                        break;
                    case 2:
                        deck.head();
                        break;
                    case 3:
                        deck.pick();
                        break;
                    case 4:
                        deck.hand();
                        break;
                    default:
                        isRunning = false;
                        break;
                }
                if(op != 0)
                    showDivision();
                
                System.out.println("");
                r++;
            }catch (Exception e){
                System.out.println(e.getMessage());
                System.out.println("");
                showDivision();
            }
        }while (isRunning);

    }

    public static int showMenu(int r){
        if(r == 1)
            System.out.println("\tBienvenido a Roker!");

        System.out.println("Seleeciona una opción: \n");
        System.out.println("(1) Mezclar Deck");
        System.out.println("(2) Sacar una carta");
        System.out.println("(3) Carta al azar");
        System.out.println("(4) Generar una mano de 5 cartas");
        System.out.println("(0) Salir");
        
        Scanner scn = new Scanner(System.in);
        var op = scn.nextInt();
        
        if(op != 0)
            showDivision();
        
        return op;
    }

    public static void showDivision(){
        System.out.println("-------------------------------");
    }


}

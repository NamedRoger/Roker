package com.NamedRoger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Deck {
    private HashMap<String,String> palos = new HashMap<String, String>();
    private ArrayList<Card> juego = new ArrayList<Card>();
    private String strFormat = "Quedan %s";

    Deck(){
        initPalos();
    }

    public ArrayList<Card> getJuego() {
        return juego;
    }

    public void initPalos(){
        palos.put("Diamante","Rojo");
        palos.put("Trebol","Negro");
        palos.put("Pica","Negro");
        palos.put("Corazon","Rojo");
    }

    public void init(){
        if (juego.size() > 1) juego.clear();

        for (Map.Entry<String,String> palo : palos.entrySet()){
           var paloCard = palo.getKey();
           var color = palo.getValue();

            Card card;
            for (int i=1;i <= 13;i++){
                card = new Card(paloCard, color);
                card.setValor(i);
                juego.add(card);
            }
        }
    }

    public void shuffle(){
        Collections.shuffle(juego);
        System.out.println("Se mezcló el Deck");
    }

    public void head(){
        var card = juego.get(juego.size()-1);
        juego.remove(card);
        System.out.println(card.toString());
        System.out.println(String.format(strFormat,juego.size()));
    }

    public void pick(){
        var card = randomCard();
        juego.remove(card);
        System.out.println(card.toString());
        System.out.println(String.format(strFormat,juego.size()));
    }

    public void hand(){
        if(juego.size() <= 5){
            for (var card:juego){
                printHand(juego);
            }
        }else {
            var cards = new ArrayList<Card>();
            Card card;
            for (int i=1;i<=5;i++){
                card = randomCard();
                juego.remove(card);
                cards.add(card);
            }
            printHand(cards);
            System.out.println(String.format(strFormat,juego.size()));
        }
    }

    private void printHand(ArrayList<Card> cards){
        cards.forEach(c -> System.out.println(c.toString()));
    }

    private Card randomCard(){
        var rnd = (int)Math.floor(Math.random()*(1-juego.size()+1)+juego.size());
        return juego.get(rnd);
    }
}

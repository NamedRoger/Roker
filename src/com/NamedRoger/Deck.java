package com.NamedRoger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Deck {
    public static  HashMap<String,String> palos = new HashMap<String,String>();

    private ArrayList<Card> juego = new ArrayList<Card>();

    Deck(){
        palos.put("Diamante","Rojo");
        palos.put("Corazón","Rojo");
        palos.put("Trébol","Negro");
        palos.put("Pica","Negro");

        init();

    }

    public ArrayList<Card> getJuego() {
        return juego;
    }

    public void init(){
        if (juego.size() > 1) juego.clear();

        for (Map.Entry<String,String> palo : palos.entrySet()){
           var paloCard = palo.getKey();
           var color = palo.getValue();
            Card card;
            for (int i=1;i <= 13;i++){
                card = new Card(paloCard, color, i);
                juego.add(card);
            }
        }
    }

    public void shuffle(){
        Collections.shuffle(juego);
    }

    public Card head(){
        return juego.remove(juego.size()-1);
    }

    public Card pick(){
        return juego.remove(randomCard());
    }

    public ArrayList<Card> hand(){
        var cards = new ArrayList<Card>();
        if(juego.size() <= 5){
            for (var card:juego){
                cards.add(head());
            }
        }else {
            for (int i=1;i<=5;i++){
                cards.add(pick());
            }
        }
        return cards;
    }

    private int randomCard(){
        var max = juego.size() -1;
        var rnd = (int)Math.floor(Math.random()*(0-max+1)+max);
        return rnd;
    }
}

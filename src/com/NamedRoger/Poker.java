package com.NamedRoger;

public class Poker {
    private Deck _deck;

    Poker(){
        _deck = new Deck();
    }

    public void shuffle(){
        _deck.shuffle();
        System.out.println("Se mezcló el Deck");
    }

    public void head(){
        showSelectedCard(_deck.head());
        showSizeDeck();
    }

    public void pick(){
        showSelectedCard(_deck.pick());
        showSizeDeck();
    }

    public void hand(){
        _deck.hand().forEach(c -> showSelectedCard(c));
        showSizeDeck();
    }

    public void reset(){
        _deck.init();
        _deck.shuffle();
        System.out.println("Se reinicio el juego \ny se mezclo el Deck");
    }

    private void showSizeDeck(){
        var messageCard = (_deck.getJuego().size() > 1)?"cartas":"carta";
        System.out.println(String.format("Quedan %s %s",_deck.getJuego().size(),messageCard));
    }

    private void showSelectedCard(Card card){
        var showCard = card.toString();
        System.out.println(String.format("La carta es %s",showCard));
    }
}

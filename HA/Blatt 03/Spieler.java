package com.company;
//2g

public class Spieler {
    Karte[] kartenhand;
    String name;
    double siegeschancen;

    //Konstruktoren
    public Spieler(Karte[] kartenhand,String name,double siegeschancen) {
        this.kartenhand=kartenhand;
        this.name=name;
        this.siegeschancen=siegeschancen;
    }


//2h
    static Spieler besterSpieler(Spieler...club){
        //falls keine Spieler vorhanden sind
        if(club==null){return null;}
        Spieler best=club[0];
        for (Spieler clubSpieler : club){
            if (clubSpieler.siegeschancen>best.siegeschancen){best=clubSpieler;}
        }
        return best;
    }

    void kannBedienen(Karte k){
        boolean kann=false;
        for (Karte handkarte : this.kartenhand) {
            if (handkarte.bedient(k)){kann=true;}
        }
        String output=kann ? this.name+" kann bedienen":this.name+" kann nicht bedienen";
        System.out.println(output);
    }



    @Override
    public String toString(){return "Spielername: "+this.name;}

    public static void main(String[] args){
        Karte karoBube=new Karte(FARBE.KARO,WERT.BUBE);
        Spieler elisabeth=new Spieler(null,"Elisabeth",37.5);
        Spieler klaus=new Spieler(null,"Klaus",12.5);
        Spieler helmut=new Spieler(null,"Helmut",38.75);
        Spieler erwin=new Spieler(null,"Erwin",12.25);
        Spieler bestOfClub= besterSpieler(elisabeth,klaus,helmut,erwin);
        Karte[] handOfTheBest= new Karte[3];
        handOfTheBest[0]=new Karte(FARBE.HERZ,WERT.SIEBEN);
        handOfTheBest[1]= new Karte(FARBE.HERZ,WERT.NEUN);
        handOfTheBest[2]= new Karte(FARBE.KARO,WERT.KOENIG);
        bestOfClub.kartenhand=handOfTheBest;
        bestOfClub.kannBedienen(karoBube);
    }
}
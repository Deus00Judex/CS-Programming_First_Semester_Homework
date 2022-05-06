package com.company;

public class Karte {
    FARBE colour;
    WERT value;

    //Konstruktoren
    public Karte(FARBE colour, WERT value) {
        this.value=value;
        this.colour=colour;
    }

    public static Karte neueKarte(FARBE f,WERT w){
        Karte k = new Karte(f,w);
        return k;
    }

//2c)

    static Karte neueKarte(String f,String w){
        FARBE enumF = FARBE.valueOf(f);
        WERT enumW = WERT.valueOf(w);
        Karte k=new Karte(enumF,enumW);
        return k;
    }

//2d
    static int kombinationen(){
        return WERT.values().length * FARBE.values().length;
    }

//2d
    static Karte[] skatblatt(){
        Karte[] skatblatt=new Karte[kombinationen()];
        for (int i=0;i<kombinationen();i++){
            for (FARBE colour : FARBE.values()){
                for (WERT value : WERT.values()){
                    skatblatt[i]=neueKarte(colour,value);
                }
            }
        }
        return skatblatt;
    }

    boolean bedient(Karte other){
        if (other==null){
            if (this.value==WERT.BUBE){return true;}
            else return false;
        }
        if(this.value == WERT.BUBE){return true;}
        else if(this.colour==other.colour ||this.value==other.value){return true;}
        else return false;
    }

    boolean bedienbar(Karte...karten){
        for(Karte card : karten){if(this.bedient(card)){return true;}}
        return false;
    }


//2f
    static void druckeEinbahnBediengungen(){
        Karte[] skatblatt= skatblatt();
        for(Karte card : skatblatt){
            for (Karte other : skatblatt){
                if(card.bedient(other)==true && other.bedient(card)==false){System.out.println(card.toString()+" bedient "+other.toString()+", aber "+other.toString()+" nicht "+card.toString());}
                else if(card.bedient(other)==false && other.bedient(card)==true){System.out.println(other.toString()+" bedient "+card.toString()+", aber "+card.toString()+" nicht "+other.toString());}
            }
        }
    }

    //toString
    public String toString() {
        String cardID = String.valueOf(this.colour) + String.valueOf(this.value);
        System.out.println(cardID);
        return cardID;
    }
}

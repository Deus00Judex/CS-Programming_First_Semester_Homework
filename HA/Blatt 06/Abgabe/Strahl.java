public class Strahl extends Gerade {
    boolean ist_p1_startPunkt;


    /**
     * @param p1 Einer der Punkte, durch den die Gerade geht
     * @param p2 Einer der Punkte, durch den die Gerade geht
     */
    public Strahl(Punkt p1, Punkt p2, boolean ist_p1_startPunkt) {
        super(p1, p2);
        this.ist_p1_startPunkt =ist_p1_startPunkt;
    }
    public Strahl(Punkt p1, Punkt p2) {
        super(p1, p2);
        this.ist_p1_startPunkt =true;
    }

    @Override
    public String toString() {
        return "Strahl mit Startpunkt "+this.p1.toString()+" und Durchlauf durch "+this.p2.toString();
    }
    public boolean startsFromp1(){
        if(this.ist_p1_startPunkt) return true;
        else return false;
    }
    public boolean startsFromp2(){
        if(!this.ist_p1_startPunkt) return true;
        else return false;
    }
    /**
     *Aufgabenteil g) Es ist nicht möglich, da hier ein neues Objekt erzeugt wird, dass lediglich zur Erzeugung die Werte bekommen hat, die zum Strahl gehören
     */
     protected Gerade verlaengern(){
        Gerade rueckgabe=new Gerade(this.p1,this.p2);
        return rueckgabe;
    }
    public boolean enthaelt(Punkt p0){
         //Falls der Strahl nach rechts geht
         if(this.zwischenp1p2(p0)){return true;}
         else if(this.ist_p1_startPunkt && this.hinterp2(p0)) return true;
         else if (!this.ist_p1_startPunkt && this.vorp1(p0)) return true;
         else return false;
         }
    public boolean equals(Object obj){
         if(obj instanceof Strahl){
             if(this.enthaelt(((Strahl) obj).p1) && this.enthaelt(((Strahl) obj).p2)){
                 if(((Strahl)obj).enthaelt(this.p1) && ((Strahl)obj).enthaelt(this.p2)){
                     if(this.ist_p1_startPunkt == ((Strahl)obj).ist_p1_startPunkt){
                         return true;
                     }
                     else return false;
                 }
                 else return false;
             }
             else return false;
         }
         else return false;
    }



}

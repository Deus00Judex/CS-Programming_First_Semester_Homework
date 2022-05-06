public class Strecke extends Strahl{

    public Strecke(Punkt p1, Punkt p2) {
        super(p1, p2);
    }

    @Override
    public String toString() {
        return "Strecke zwischen den Punken "+this.p1.toString()+" und "+this.p2.toString();
    }
    @Override
    public boolean enthaelt(Punkt p0) {
        return this.zwischenp1p2(p0);
    }
    public boolean equals(Object obj){
        if(obj instanceof Strecke){
            if(this.p1.equals(((Strecke)obj).p1) && this.p2.equals(((Strecke)obj).p2)){
                return true;
            }
            else return false;
        }
        else return false;
    }

    Strahl verlaengern(boolean swap){
        if(swap){return new Strahl(this.p1,this.p2,true);}
        else return new Strahl(this.p1,this.p2,false);
    }




}

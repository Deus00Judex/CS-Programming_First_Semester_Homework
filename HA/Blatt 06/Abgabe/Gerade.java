import java.math.BigDecimal;

//Attribute sind nicht Final!!!!
public class Gerade {
    protected Punkt p1;
    protected Punkt p2;
    private Punkt punktBeiNull;


    /**
     * @param p1 Einer der Punkte, durch den die Gerade geht
     * @param p2 Einer der Punkte, durch den die Gerade geht
     */
    public Gerade(Punkt p1, Punkt p2){
        if(p1.abstand(p2).doubleValue()==0){
            System.out.println("Die Eingabe war leider inkorrekt, da die beiden Punkte gleich sinc");
            this.p2=null;
            this.p1=null;
        }
        if(p2.x_coordinate.doubleValue()<p1.x_coordinate.doubleValue()){
            this.p1=p2;
            this.p2=p1;
        }
        else if(p2.x_coordinate.doubleValue()==p1.x_coordinate.doubleValue()){
            if(p1.y_coordinate.doubleValue()<p2.y_coordinate.doubleValue()){
                this.p1=p1;
                this.p2=p2;
            }
            else{
                this.p1=p2;
                this.p2=p2;
            }
        }
        else{
            this.p1=p1;
            this.p2=p2;
        }
    }

    @Override
    public String toString() {
        return "Gerade durch "+this.p1.toString()+" und "+this.p2.toString();
    }

    protected boolean zwischenp1p2(Punkt p0){
        if(p0.abstand(this.p1).doubleValue()+p0.abstand(this.p2).doubleValue() == this.p1.abstand(p2).doubleValue()){
            return true;
        }
        else return false;
    }
    protected boolean vorp1(Punkt p0){
        if(zwischenp1p2(p0)){return false;}
        if(this.p1.x_coordinate.doubleValue()==this.p2.x_coordinate.doubleValue()){
            if(p0.x_coordinate.doubleValue()==this.p1.x_coordinate.doubleValue()){
                if (p0.y_coordinate.doubleValue()<p1.y_coordinate.doubleValue()){
                    return true;
                }
                else return false;
            }
            else return false;
        }
        else {
            BigDecimal Steigung= this.p2.y_coordinate.subtract(this.p1.y_coordinate).divide(this.p2.x_coordinate.subtract(this.p1.x_coordinate));
            Punkt ursprung=new Punkt(BigDecimal.valueOf(0),this.p1.y_coordinate.subtract(Steigung.multiply(this.p1.x_coordinate)));

            if(BigDecimalUtility.equalValues(p0.abstand(ursprung).add(p0.abstand(this.p1)),ursprung.abstand(this.p1))){
                return true;
            }
            else return false;

        }
    }
    protected boolean hinterp2(Punkt p0) {
        if (this.zwischenp1p2(p0) || this.vorp1(p0)) {
            return false;
        }
        if (this.p1.x_coordinate.doubleValue() == this.p2.x_coordinate.doubleValue()) {
            if (p0.x_coordinate.doubleValue() == this.p1.x_coordinate.doubleValue()) {
                if (p0.y_coordinate.doubleValue() > p1.y_coordinate.doubleValue()) {
                    return true;
                } else return false;
            } else return false;
        }
        else {
            if (BigDecimalUtility.equalValues(p0.abstand(this.p1), this.p1.abstand(this.p2).add(this.p2.abstand(p0)))) {
                return true;
            } else return false;


        }
    }
    public boolean enthaelt(Punkt p0){
            if(zwischenp1p2(p0))        return true;
            else if(vorp1(p0))          return true;
            else if (hinterp2(p0))      return true;
            else                        return false;
        }
    public boolean equals(Object obj){
        if(obj instanceof Gerade){
            if( this.enthaelt(((Gerade)obj).p1) && this.enthaelt(((Gerade)obj).p2)){
                if(((Gerade)obj).enthaelt(this.p1) && ((Gerade)obj).enthaelt(this.p2)){
                    return true;
                }
                else return false;
            }
            else return false;
        }
        else return false;
    }



}

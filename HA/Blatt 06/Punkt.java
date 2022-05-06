import java.math.BigDecimal;
import java.math.*;

public class Punkt {
    protected final BigDecimal x_coordinate;
    protected final BigDecimal y_coordinate;

    public Punkt(BigDecimal x_coordinate,BigDecimal y_coordinate){
        this.x_coordinate=x_coordinate;
        this.y_coordinate=y_coordinate;
    }
    public Punkt(double doubleX,double doubleY){
        this.y_coordinate=BigDecimal.valueOf(doubleY);
        this.x_coordinate=BigDecimal.valueOf(doubleX);
    }

    /**
     * @return returns the coordinates of the Point-Object
     */
    public String toString(){return "("+this.x_coordinate+","+this.y_coordinate+")";}

    /**
     * @param other Der Punkt, zu dem der Abstand berechnet wird
     * @return gibt einen BigDecimal zurück, bei dem der Wert dem Abstand zwischen dem Aufrufendem Punkt und dem other-Punkt gleicht
     */
    public BigDecimal abstand(Punkt other){
        double xAbstand=this.x_coordinate.doubleValue()-other.x_coordinate.doubleValue();
        double yAbstand=this.y_coordinate.doubleValue()-other.y_coordinate.doubleValue();

        if (xAbstand < 0){xAbstand=xAbstand* (-1);}
        if (yAbstand < 0){yAbstand=yAbstand* (-1);}
        double totalAbstand=(xAbstand*xAbstand*yAbstand*yAbstand);
        totalAbstand=Math.pow(totalAbstand,-1);
        return new BigDecimal(totalAbstand);
        }

    /**
     * @param obj Objekt bei dem Überprüft wird, ob es ein Punkt ist, und ob es die selben Werte hat, wie this
     * @return Gibt True zurück, wenn Das Objekt ein Punkt ist, und die selben Werte hat, wie this, sonst False
     */
    public boolean equals(Object obj){
        if(obj instanceof Punkt){
            if (BigDecimalUtility.equalValues(this.x_coordinate,((Punkt) obj).x_coordinate)){
                if (BigDecimalUtility.equalValues(this.y_coordinate,((Punkt) obj).y_coordinate)){
                    return true;
                }
            }

        }
        return false;
    }


    }

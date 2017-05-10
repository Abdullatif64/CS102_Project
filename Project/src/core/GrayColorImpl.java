package core;

import interfaces.Color;
import interfaces.GrayColor;



public class GrayColorImpl implements GrayColor{

    @Override
    public int compareTo(Color o) {
        if(o instanceof GrayColor){
           // GrayColor a=(GrayColor)o;
         return ((int)this.getColor())-((int)((GrayColor)o).getColor());
     }
    return 
            -9999;
    }
    
    private Number color;
    
    public GrayColorImpl(Number color){
        
        setColor(color);
    }
    
    public GrayColorImpl(GrayColor gp){
        this(gp.getColor());
    }

    public Number getColor() {
        return color;
    }

    public void setColor(Number color) {
        
        this.color = color ;
    }
    
    public String toString(){
        return String.format("%d",color);
    }
    
    
 
    
}

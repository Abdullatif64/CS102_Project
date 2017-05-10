package core;

import interfaces.Color;
import interfaces.RGBColor;

public class RGBColorImpl  implements RGBColor {
 
    public Number Red;
    public Number Green;
    public Number Blue;

    @Override
    public int compareTo(Color o) {
        if(o instanceof RGBColor){
            RGBColor a=(RGBColor)o;
      return ((int)this.getBlue()+(int)this.getGreen()+(int)this.getRed())-
              ((int)a.getBlue()+(int)a.getGreen()+(int)a.getRed());
            
     }
         return 
            -9999;
    }

    
    
    
    public RGBColorImpl(Number R, Number G, Number B) {
        this.Red = R;
        this.Green = G;
        this.Blue = B;
    }
    
    public  Number getRed() {
        return Red;
    }

    public void setRed(Number R) {
       
        this.Red = R;
    }

    public Number getGreen() {
        return Green;
    }

    public void setGreen(Number G) {
        
        this.Green = G;
    }

    public Number getBlue() {
        return Blue;
    }

    public void setBlue(Number B) {
        
        this.Blue = B;
    }
    
    public String toString(){
        return String.format("(%d,%d,%d)",Red,Green,Blue);
        
    }

    
}

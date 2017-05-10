package core;

import interfaces.Color;
import interfaces.GrayColor;
import interfaces.Pixel;



public class GrayPixelImpl implements Pixel{

    @Override
    public int compareTo(Pixel o) {
        return this.getColor().compareTo(o.getColor());           
    }
    
    private GrayColor color;
    
    public GrayPixelImpl(Color color){
        super();
        setColor(color);
    }
    
    
    public Color getColor() {
        return new GrayColorImpl(color);
    }

    public void setColor(Color color) {
        if (color instanceof GrayColor)
            this.color = (GrayColor)color;
    }
    
    public String toString(){
        return String.format("%d",color);
    }

   
    
}

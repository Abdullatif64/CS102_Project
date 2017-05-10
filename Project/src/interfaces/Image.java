package interfaces;

public interface Image extends Comparable<Image>{
    public abstract void setName(String h);
 public abstract String getName();
    
public abstract void setHeight(int h);
 public abstract int getHeight();
 
public abstract void setWidth(int w);
 public abstract int getWidth();
 
 public abstract Pixel[][] getImg();
 
 public abstract void randomize();
 
}
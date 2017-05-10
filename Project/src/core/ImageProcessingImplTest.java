package core;


import interfaces.GrayColor;
import interfaces.Image;

public class ImageProcessingImplTest {
    
   public static void desplay(Image a){
        for (int i=0; i<a.getHeight();i++){
           for (int j=0; j<a.getWidth();j++){
               System.out.print(((GrayColor)a.getImg()[i][j].getColor()).getColor()+"\t");
           }
            System.out.println(" ");
        }
    }
    
    public static void main (String [] args){
        
        
        ImageProcessingIMPL v = ImageProcessingIMPL.getInstance() ;
        Image a = new GrayImageImpl(10,10,"histogram");
        a.randomize();
        
        desplay(a);
        System.out.println("Histogram : "+v.Histogram(a));
        
        System.out.printf("\n\n\n");
        
        Image b = new GrayImageImpl(10,10,"thresholding");
        b.randomize();
        System.out.println("image b before thresholding");
        desplay(b);
        v.thresholding(b, 100);
        System.out.println("image b after thresholding");
        desplay(b);
        
        System.out.printf("\n\n\n");
        
        
        Image c = new GrayImageImpl(5,5,"todouble");
        c.randomize();
        System.out.println("image c before toDouble : ");
        desplay(c);
        v.toDouble(c);
        System.out.println("image c after toDouble : ");
        desplay(c);
        
        System.out.printf("\n\n\n");
        
        Image d = new GrayImageImpl(10,10,"matchpattern");
          d.randomize();
        System.out.println("image d ");
        v.thresholding(d, 100);
        desplay(d);
        
        Image subimage = new GrayImageImpl(2,2,"subimage");
        
        subimage.randomize();
        System.out.printf("\n subimage : \n");
        v.thresholding(subimage, 100);
        desplay(subimage);
        System.out.println("Matches = "+v.MatchPattern(subimage, d));
    }
    
}

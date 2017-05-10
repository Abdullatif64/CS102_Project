package core;

import interfaces.GrayColor;
import interfaces.GrayImage;
import interfaces.Image;
import interfaces.ImageProcessing;
import interfaces.RGBImage;
import interfaces.RGBColor;
import java.util.HashMap;
import java.util.Map;


public class ImageProcessingIMPL implements ImageProcessing {
    
     private ImageProcessingIMPL(){};
    
    private static ImageProcessingIMPL instance = null;
    
    public static ImageProcessingIMPL getInstance(){
        if (instance == null)
            instance = new ImageProcessingIMPL();
        return instance;
    }
    
    
    public Image getImage(String color, int w, int h, String n){
        
        if (color.equalsIgnoreCase("gray")){
            return new GrayImageImpl(w,h,n);
        }else if (color.equalsIgnoreCase("rgb")){
            return new RGBImageImpl(w,h,n);
        }
        return null;
    }

   
    @Override
    public Image thresholding(Image image, int thresholdValue) {
        if (image instanceof GrayImage) {
            GrayImage t = (GrayImage) image;
            for (int i = 0; i < image.getHeight(); i++) {
                for (int j = 0; j < image.getWidth(); j++) {
                    if (((int) ((GrayColor) t.getImg()[i][j].getColor()).getColor()) > thresholdValue) {
                        t.getImg()[i][j].setColor(new GrayColorImpl((int) 255));

                    } else {
                        t.getImg()[i][j].setColor(new GrayColorImpl((int) 0));
                    }

                }
            }
            return t;
        }
        return null;
    }

    @Override
    public Image toDouble(Image image) {
        if (image instanceof GrayImage) {
            GrayImage t = (GrayImage) image;
            for (int i = 0; i < image.getHeight(); i++) {
                for (int j = 0; j < image.getWidth(); j++) {
                    t.getImg()[i][j].setColor(new GrayColorImpl(((int) ((GrayColor) t.getImg()[i][j].getColor()).getColor()) / 255.0));

                }

            }
        }//program that draw a diagrame
        else if (image instanceof RGBImage) {
            RGBImageImpl f = (RGBImageImpl) image;
            for (int i = 0; i < image.getHeight(); i++) {
                for (int j = 0; j < image.getWidth(); j++) {
                     f.getImg()[i][j].setColor(new RGBColorImpl((double)((RGBColor) f.getImg()[i][j].getColor()).getRed() / 255.0,
                             (double)((RGBColor) f.getImg()[i][j].getColor()).getGreen() / 255.0,
                             (double)((RGBColor) f.getImg()[i][j].getColor()).getBlue() / 255.0));
                   
                }

            }

        }
        return image;
    }
    
    @Override
    public int MatchPattern(Image subimage, Image image) {
        int tempi, tempj,f=0,k=0;
        int correct = 0;
        int subCount=0;
        int subSize = subimage.getHeight()*subimage.getWidth();
        for (int i = 0; i <= image.getHeight() - subimage.getHeight(); i++) {
            for (int j = 0; j <= image.getWidth() - subimage.getWidth(); j++) {
                if ((int) ((GrayColor) subimage.getImg()[0][0].getColor()).getColor() == (int) ((GrayColor) image.getImg()[i][j].getColor()).getColor()) {
                    tempi = i;
                    for (f = 0; f < subimage.getHeight(); f++) {
                        tempj = j;
                        for (k = 0; k < subimage.getWidth(); k++) {
                          if ((int) ((GrayColor) subimage.getImg()[f][k].getColor()).getColor() == (int) ((GrayColor) image.getImg()[tempi][tempj].getColor()).getColor()){
                              correct++;
                              
                          }
                           tempj++;
                        }
                       tempi++;
                    }
                    f=0;
                    k=0;
                }
                if (correct == subSize){
                    subCount++;
                }
               correct=0;
            }
        }
        return subCount;
    }
    
   
    
    

    @Override
    public Map<Integer, Integer> Histogram(Image image) {
       Map<Integer, Integer> colorMap = new HashMap<Integer, Integer>();
        int count;
        if (image instanceof GrayImage) {
            for (int i = 0; i < image.getHeight(); i++) {
                for (int j = 0; j < image.getWidth(); j++) {
                    if (!colorMap.containsKey(((int) ((GrayColor) (image.getImg()[i][j].getColor())).getColor()))) {
                        colorMap.put(((int) ((GrayColor) (image.getImg()[i][j].getColor())).getColor()), 1);
                    } else {
                        count = colorMap.get(((int) ((GrayColor) (image.getImg()[i][j].getColor())).getColor()));
                        colorMap.put(((int) ((GrayColor) (image.getImg()[i][j].getColor())).getColor()), count + 1);
                    }
                }
            }
        }
        return colorMap;}
    
}


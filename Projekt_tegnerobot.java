/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt_tegnerobot;

import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author euc
 */
public class Projekt_tegnerobot {
    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException
    {
        int width = 276; // here is the size of the image defined
        int height = 183;
        BufferedImage image = null;
        File s = null;
        //below is reading the image part
    try {
        s = new File("C:\\projects\\Sø.jpg");// image file
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        image = ImageIO.read(s);
        } catch(IOException e) 
        {
            System.out.println("Error: "+e);
        }
    //below is the writing path of the image
    try {
        s = new File("C:\\projects\\Sø.jpg");
        ImageIO.write(image, "jpg", s);
        System.out.println("File writing completed ");
        } catch(IOException e)
        {
            System.out.println("Error: "+e);
        }
    //https://www.youtube.com/watch?v=lGX0Gc6d51s 
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package billedepixels_prototype;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.Raster;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashSet;
import javax.imageio.ImageIO;
/**
 *
 * @author euc
 */
public class BilledePixels_prototype {
    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */ 
    public static void main(String[] args) throws IOException {
        BufferedImage binary = null; //her bliver billedet indlæst
        try {
            BufferedImage img = ImageIO.read(new File("C:\\Users\\euc\\Pictures\\Trekanter.jpg"));
            binary = new BufferedImage(img.getWidth(), img.getHeight(),
                    BufferedImage.TYPE_BYTE_BINARY);
            Graphics2D g = binary.createGraphics();
            g.drawImage(img, 0, 0, null);
            HashSet<Integer> colors = new HashSet<>();
            int color = 0;
            for (int y = 0; y < binary.getHeight(); y++) {
                for (int x = 0; x < binary.getWidth(); x++) {
                    color = binary.getRGB(x, y);
                    
                    if (color == -1) {
                        binary.setRGB(x, y, -1);
                    } else {
                        binary.setRGB(x, y, -16777216);
                    }
                    //System.out.println(color);
                    colors.add(color);
                }
            }
            System.out.println(colors.size());
        } catch (IOException e) {
        }
        try {//her oprettes der et nyt billede som er behandlet i sort og hvidt
            File s = new File("C:\\Users\\euc\\Pictures\\new picture.jpg");
            ImageIO.write(binary, "jpg", s);
            System.out.println("File writing completed ");
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
        File input = new File("C:\\Users\\euc\\Pictures\\new picture.jpg");
        BufferedImage image = ImageIO.read(input);
        BufferedImage resized = resize(image, 50, 100);//ændre størrelsen på billedet
        File output = new File("C:\\Users\\euc\\Pictures\\new picture.jpg");
        ImageIO.write(resized, "jpg", output);
        int[][] compute = compute(output);//her bliver pixelværdierne for billedet skrevet ind til en tekstfil
        try {
            System.out.println("connection test");    
            RobotClient R1 = new RobotClient("192.161.1.15", 11159);
            R1.connect();
            int i = 0;
            if(R1.isConnected())
            {
                
                    R1.write("x 41 y 02 x 42 y 02 x 43 y 02 x 44 y 02 x 45 y 02 x 46 y 02 x 47 y 02 x 48 y 02 x 49 y 02 x 10 y 03 x 11 y 03 x 12 y 03 x 13 y 03 x 14 y 03 x 15 y 03 x 16 y 03 x 17 y 03 x 18 y 03 x 42 y 03 x 43 y 03 x 44 y 03 x 45 y 03 x 46 y 03 x 47 y 03 x 48 y 03 x 06 y 04 x 07 y 04 x 08 y 04 x 09 y 04 x 10 y 04 x 11 y 04 x 12 y 04 x 13 y 04 x 14 y 04 x 15 y 04 x 16 y 04 x 17 y 04 x 18 y 04 x 43 y 04 x 44 y 04 x 45 y 04 x 46 y 04 x 47 y 04 x 48 y 04 x 93 y 04 x 07 y 05 x 08 y 05 x 09 y 05 x 10 y 05 x 11 y 05 x 12 y 05 x 13 y 05 x 14 y 05 x 15 y 05 x 16 y 05 x 17 y 05 x 18 y 05 x 43 y 05 x 44 y 05 x 45 y 05 x 46 y 05 x 47 y 05 x 92 y 05 x 93 y 05 x 94 y 05 x 08 y 06 x 09 y 06 x 10 y 06 x 11 y 06 x 12 y 06 x 13 y 06 x 14 y 06 x 15 y 06 x 16 y 06 x 17 y 06 x 18 y 06 x 44 y 06 x 45 y 06 x 46 y 06 x 50 y 06 x 51 y 06 x 91 y 06 x 92 y 06 x 93 y 06 x 94 y 06 x 09 y 07 x 10 y 07 x 11 y 07 x 12 y 07 x 13 y 07 x 14 y 07 x 15 y 07 x 16 y 07 x 17 y 07 x 18 y 07 x 29 y 07 x 45 y 07 x 46 y 07 x 49 y 07 x 50 y 07 x 51 y 07 x 52 y 07 x 90 y 07 x 91 y 07 x 92 y 07 x 93 y 07 x 94 y 07 x 95 y 07 x 09 y 08 x 10 y 08 x 11 y 08 x 12 y 08 x 13 y 08 x 14 y 08 x 15 y 08 x 16 y 08 x 17 y 08 x 18 y 08 x 28 y 08 x 29 y 08 x 30 y 08 x 48 y 08 x 49 y 08 x 50 y 08 x 51 y 08 x 52 y 08 x 72 y 08 x 73 y 08 x 74 y 08 x 75 y 08 x 76 y 08 x 90 y 08 x 91 y 08 x 92 y 08 x 93 y 08 x 94 y 08 x 95 y 08 x 10 y 09 x 11 y 09 x 12 y 09 x 13 y 09 x 14 y 09 x 15 y 09 x 16 y 09 x 17 y 09 x 28 y 09 x 29 y 09 x 30 y 09 x 48 y 09 x 49 y 09 x 50 y 09 x 51 y 09 x 52 y 09 x 53 y 09 x 66 y 09 x 67 y 09 x 68 y 09 x 69 y 09 x 70 y 09 x 71 y 09 x 72 y 09 x 73 y 09 x 74 y 09 x 75 y 09 x 76 y 09 x 77 y 09 x 89 y 09 x 90 y 09 x 91 y 09 x 92 y 09 x 93 y 09 x 94 y 09 x 95 y 09 x 11 y 10 x 12 y 10 x 13 y 10 x 14 y 10 x 15 y 10 x 16 y 10 x 17 y 10 x 27 y 10 x 28 y 10 x 29 y 10 x 30 y 10 x 31 y 10 x 47 y 10 x 48 y 10 x 49 y 10 x 50 y 10 x 51 y 10 x 52 y 10 x 53 y 10 x 54 y 10 x 59 y 10 x 60 y 10 x 61 y 10 x 62 y 10 x 63 y 10 x 64 y 10 x 65 y 10 x 66 y 10 x 67 y 10 x 68 y 10 x 69 y 10 x 70 y 10 x 71 y 10 x 72 y 10 x 73 y 10 x 74 y 10 x 75 y 10 x 76 y 10 x 77 y 10 x 88 y 10 x 89 y 10 x 90 y 10 x 91 y 10 x 92 y 10 x 93 y 10 x 94 y 10 x 95 y 10 x 96 y 10 x 12 y 11 x 13 y 11 x 14 y 11 x 15 y 11 x 16 y 11 x 17 y 11 x 26 y 11 x 27 y 11 x 28 y 11 x 29 y 11 x 30 y 11 x 31 y 11 x 32 y 11 x 46 y 11 x 47 y 11 x 48 y 11 x 49 y 11 x 50 y 11 x 51 y 11 x 52 y 11 x 53 y 11 x 54 y 11 x 55 y 11 x 59 y 11 x 60 y 11 x 61 y 11 x 62 y 11 x 63 y 11 x 64 y 11 x 65 y 11 x 66 y 11 x 67 y 11 x 68 y 11 x 69 y 11 x 70 y 11 x 71 y 11 x 72 y 11 x 73 y 11 x 74 y 11 x 75 y 11 x 76 y 11 x 77 y 11 x 78 y 11 x 87 y 11 x 88 y 11 x 89 y 11 x 90 y 11 x 91 y 11 x 92 y 11 x 93 y 11 x 94 y 11 x 95 y 11 x 96 y 11 x 12 y 12 x 13 y 12 x 14 y 12 x 15 y 12 x 16 y 12 x 17 y 12 x 26 y 12 x 27 y 12 x 28 y 12 x 29 y 12 x 30 y 12 x 31 y 12 x 32 y 12 x 45 y 12 x 46 y 12 x 47 y 12 x 48 y 12 x 49 y 12 x 50 y 12 x 51 y 12 x 52 y 12 x 53 y 12 x 54 y 12 x 55 y 12 x 60 y 12 x 61 y 12 x 62 y 12 x 63 y 12 x 64 y 12 x 65 y 12 x 66 y 12 x 67 y 12 x 68 y 12 x 69 y 12 x 70 y 12 x 71 y 12 x 72 y 12 x 73 y 12 x 74 y 12 x 75 y 12 x 76 y 12 x 77 y 12 x 78 y 12 x 86 y 12 x 87 y 12 x 88 y 12 x 89 y 12 x 90 y 12 x 91 y 12 x 92 y 12 x 93 y 12 x 94 y 12 x 95 y 12 x 96 y 12 x 97 y 12 x 13 y 13 x 14 y 13 x 15 y 13 x 16 y 13 x 17 y 13 x 25 y 13 x 26 y 13 x 27 y 13 x 28 y 13 x 29 y 13 x 30 y 13 x 31 y 13 x 32 y 13 x 33 y 13 x 45 y 13 x 46 y 13 x 47 y 13 x 48 y 13 x 49 y 13 x 50 y 13 x 51 y 13 x 52 y 13 x 53 y 13 x 54 y 13 x 55 y 13 x 56 y 13 x 62 y 13 x 63 y 13 x 64 y 13 x 65 y 13 x 66 y 13 x 67 y 13 x 68 y 13 x 69 y 13 x 70 y 13 x 71 y 13 x 72 y 13 x 73 y 13 x 74 y 13 x 75 y 13 x 76 y 13 x 77 y 13 x 78 y 13 x 85 y 13 x 86 y 13 x 87 y 13 x 88 y 13 x 89 y 13 x 90 y 13 x 91 y 13 x 92 y 13 x 93 y 13 x 94 y 13 x 95 y 13 x 96 y 13 x 97 y 13 x 14 y 14 x 15 y 14 x 16 y 14 x 17 y 14 x 25 y 14 x 26 y 14 x 27 y 14 x 28 y 14 x 29 y 14 x 30 y 14 x 31 y 14 x 32 y 14 x 33 y 14 x 34 y 14 x 44 y 14 x 45 y 14 x 46 y 14 x 47 y 14 x 48 y 14 x 49 y 14 x 50 y 14 x 51 y 14 x 52 y 14 x 53 y 14 x 54 y 14 x 55 y 14 x 56 y 14 x 57 y 14 x 64 y 14 x 65 y 14 x 66 y 14 x 67 y 14 x 68 y 14 x 69 y 14 x 70 y 14 x 71 y 14 x 72 y 14 x 73 y 14 x 74 y 14 x 75 y 14 x 76 y 14 x 77 y 14 x 78 y 14 x 84 y 14 x 85 y 14 x 86 y 14 x 87 y 14 x 88 y 14 x 89 y 14 x 90 y 14 x 91 y 14 x 92 y 14 x 93 y 14 x 94 y 14 x 95 y 14 x 96 y 14 x 97 y 14 x 15 y 15 x 16 y 15 x 24 y 15 x 25 y 15 x 26 y 15 x 27 y 15 x 28 y 15 x 29 y 15 x 30 y 15 x 31 y 15 x 32 y 15 x 33 y 15 x 34 y 15 x 43 y 15 x 44 y 15 x 45 y 15 x 46 y 15 x 47 y 15 x 48 y 15 x 49 y 15 x 50 y 15 x 51 y 15 x 52 y 15 x 53 y 15 x 54 y 15 x 55 y 15 x 56 y 15 x 57 y 15 x 65 y 15 x 66 y 15 x 67 y 15 x 68 y 15 x 69 y 15 x 70 y 15 x 71 y 15 x 72 y 15 x 73 y 15 x 74 y 15 x 75 y 15 x 76 y 15 x 77 y 15 x 78 y 15 x 15 y 16 x 16 y 16 x 23 y 16 x 24 y 16 x 25 y 16 x 26 y 16 x 27 y 16 x 28 y 16 x 29 y 16 x 30 y 16 x 31 y 16 x 32 y 16 x 33 y 16 x 34 y 16 x 35 y 16 x 42 y 16 x 43 y 16 x 44 y 16 x 45 y 16 x 46 y 16 x 47 y 16 x 48 y 16 x 49 y 16 x 50 y 16 x 51 y 16 x 52 y 16 x 53 y 16 x 54 y 16 x 55 y 16 x 56 y 16 x 57 y 16 x 58 y 16 x 66 y 16 x 67 y 16 x 68 y 16 x 69 y 16 x 70 y 16 x 71 y 16 x 72 y 16 x 73 y 16 x 74 y 16 x 75 y 16 x 76 y 16 x 77 y 16 x 78 y 16 x 16 y 17 x 23 y 17 x 24 y 17 x 25 y 17 x 26 y 17 x 27 y 17 x 28 y 17 x 29 y 17 x 30 y 17 x 31 y 17 x 32 y 17 x 33 y 17 x 34 y 17 x 35 y 17 x 36 y 17 x 41 y 17 x 42 y 17 x 43 y 17 x 44 y 17 x 45 y 17 x 46 y 17 x 47 y 17 x 48 y 17 x 49 y 17 x 50 y 17 x 51 y 17 x 52 y 17 x 53 y 17 x 54 y 17 x 55 y 17 x 64 y 17 x 65 y 17 x 66 y 17 x 67 y 17 x 68 y 17 x 69 y 17 x 70 y 17 x 71 y 17 x 72 y 17 x 73 y 17 x 74 y 17 x 75 y 17 x 76 y 17 x 77 y 17 x 78 y 17 x 22 y 18 x 23 y 18 x 24 y 18 x 25 y 18 x 26 y 18 x 27 y 18 x 28 y 18 x 29 y 18 x 30 y 18 x 31 y 18 x 32 y 18 x 33 y 18 x 34 y 18 x 35 y 18 x 36 y 18 x 37 y 18 x 41 y 18 x 42 y 18 x 43 y 18 x 44 y 18 x 45 y 18 x 46 y 18 x 47 y 18 x 48 y 18 x 49 y 18 x 50 y 18 x 51 y 18 x 61 y 18 x 62 y 18 x 63 y 18 x 64 y 18 x 65 y 18 x 66 y 18 x 67 y 18 x 68 y 18 x 69 y 18 x 70 y 18 x 71 y 18 x 72 y 18 x 73 y 18 x 74 y 18 x 75 y 18 x 76 y 18 x 77 y 18 x 78 y 18 x 05 y 19 x 06 y 19 x 21 y 19 x 22 y 19 x 23 y 19 x 24 y 19 x 25 y 19 x 26 y 19 x 27 y 19 x 28 y 19 x 29 y 19 x 30 y 19 x 31 y 19 x 32 y 19 x 33 y 19 x 34 y 19 x 35 y 19 x 36 y 19 x 37 y 19 x 40 y 19 x 41 y 19 x 42 y 19 x 43 y 19 x 44 y 19 x 45 y 19 x 46 y 19 x 47 y 19 x 58 y 19 x 59 y 19 x 60 y 19 x 61 y 19 x 62 y 19 x 63 y 19 x 64 y 19 x 65 y 19 x 66 y 19 x 67 y 19 x 68 y 19 x 69 y 19 x 72 y 19 x 73 y 19 x 74 y 19 x 75 y 19 x 76 y 19 x 77 y 19 x 78 y 19 x 05 y 20 x 06 y 20 x 07 y 20 x 08 y 20 x 09 y 20 x 10 y 20 x 21 y 20 x 22 y 20 x 23 y 20 x 24 y 20 x 25 y 20 x 26 y 20 x 27 y 20 x 28 y 20 x 29 y 20 x 30 y 20 x 31 y 20 x 32 y 20 x 33 y 20 x 34 y 20 x 35 y 20 x 36 y 20 x 37 y 20 x 38 y 20 x 39 y 20 x 40 y 20 x 41 y 20 x 42 y 20 x 43 y 20 x 56 y 20 x 57 y 20 x 58 y 20 x 59 y 20 x 60 y 20 x 61 y 20 x 62 y 20 x 63 y 20 x 64 y 20 x 65 y 20 x 66 y 20 x 67 y 20 x 68 y 20 x 69 y 20 x 74 y 20 x 75 y 20 x 76 y 20 x 77 y 20 x 78 y 20 x 05 y 21 x 06 y 21 x 07 y 21 x 08 y 21 x 09 y 21 x 10 y 21 x 11 y 21 x 12 y 21 x 13 y 21 x 14 y 21 x 20 y 21 x 21 y 21 x 22 y 21 x 23 y 21 x 24 y 21 x 25 y 21 x 26 y 21 x 27 y 21 x 28 y 21 x 29 y 21 x 30 y 21 x 31 y 21 x 32 y 21 x 33 y 21 x 34 y 21 x 35 y 21 x 36 y 21 x 37 y 21 x 38 y 21 x 39 y 21 x 53 y 21 x 54 y 21 x 55 y 21 x 56 y 21 x 57 y 21 x 58 y 21 x 59 y 21 x 60 y 21 x 61 y 21 x 62 y 21 x 63 y 21 x 64 y 21 x 65 y 21 x 66 y 21 x 67 y 21 x 68 y 21 x 75 y 21 x 76 y 21 x 77 y 21 x 78 y 21 x 05 y 22 x 06 y 22 x 07 y 22 x 08 y 22 x 09 y 22 x 10 y 22 x 11 y 22 x 12 y 22 x 13 y 22 x 14 y 22 x 15 y 22 x 16 y 22 x 17 y 22 x 18 y 22 x 19 y 22 x 20 y 22 x 21 y 22 x 22 y 22 x 23 y 22 x 24 y 22 x 25 y 22 x 26 y 22 x 27 y 22 x 28 y 22 x 29 y 22 x 30 y 22 x 31 y 22 x 32 y 22 x 33 y 22 x 34 y 22 x 35 y 22 x 36 y 22 x 37 y 22 x 38 y 22 x 39 y 22 x 54 y 22 x 55 y 22 x 56 y 22 x 57 y 22 x 58 y 22 x 59 y 22 x 60 y 22 x 61 y 22 x 62 y 22 x 63 y 22 x 64 y 22 x 65 y 22 x 66 y 22 x 67 y 22 x 68 y 22 x 77 y 22 x 78 y 22 x 94 y 22 x 95 y 22 x 05 y 23 x 06 y 23 x 07 y 23 x 08 y 23 x 09 y 23 x 10 y 23 x 11 y 23 x 12 y 23 x 13 y 23 x 14 y 23 x 15 y 23 x 16 y 23 x 17 y 23 x 18 y 23 x 19 y 23 x 20 y 23 x 21 y 23 x 22 y 23 x 23 y 23 x 24 y 23 x 25 y 23 x 26 y 23 x 27 y 23 x 28 y 23 x 29 y 23 x 30 y 23 x 31 y 23 x 32 y 23 x 33 y 23 x 34 y 23 x 35 y 23 x 36 y 23 x 37 y 23 x 38 y 23 x 39 y 23 x 40 y 23 x 55 y 23 x 56 y 23 x 57 y 23 x 58 y 23 x 59 y 23 x 60 y 23 x 61 y 23 x 62 y 23 x 63 y 23 x 64 y 23 x 65 y 23 x 66 y 23 x 67 y 23 x 68 y 23 x 93 y 23 x 94 y 23 x 95 y 23 x 05 y 24 x 06 y 24 x 07 y 24 x 08 y 24 x 09 y 24 x 10 y 24 x 11 y 24 x 12 y 24 x 13 y 24 x 14 y 24 x 15 y 24 x 16 y 24 x 17 y 24 x 18 y 24 x 19 y 24 x 20 y 24 x 21 y 24 x 22 y 24 x 23 y 24 x 24 y 24 x 25 y 24 x 26 y 24 x 27 y 24 x 28 y 24 x 29 y 24 x 30 y 24 x 31 y 24 x 32 y 24 x 33 y 24 x 34 y 24 x 35 y 24 x 36 y 24 x 37 y 24 x 38 y 24 x 39 y 24 x 40 y 24 x 41 y 24 x 56 y 24 x 57 y 24 x 58 y 24 x 59 y 24 x 60 y 24 x 61 y 24 x 62 y 24 x 63 y 24 x 64 y 24 x 65 y 24 x 66 y 24 x 67 y 24 x 92 y 24 x 93 y 24 x 94 y 24 x 95 y 24 x 05 y 25 x 06 y 25 x 07 y 25 x 08 y 25 x 09 y 25 x 10 y 25 x 11 y 25 x 12 y 25 x 13 y 25 x 14 y 25 x 15 y 25 x 16 y 25 x 17 y 25 x 18 y 25 x 19 y 25 x 20 y 25 x 21 y 25 x 22 y 25 x 23 y 25 x 24 y 25 x 25 y 25 x 26 y 25 x 27 y 25 x 28 y 25 x 29 y 25 x 30 y 25 x 31 y 25 x 32 y 25 x 33 y 25 x 34 y 25 x 35 y 25 x 36 y 25 x 37 y 25 x 38 y 25 x 39 y 25 x 40 y 25 x 41 y 25 x 57 y 25 x 58 y 25 x 59 y 25 x 60 y 25 x 61 y 25 x 62 y 25 x 63 y 25 x 64 y 25 x 65 y 25 x 66 y 25 x 67 y 25 x 90 y 25 x 91 y 25 x 92 y 25 x 93 y 25 x 94 y 25 x 95 y 25 x 05 y 26 x 06 y 26 x 07 y 26 x 08 y 26 x 09 y 26 x 10 y 26 x 11 y 26 x 12 y 26 x 13 y 26 x 14 y 26 x 15 y 26 x 16 y 26 x 17 y 26 x 18 y 26 x 19 y 26 x 20 y 26 x 21 y 26 x 22 y 26 x 23 y 26 x 24 y 26 x 25 y 26 x 26 y 26 x 27 y 26 x 28 y 26 x 29 y 26 x 30 y 26 x 31 y 26 x 32 y 26 x 33 y 26 x 34 y 26 x 35 y 26 x 36 y 26 x 37 y 26 x 38 y 26 x 39 y 26 x 40 y 26 x 41 y 26 x 42 y 26 x 58 y 26 x 59 y 26 x 60 y 26 x 61 y 26 x 62 y 26 x 63 y 26 x 64 y 26 x 65 y 26 x 66 y 26 x 67 y 26 x 89 y 26 x 90 y 26 x 91 y 26 x 92 y 26 x 93 y 26 x 94 y 26 x 95 y 26 x 05 y 27 x 06 y 27 x 07 y 27 x 08 y 27 x 09 y 27 x 10 y 27 x 11 y 27 x 12 y 27 x 13 y 27 x 14 y 27 x 15 y 27 x 16 y 27 x 17 y 27 x 18 y 27 x 19 y 27 x 20 y 27 x 21 y 27 x 22 y 27 x 23 y 27 x 24 y 27 x 25 y 27 x 26 y 27 x 27 y 27 x 28 y 27 x 29 y 27 x 30 y 27 x 31 y 27 x 32 y 27 x 33 y 27 x 34 y 27 x 35 y 27 x 36 y 27 x 37 y 27 x 38 y 27 x 39 y 27 x 40 y 27 x 41 y 27 x 42 y 27 x 43 y 27 x 60 y 27 x 61 y 27 x 62 y 27 x 63 y 27 x 64 y 27 x 65 y 27 x 66 y 27 x 87 y 27 x 88 y 27 x 89 y 27 x 90 y 27 x 91 y 27 x 92 y 27 x 93 y 27 x 94 y 27 x 95 y 27 x 04 y 28 x 05 y 28 x 06 y 28 x 07 y 28 x 08 y 28 x 09 y 28 x 10 y 28 x 11 y 28 x 12 y 28 x 13 y 28 x 14 y 28 x 15 y 28 x 16 y 28 x 17 y 28 x 18 y 28 x 19 y 28 x 20 y 28 x 21 y 28 x 22 y 28 x 23 y 28 x 24 y 28 x 25 y 28 x 26 y 28 x 27 y 28 x 28 y 28 x 29 y 28 x 30 y 28 x 31 y 28 x 32 y 28 x 33 y 28 x 34 y 28 x 35 y 28 x 36 y 28 x 37 y 28 x 38 y 28 x 39 y 28 x 40 y 28 x 41 y 28 x 42 y 28 x 43 y 28 x 61 y 28 x 62 y 28 x 63 y 28 x 64 y 28 x 65 y 28 x 66 y 28 x 86 y 28 x 87 y 28 x 88 y 28 x 89 y 28 x 90 y 28 x 91 y 28 x 92 y 28 x 93 y 28 x 94 y 28 x 95 y 28 x 04 y 29 x 05 y 29 x 06 y 29 x 07 y 29 x 08 y 29 x 09 y 29 x 10 y 29 x 11 y 29 x 12 y 29 x 13 y 29 x 21 y 29 x 22 y 29 x 33 y 29 x 34 y 29 x 35 y 29 x 36 y 29 x 37 y 29 x 38 y 29 x 39 y 29 x 40 y 29 x 41 y 29 x 42 y 29 x 43 y 29 x 44 y 29 x 62 y 29 x 63 y 29 x 64 y 29 x 65 y 29 x 66 y 29 x 85 y 29 x 86 y 29 x 87 y 29 x 88 y 29 x 89 y 29 x 90 y 29 x 91 y 29 x 92 y 29 x 93 y 29 x 94 y 29 x 95 y 29 x 04 y 30 x 05 y 30 x 06 y 30 x 07 y 30 x 08 y 30 x 09 y 30 x 10 y 30 x 11 y 30 x 20 y 30 x 21 y 30 x 22 y 30 x 23 y 30 x 63 y 30 x 64 y 30 x 65 y 30 x 83 y 30 x 84 y 30 x 85 y 30 x 86 y 30 x 87 y 30 x 88 y 30 x 89 y 30 x 90 y 30 x 91 y 30 x 92 y 30 x 93 y 30 x 94 y 30 x 95 y 30 x 04 y 31 x 05 y 31 x 06 y 31 x 07 y 31 x 08 y 31 x 09 y 31 x 19 y 31 x 20 y 31 x 21 y 31 x 22 y 31 x 23 y 31 x 64 y 31 x 65 y 31 x 71 y 31 x 83 y 31 x 84 y 31 x 85 y 31 x 86 y 31 x 87 y 31 x 88 y 31 x 89 y 31 x 90 y 31 x 91 y 31 x 92 y 31 x 93 y 31 x 94 y 31 x 95 y 31 x 04 y 32 x 05 y 32 x 06 y 32 x 07 y 32 x 18 y 32 x 19 y 32 x 20 y 32 x 21 y 32 x 22 y 32 x 23 y 32 x 24 y 32 x 70 y 32 x 71 y 32 x 72 y 32 x 86 y 32 x 87 y 32 x 88 y 32 x 89 y 32 x 90 y 32 x 91 y 32 x 92 y 32 x 93 y 32 x 94 y 32 x 95 y 32 x 96 y 32 x 04 y 33 x 05 y 33 x 17 y 33 x 18 y 33 x 19 y 33 x 20 y 33 x 21 y 33 x 22 y 33 x 23 y 33 x 24 y 33 x 48 y 33 x 49 y 33 x 50 y 33 x 51 y 33 x 52 y 33 x 53 y 33 x 54 y 33 x 55 y 33 x 56 y 33 x 70 y 33 x 71 y 33 x 72 y 33 x 89 y 33 x 90 y 33 x 91 y 33 x 92 y 33 x 93 y 33 x 94 y 33 x 95 y 33 x 96 y 33 x 16 y 34 x 17 y 34 x 18 y 34 x 19 y 34 x 20 y 34 x 21 y 34 x 22 y 34 x 23 y 34 x 24 y 34 x 25 y 34 x 35 y 34 x 36 y 34 x 37 y 34 x 38 y 34 x 39 y 34 x 40 y 34 x 41 y 34 x 42 y 34 x 43 y 34 x 44 y 34 x 45 y 34 x 46 y 34 x 47 y 34 x 48 y 34 x 49 y 34 x 50 y 34 x 51 y 34 x 52 y 34 x 53 y 34 x 54 y 34 x 55 y 34 x 70 y 34 x 71 y 34 x 72 y 34 x 73 y 34 x 91 y 34 x 92 y 34 x 93 y 34 x 94 y 34 x 95 y 34 x 96 y 34 x 15 y 35 x 16 y 35 x 17 y 35 x 18 y 35 x 19 y 35 x 20 y 35 x 21 y 35 x 22 y 35 x 23 y 35 x 24 y 35 x 25 y 35 x 33 y 35 x 34 y 35 x 35 y 35 x 36 y 35 x 37 y 35 x 38 y 35 x 39 y 35 x 40 y 35 x 41 y 35 x 42 y 35 x 43 y 35 x 44 y 35 x 45 y 35 x 46 y 35 x 47 y 35 x 48 y 35 x 49 y 35 x 50 y 35 x 51 y 35 x 52 y 35 x 53 y 35 x 54 y 35 x 70 y 35 x 71 y 35 x 72 y 35 x 73 y 35 x 74 y 35 x 94 y 35 x 95 y 35 x 96 y 35 x 14 y 36 x 15 y 36 x 16 y 36 x 17 y 36 x 18 y 36 x 19 y 36 x 20 y 36 x 21 y 36 x 22 y 36 x 23 y 36 x 24 y 36 x 25 y 36 x 26 y 36 x 35 y 36 x 36 y 36 x 37 y 36 x 38 y 36 x 39 y 36 x 40 y 36 x 41 y 36 x 42 y 36 x 43 y 36 x 44 y 36 x 45 y 36 x 46 y 36 x 47 y 36 x 48 y 36 x 49 y 36 x 50 y 36 x 69 y 36 x 70 y 36 x 71 y 36 x 72 y 36 x 73 y 36 x 74 y 36 x 75 y 36 x 14 y 37 x 15 y 37 x 16 y 37 x 17 y 37 x 18 y 37 x 19 y 37 x 20 y 37 x 21 y 37 x 22 y 37 x 23 y 37 x 24 y 37 x 25 y 37 x 26 y 37 x 31 y 37 x 32 y 37 x 33 y 37 x 37 y 37 x 38 y 37 x 39 y 37 x 40 y 37 x 41 y 37 x 42 y 37 x 43 y 37 x 44 y 37 x 45 y 37 x 46 y 37 x 47 y 37 x 48 y 37 x 49 y 37 x 50 y 37 x 51 y 37 x 52 y 37 x 68 y 37 x 69 y 37 x 70 y 37 x 71 y 37 x 72 y 37 x 73 y 37 x 74 y 37 x 75 y 37 x 76 y 37 x 13 y 38 x 14 y 38 x 15 y 38 x 16 y 38 x 17 y 38 x 18 y 38 x 19 y 38 x 20 y 38 x 21 y 38 x 22 y 38 x 23 y 38 x 24 y 38 x 25 y 38 x 26 y 38 x 27 y 38 x 31 y 38 x 32 y 38 x 33 y 38 x 34 y 38 x 39 y 38 x 40 y 38 x 41 y 38 x 42 y 38 x 43 y 38 x 44 y 38 x 45 y 38 x 46 y 38 x 47 y 38 x 48 y 38 x 49 y 38 x 50 y 38 x 51 y 38 x 68 y 38 x 69 y 38 x 70 y 38 x 71 y 38 x 72 y 38 x 73 y 38 x 74 y 38 x 75 y 38 x 76 y 38 x 12 y 39 x 13 y 39 x 14 y 39 x 15 y 39 x 16 y 39 x 17 y 39 x 18 y 39 x 19 y 39 x 20 y 39 x 21 y 39 x 22 y 39 x 23 y 39 x 24 y 39 x 25 y 39 x 26 y 39 x 27 y 39 x 30 y 39 x 31 y 39 x 32 y 39 x 33 y 39 x 34 y 39 x 35 y 39 x 41 y 39 x 42 y 39 x 43 y 39 x 44 y 39 x 45 y 39 x 46 y 39 x 47 y 39 x 48 y 39 x 49 y 39 x 50 y 39 x 67 y 39 x 68 y 39 x 69 y 39 x 70 y 39 x 71 y 39 x 72 y 39 x 73 y 39 x 74 y 39 x 75 y 39 x 76 y 39 x 77 y 39 x 11 y 40 x 12 y 40 x 13 y 40 x 14 y 40 x 15 y 40 x 16 y 40 x 17 y 40 x 18 y 40 x 19 y 40 x 20 y 40 x 21 y 40 x 22 y 40 x 23 y 40 x 24 y 40 x 25 y 40 x 26 y 40 x 27 y 40 x 28 y 40 x 29 y 40 x 30 y 40 x 31 y 40 x 32 y 40 x 33 y 40 x 34 y 40 x 35 y 40 x 36 y 40 x 43 y 40 x 44 y 40 x 45 y 40 x 46 y 40 x 47 y 40 x 48 y 40 x 49 y 40 x 66 y 40 x 67 y 40 x 68 y 40 x 69 y 40 x 70 y 40 x 71 y 40 x 72 y 40 x 73 y 40 x 74 y 40 x 75 y 40 x 76 y 40 x 77 y 40 x 78 y 40 x 79 y 40 x 10 y 41 x 11 y 41 x 12 y 41 x 13 y 41 x 14 y 41 x 15 y 41 x 16 y 41 x 17 y 41 x 18 y 41 x 19 y 41 x 20 y 41 x 21 y 41 x 22 y 41 x 23 y 41 x 24 y 41 x 25 y 41 x 26 y 41 x 27 y 41 x 28 y 41 x 29 y 41 x 30 y 41 x 31 y 41 x 32 y 41 x 33 y 41 x 34 y 41 x 35 y 41 x 36 y 41 x 37 y 41 x 45 y 41 x 46 y 41 x 47 y 41 x 48 y 41 x 66 y 41 x 67 y 41 x 68 y 41 x 69 y 41 x 70 y 41 x 71 y 41 x 72 y 41 x 73 y 41 x 74 y 41 x 75 y 41 x 76 y 41 x 77 y 41 x 78 y 41 x 79 y 41 x 80 y 41 x 11 y 42 x 12 y 42 x 13 y 42 x 14 y 42 x 15 y 42 x 16 y 42 x 17 y 42 x 18 y 42 x 19 y 42 x 20 y 42 x 21 y 42 x 22 y 42 x 23 y 42 x 24 y 42 x 25 y 42 x 26 y 42 x 27 y 42 x 28 y 42 x 29 y 42 x 30 y 42 x 31 y 42 x 32 y 42 x 33 y 42 x 34 y 42 x 35 y 42 x 36 y 42 x 37 y 42 x 38 y 42 x 47 y 42 x 63 y 42 x 64 y 42 x 65 y 42 x 66 y 42 x 67 y 42 x 68 y 42 x 69 y 42 x 70 y 42 x 71 y 42 x 72 y 42 x 73 y 42 x 74 y 42 x 75 y 42 x 76 y 42 x 77 y 42 x 78 y 42 x 79 y 42 x 80 y 42 x 81 y 42 x 17 y 43 x 18 y 43 x 19 y 43 x 20 y 43 x 21 y 43 x 22 y 43 x 23 y 43 x 24 y 43 x 25 y 43 x 26 y 43 x 27 y 43 x 28 y 43 x 29 y 43 x 30 y 43 x 31 y 43 x 32 y 43 x 33 y 43 x 34 y 43 x 35 y 43 x 36 y 43 x 37 y 43 x 38 y 43 x 39 y 43 x 62 y 43 x 63 y 43 x 64 y 43 x 65 y 43 x 66 y 43 x 67 y 43 x 68 y 43 x 69 y 43 x 70 y 43 x 71 y 43 x 72 y 43 x 73 y 43 x 74 y 43 x 75 y 43 x 76 y 43 x 77 y 43 x 78 y 43 x 79 y 43 x 80 y 43 x 81 y 43 x 82 y 43 x 23 y 44 x 24 y 44 x 25 y 44 x 26 y 44 x 27 y 44 x 28 y 44 x 29 y 44 x 30 y 44 x 31 y 44 x 32 y 44 x 33 y 44 x 34 y 44 x 35 y 44 x 36 y 44 x 37 y 44 x 38 y 44 x 39 y 44 x 40 y 44 x 61 y 44 x 62 y 44 x 63 y 44 x 64 y 44 x 65 y 44 x 66 y 44 x 67 y 44 x 68 y 44 x 69 y 44 x 70 y 44 x 71 y 44 x 72 y 44 x 73 y 44 x 74 y 44 x 75 y 44 x 76 y 44 x 77 y 44 x 78 y 44 x 79 y 44 x 80 y 44 x 81 y 44 x 82 y 44 x 83 y 44 x 26 y 45 x 27 y 45 x 28 y 45 x 29 y 45 x 30 y 45 x 31 y 45 x 32 y 45 x 33 y 45 x 34 y 45 x 35 y 45 x 36 y 45 x 37 y 45 x 38 y 45 x 39 y 45 x 40 y 45 x 41 y 45 x 61 y 45 x 62 y 45 x 63 y 45 x 64 y 45 x 65 y 45 x 66 y 45 x 67 y 45 x 68 y 45 x 69 y 45 x 70 y 45 x 71 y 45 x 72 y 45 x 73 y 45 x 74 y 45 x 75 y 45 x 76 y 45 x 77 y 45 x 78 y 45 x 79 y 45 x 80 y 45 x 81 y 45 x 82 y 45 x 83 y 45 x 84 y 45 x 25 y 46 x 26 y 46 x 27 y 46 x 28 y 46 x 29 y 46 x 30 y 46 x 31 y 46 x 32 y 46 x 33 y 46 x 34 y 46 x 35 y 46 x 36 y 46 x 37 y 46 x 38 y 46 x 39 y 46 x 40 y 46 x 41 y 46 x 42 y 46 x 60 y 46 x 61 y 46 x 62 y 46 x 63 y 46 x 64 y 46 x 65 y 46 x 66 y 46 x 67 y 46 x 68 y 46 x 69 y 46 x 70 y 46 x 71 y 46 x 72 y 46 x 73 y 46 x 74 y 46 x 75 y 46 x 76 y 46 x 77 y 46 x 78 y 46 x 79 y 46 x 80 y 46 x 81 y 46 x 82 y 46 x 83 y 46 x 84 y 46 x 85 y 46 x 25 y 47 x 26 y 47 x 27 y 47 x 28 y 47 x 29 y 47 x 30 y 47 x 31 y 47 x 32 y 47 x 33 y 47 x 34 y 47 x 35 y 47 x 36 y 47 x 37 y 47 x 38 y 47 x 39 y 47 x 40 y 47 x 41 y 47 x 42 y 47 x 43 y 47 x 60 y 47 x 61 y 47 x 62 y 47 x 63 y 47 x 64 y 47 x 65 y 47");
                   
            }
            else
            {
                System.out.println("failed to connect");
            }
            System.out.println("connection compleate");    
        } catch (RuntimeException e) {
            System.out.println(e.getMessage() + " Error");
        }
    }

    //herunder er metoden til at ændre størrelsen på billedet
    private static BufferedImage resize(BufferedImage img, int height, int width) {
        Image tmp = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        BufferedImage resized = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_BINARY);
        Graphics2D g2d = resized.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();
        return resized;
    }
//Den konvertere pixelværdierne til et 2d array

    public static int[][] convertToArray(BufferedImage image) {

        if (image == null || image.getWidth() == 0 || image.getHeight() == 0) {
            return null;
        }
        // This returns bytes of data starting from the top left of the bitmap
        // image and goes down.
        // Top to bottom. Left to right.
        final byte[] pixels = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();

        final int width = image.getWidth();
        final int height = image.getHeight();

        int[][] result = new int[height][width];

        boolean done = false;
        boolean alreadyWentToNextByte = false;
        int byteIndex = 0;
        int row = 0;
        int col = 0;
        int numBits = 0;
        byte currentByte = pixels[byteIndex];
        while (!done) {
            alreadyWentToNextByte = false;

            result[row][col] = (currentByte & 0x80) >> 7;
            currentByte = (byte) (((int) currentByte) << 1);
            numBits++;

            if ((row == height - 1) && (col == width - 1)) {
                done = true;
            } else {
                col++;

                if (numBits == 8) {
                    currentByte = pixels[++byteIndex];
                    numBits = 0;
                    alreadyWentToNextByte = true;
                }

                if (col == width) {
                    row++;
                    col = 0;

                    if (!alreadyWentToNextByte) {
                        currentByte = pixels[++byteIndex];
                        numBits = 0;
                    }
                }
            }
        }

        return result;
    }
    //her udskriver den 2d arrayet til en fil, som så bliver udskrevet som en tekstfil

    public static int[][] compute(File file) {
        try {
            BufferedImage image = ImageIO.read(file);
            Raster raster = image.getData();
            int w = raster.getWidth(), h = raster.getHeight();

            int pixels[][] = new int[w][h];
            for (int x = 0; x < w; x++) {
                for (int y = 0; y < h; y++) {

                    pixels[x][y] = raster.getSample(x, y, 0);
                }
            }
            String stringx;
            String stringy;
            try (//her bliver tekstfilen udskrevet
                    PrintStream output = new PrintStream(new File("C:\\Users\\euc\\Pictures\\output.txt"));) {
                for (int y = 0; y < h; y++) {
                    for (int x = 0; x < w; x++) {
                        // output.print(pixels[x][y] + ", ");
                        if (pixels[x][y] >= 125) {
                            if (x < 10){
                          stringx = "x 0" + x;
                       }
                       else{
                          stringx = "x " + x;
                       }
                       if (y < 10){
                           stringy = " y 0" + y;
                       }
                       else{
                           stringy = " y " + y;
}
                            output.println(stringx + stringy);
                        }
                    }
                    output.println("");
                }
                output.close();
            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            }
            return pixels;

        } catch (IOException e) {
        }
        return null;
    }
}

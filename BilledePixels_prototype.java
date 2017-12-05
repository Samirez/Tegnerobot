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
                    System.out.println(color);
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
            RobotClient R1 = new RobotClient("localhost", 4800);
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
            try (//her bliver tekstfilen udskrevet
                    PrintStream output = new PrintStream(new File("C:\\Users\\euc\\Pictures\\output.txt"));) {
                for (int y = 0; y < h; y++) {
                    for (int x = 0; x < w; x++) {
                        // output.print(pixels[x][y] + ", ");
                        if (pixels[x][y] >= 125) {
                            output.println("x " + x + " y " + y);
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

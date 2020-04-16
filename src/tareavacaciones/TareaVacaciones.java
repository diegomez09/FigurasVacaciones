//CUATRO LINEAS
//2 HORIZONTAL 2 DIAGONAL
//VARIOS CIRCULOS
//2 RECTANGULOS
//OVALOS RAROS
package tareavacaciones;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;
import javax.swing.JFrame;


public class TareaVacaciones extends JFrame{
    
    private BufferedImage buffer; 

    public TareaVacaciones() {
        super("DFGG 17310120");
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(2000, 10, 600, 600);
        this.setVisible(true); 
        buffer = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
        lineaRecta(25,58,45,150);
        lineaRecta(85,115,150,150);
        lineaRecta(150,120,200,220);
        lineaRecta(235,200,300,300);
        puntitcoMedioAJUA(250, 250, 20);
        puntitcoMedioAJUA(250, 250, 15);
        puntitcoMedioAJUA(250, 250, 10);
        puntitcoMedioAJUA(250, 250, 5);
        rectaALV(150, 250, 100, 130);
        rectaALV(240, 160, 120, 110);
        elipseMamadisimo(70, 30, 350, 350);
        elipseMamadisimo(60, 20, 350, 350);
        elipseMamadisimo(50, 10, 350, 350);
        elipseMamadisimo(35, 5, 350, 350);
    }
        
    public void putPixel(int x, int y, Color c){
        buffer.setRGB(0,0,c.getRGB());
        this.getGraphics().drawImage(buffer, x, y, this);        
    }
    
    public void lineaRecta(int x1,int x2, int y1, int y2){         
        int d = 0;
 
        int dx = Math.abs(x2 - x1);
        int dy = Math.abs(y2 - y1);
 
        int dx2 = 2 * dx; // slope scaling factors to
        int dy2 = 2 * dy; // avoid floating point
 
        int ix = x1 < x2 ? 1 : -1; // increment direction
        int iy = y1 < y2 ? 1 : -1;
 
        int x = x1;
        int y = y1;
 
        if (dx >= dy) {
            while (true) {
                putPixel(x, y,Color.RED);
                if (x == x2)
                    break;
                x += ix;
                d += dy2;
                if (d > dx) {
                    y += iy;
                    d -= dx2;
                }
            }
        } else {
            while (true) {
                putPixel(x, y,Color.RED);
                if (y == y2)
                    break;
                y += iy;
                d += dx2;
                if (d > dy) {
                    x += ix;
                    d -= dy2;
                }
            }
        }    
    } 
    
    public void puntitcoMedioAJUA(int equisCentral,int yeCentral, int r){
         equisCentral = 250;
         yeCentral = 210;          
        int x = r, y = 0; 
        putPixel(x + equisCentral,y + yeCentral,Color.RED); 
        if (r > 0) {               
            putPixel(x + equisCentral,-y + yeCentral,Color.RED);                   
            putPixel(y + equisCentral,x + yeCentral,Color.RED);                    
            putPixel(-y + equisCentral,x + yeCentral,Color.RED); 
        } 
        int P = 1 - r; 
        while (x > y) { 
              
            y++; 

            if (P <= 0) 
                P = P + 2 * y + 1; 

            else { 
                x--; 
                P = P + 2 * y - 2 * x + 1; 
            } 

            if (x < y) 
                break; 

            putPixel(x + equisCentral,y + yeCentral,Color.RED); 
                      
            putPixel(-x + equisCentral,y + yeCentral,Color.RED); 
                      
            putPixel(x + equisCentral,-y + yeCentral,Color.RED); 
                      
            putPixel(-x + equisCentral,-y + yeCentral,Color.RED); 
                     
            if (x != y) { 
                  
                putPixel(y + equisCentral,x + yeCentral,Color.RED); 
                        
                putPixel(-y + equisCentral,x + yeCentral,Color.RED); 
                        
                putPixel(y + equisCentral,-x + yeCentral, Color.RED); 
                        
                putPixel(-y + equisCentral,-x + yeCentral, Color.RED); 
            } 
        } 
    }
    
    public void rectaALV(int x1,int x2, int y1, int y2){
        //linea 1
        int mayorEquis=x2;
        int menorEquis=x1;
        int menorYe=y1;
        int mayorYe=y2;
        if(x1>x2){
             mayorEquis = x1;
             menorEquis = x2;
        }
        if(y1>y2){
            mayorYe = y1;
            menorYe = y2;
        }
        for(int i = menorEquis; i < mayorEquis; i++){
            putPixel(i, y1, Color.red); 
            putPixel(i, y2, Color.red);
        }
        for(int a = menorYe; a < mayorYe; a++){
                putPixel(menorEquis, a, Color.red);
                putPixel(mayorEquis, a, Color.red);
            }        
    }
    
    public void elipseMamadisimo(float rx, float ry,float xc, float yc){
    float dx, dy, d1, d2, x, y; 
    x = 0; 
    y = ry;
    d1 = (ry * ry) - (rx * rx * ry) + 
                    (0.25f * rx * rx); 
    dx = 2 * ry * ry * x; 
    dy = 2 * rx * rx * y; 
    DecimalFormat df = new DecimalFormat("#,###,##0.00000"); 

    while (dx < dy) 
    { 
        float uno = Float.valueOf(df.format(x + xc));
        int value = (int) uno;
        float dos = Float.valueOf(df.format(y+yc));
        int valueDos = (int) dos; 
        float tres = Float.valueOf(df.format(-x+xc));
        int valueT = (int) tres; 
        float cuatro = Float.valueOf(df.format(-y+yc));
        int valueC = (int) cuatro;         
        putPixel(value, valueDos , Color.RED); 
        putPixel(valueT, valueDos, Color.RED); 
        putPixel(value, valueC, Color.RED); 
        putPixel(valueT,valueC, Color.RED); 
  
    
        if (d1 < 0)  
        { 
            x++; 
            dx = dx + (2 * ry * ry); 
            d1 = d1 + dx + (ry * ry); 
        } 
        else
        { 
            x++; 
            y--; 
            dx = dx + (2 * ry * ry); 
            dy = dy - (2 * rx * rx); 
            d1 = d1 + dx - dy + (ry * ry); 
        } 
    } 
    d2 = ((ry * ry) * ((x + 0.5f) * (x + 0.5f))) 
        + ((rx * rx) * ((y - 1) * (y - 1))) 
        - (rx * rx * ry * ry); 

    while (y >= 0) {   
        float uno = Float.valueOf(df.format(x + xc));
        int value = (int) uno;
        float dos = Float.valueOf(df.format(y+yc));
        int valueDos = (int) dos; 
        float tres = Float.valueOf(df.format(-x+xc));
        int valueT = (int) tres; 
        float cuatro = Float.valueOf(df.format(-y+yc));
        int valueC = (int) cuatro; 
        putPixel(value, valueDos , Color.RED); 
        putPixel(valueT, valueDos, Color.RED); 
        putPixel(value, valueC, Color.RED); 
        putPixel(valueT,valueC, Color.RED); 
  
        if (d2 > 0) { 
            y--; 
            dy = dy - (2 * rx * rx); 
            d2 = d2 + (rx * rx) - dy; 
        } 
        else { 
            y--; 
            x++; 
            dx = dx + (2 * ry * ry); 
            dy = dy - (2 * rx * rx); 
            d2 = d2 + dx - dy + (rx * rx); 
        } 
    } 
}
    
    public static void main(String[] args) {
        // TODO code application logic here
        TareaVacaciones t = new TareaVacaciones();
    }
    
}

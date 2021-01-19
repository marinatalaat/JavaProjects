/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package New_Version;

/**
 *
 * @author iti
 */
public class Rect extends Shapes{
    private static int rectNum;
    private int rectColor;
    private int x2 , y2;

    public void setX2(int x2){
         this.x2=x2-this.getX1();
    }
    public int getX2(){
        return this.x2;
    }
    public void setY2(int y2){
        this.y2=y2-this.getY1();
    }
    public int getY2(){
        return this.y2;
    }

    public void setColor(int Color) {
        this.rectColor = Color;
    }

    public int getColor() {
        return rectColor;
    }
    
    public static void incR(){
        rectNum++;
    }
    
    public static void decR(){
        rectNum--;
    }
    public static void setR(int n){
        rectNum=n;
    }
    
    public static int getR(){
        return rectNum;
    }
    /*public  void printtt(){
        System.out.println("HELOOOO FROM RECT ONLUY");
    }*/
    
}

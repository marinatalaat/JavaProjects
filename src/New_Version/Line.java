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
public class Line extends Shapes{
    
    private static int lineNum;
    private int lineColor;
    private int x2 , y2;
    
    public void setX2(int x2){
         this.x2=x2;
    }
    public int getX2(){
        return this.x2;
    }
    public void setY2(int y2){
        this.y2=y2;
    }
    public int getY2(){
        return this.y2;
    }

    public int getColor() {
        return lineColor;
    }

    public void setColor(int Color) {
        this.lineColor = Color;
    }
    
    public static void incL(){
        lineNum++;
    }
    
    public static void decL(){
        lineNum--;
    }
    public static void setL(int n){
        lineNum=n;
    }
    public static int getL(){
        return lineNum;
    }
    
}

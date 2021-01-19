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
public class Oval extends Shapes{
    
    private static int ovalNum;
    private int ovalColor;
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

    public int getColor() {
        return ovalColor;
    }

    public void setColor(int Color) {
        this.ovalColor = Color;
    }
    
    public static void incO(){
        ovalNum++;
    }
    
    public static void decO(){
        ovalNum--;
    }
    public static void setO(int n){
        ovalNum=n;
    }
    public static int getO(){
        return ovalNum;
    }
    
}

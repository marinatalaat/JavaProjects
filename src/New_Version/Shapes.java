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
public abstract class Shapes {
    
    private Point upperLeft = new Point();
   
    
    public void setX1(int x1){
        this.upperLeft.setX1(x1);
    }
    public int getX1(){
        return this.upperLeft.getX1();
    }
    public void setY1(int y1){
        this.upperLeft.setY1(y1);
    }
    public int getY1(){
        return this.upperLeft.getY1();
    }    
    
    public abstract void setX2(int x2);
    public abstract int getX2();
    public abstract void setY2(int y2);
    public abstract int getY2();
    
    
    public abstract void setColor(int Color) ;
    public abstract int getColor() ;

    void printtt() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

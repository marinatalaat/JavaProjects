/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package New_Version;


import java.applet.Applet;
import java.awt.BasicStroke;
import java.awt.Button;
import java.awt.Color;
import java.awt.Checkbox;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;


/**
 *
 * @author iti
 */
public class New_Paint_Brush extends Applet {
int numOfShapes = 500;
    Button b1 , b2 , b3 , b4, b5 , b6 ,b7,b8,b9,b10;
    BufferedImage bufferedImage;
    Shapes [] rectarr = new Rect[numOfShapes];
    Shapes [] ovalarr = new Oval[numOfShapes];
    Shapes [] linesarr = new Line[numOfShapes];
    Integer [][] points = new Integer[numOfShapes][3];
    Color c , c1;
    String SelectedShape=null ;
    String [] Undo = new String[numOfShapes];
    int i , p , u;
    Checkbox cb = new Checkbox("Filled");
    Checkbox cb2 = new Checkbox("Dotted");
    
    Font f = new Font("Seif Bold" ,Font.BOLD, 30 );
    // used for dotted lines
    float dash1[] = { 10.0f };
    BasicStroke dashed = new BasicStroke(1.0f,BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, dash1, 0.0f);
    
    public void init() {
                
        b1 = new Button("RED");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.RED);
        b1.setFont(f);
        b2 = new Button("GREEN");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.GREEN);
        b2.setFont(f);
        b3 = new Button("BLUE");
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.BLUE);
        b3.setFont(f);
        b4 = new Button("RECTANGLE");
        b4.setBackground(Color.BLACK);
        b4.setForeground(Color.WHITE);
        b4.setFont(f);
        b5 = new Button("OVAL");
        b5.setBackground(Color.BLACK);
        b5.setForeground(Color.WHITE);
        b5.setFont(f);
        b6 = new Button("LINE");
        b6.setBackground(Color.BLACK);
        b6.setForeground(Color.WHITE);
        b6.setFont(f);
        b7 = new Button("ClearAll");
        b7.setBackground(Color.BLACK);
        b7.setForeground(Color.WHITE);
        b7.setFont(f);
        b8 = new Button("Eraser");
        b8.setBackground(Color.BLACK);
        b8.setForeground(Color.WHITE);
        b8.setFont(f);
        b9 = new Button("Undo");
        b9.setBackground(Color.BLACK);
        b9.setForeground(Color.WHITE);
        b9.setFont(f);
        b10 = new Button("Free Hand");
        b10.setBackground(Color.BLACK);
        b10.setForeground(Color.WHITE);
        b10.setFont(f);
        
        cb.setFont(f);
        cb.setForeground(Color.LIGHT_GRAY);
        cb2.setFont(f);
        cb2.setForeground(Color.LIGHT_GRAY);
        
        
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               c=Color.RED;
               i=0;
            }
        });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               c=Color.GREEN;
               // i : to be used to store color of each shape 
               i=1;
            }
        });
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               c=Color.BLUE;
               i=2;
            }
        });
        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               SelectedShape="Rect";
            }
        });
        b5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               SelectedShape="Oval";
            }
        });
        b6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               SelectedShape="Line";
            }
        });
        b10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               SelectedShape="FreeHand";
            }
        });
        
        
        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mousePressed(MouseEvent e) {
                
                // will store start point in the suitable array depending on the Selected shape that has been choosen while pressing on the desired button
                switch(SelectedShape){
                    case "Rect":                     
                        rectarr[Rect.getR()] = new Rect();
                        rectarr[Rect.getR()].setX1(e.getX());
                        rectarr[Rect.getR()].setY1(e.getY());
                        //rectarr[Rect.getR()].printtt();
                    break;   
                    case "Oval":
                        ovalarr[Oval.getO()] = new Oval();
                        ovalarr[Oval.getO()].setX1(e.getX());
                        ovalarr[Oval.getO()].setY1(e.getY());
                    break; 
                    case "Line":
                        linesarr[Line.getL()] = new Line();
                        linesarr[Line.getL()].setX1(e.getX());
                        linesarr[Line.getL()].setY1(e.getY());
                    break; 
                    case "FreeHand":
                        points[p][0] = e.getX();
                        points[p][1] = e.getY();
                        points[p][2] = i; 
                        p++;     
                    break;
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // will store end point in the suitable array depending on the Selected shape that has been choosen while pressing on the desired button
                switch(SelectedShape){
                    case "Rect":
                        rectarr[Rect.getR()].setX2(e.getX());
                        rectarr[Rect.getR()].setY2(e.getY());
                        rectarr[Rect.getR()].setColor(i);
                        Rect.incR();
                        repaint();
                    break;   
                    case "Oval":
                        ovalarr[Oval.getO()].setX2(e.getX());
                        ovalarr[Oval.getO()].setY2(e.getY());
                        ovalarr[Oval.getO()].setColor(i);
                        Oval.incO();
                        repaint();
                    break; 
                    case "Line":
                        linesarr[Line.getL()].setX2(e.getX());
                        linesarr[Line.getL()].setY2(e.getY());
                        linesarr[Line.getL()].setColor(i);
                        Line.incL();
                        repaint();
                    break;
                    case "FreeHand":
                        points[p][0] = e.getX();
                        points[p][1] = e.getY();
                        points[p][2] = i; 
                        p++; 
                        repaint();
                    break;
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseExited(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        
        b7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // will set counter of all shapes with zero to clear all drawing shapes
                SelectedShape="ClearAll";
                Rect.setR(0);
                Oval.setO(0);
                Line.setL(0);
                p=0;
                repaint();
                
            }
        });
        b8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            // will set counter of a kind of shapes with zero to clear all drawing of this shape will erase in the following order : rectangles then ovals then lines then free hand drawings
                SelectedShape="eraser";                
                if(Rect.getR()>0){
                    Rect.setR(0);
                }
                else{
                    if(Oval.getO()>0){
                        Oval.setO(0);
                    }
                else{
                        if(Line.getL()>0){
                            Line.setL(0);
                        }
                    else{
                            if(p>0){
                                p=0;
                            }
                        }
                    }
                }
                
                repaint();
            }
        });
        b9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            // will erase shapes in a reversed way, from the last shape till the first one, then he delete it an the screen will be cleared     
               SelectedShape="Undo";
                    if(u>0){
                        u--; 
                    if(Undo[u]!=" "){    
                        if(Undo[u]=="Rect"){
                               Rect.decR();
                           }
                        else{
                               if(Undo[u]=="Oval"){
                                   Oval.decO();
                               }
                        else{
                                   if(Undo[u]=="Line"){
                                       Line.decL();
                                   }
                                    else{
                                       if(Undo[u]=="FreeHand"){
                                            for(int g=0;g<Undo.length;g++){
                                                   if(Undo[g]=="FreeHand"){
                                                       Undo[g]=" ";
                                                   }
                                               }
                                               p=0;
                                       }
                                   }
                               }
                           }
                    }        
                           repaint();
                    }
               }
            
        });

        this.addMouseMotionListener(new MouseMotionListener() {
            @Override
            // to save every point as Iam choosing the free hand button
            public void mouseDragged(MouseEvent e) {
               switch(SelectedShape){
                   case "FreeHand":
                        points[p][0] = e.getX();
                        points[p][1] = e.getY();
                        points[p][2] = i; 
                        p++;  
                       // repaint();
                   break;
               }
            }
            @Override
            public void mouseMoved(MouseEvent e) {
               // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });

// to display the buttons and check boxes
       add(b1);
       add(b2);
       add(b3);
       add(b4);
       add(b5);
       add(b6);
       add(b7);
       add(b8);
       add(b9);       
       add(b10);
       
       add(cb);
       add(cb2);
    }
    
    
    
    @Override
public void paint(Graphics g){
 bufferedImage = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_4BYTE_ABGR);
  //g = bufferedImage.createGraphics();     
  // g.setColor(Color.WHITE);
  // g.fillRect(0, 0, getWidth(), getHeight());

// to not enter the below code if user choose to clear all the shapes to save time by not entering and cheking all the below conditions  
if(SelectedShape!="ClearAll"){

// to save names of shapes in the same order that is created by to help in undo function    
    if(SelectedShape!="Undo"){
    if(u<Undo.length){
        Undo[u]=SelectedShape;
        u++;
    }
    else{
        for(int k=0;k<(Undo.length)-1;k++){
            Undo[k]=Undo[k+1];
        }
        Undo[(Undo.length)-1] = SelectedShape;
    }
    }
    // enter here if user don't check the fiiled check box
    if(cb.getState()==false){
         // enter here if user don't check the dotted check box and then draw the new and also the previous shapes to be appeared on the screen
        if(cb2.getState()==false){
        g.setColor(c);
        
        if(SelectedShape=="Rect"){
            g.drawRect(rectarr[(Rect.getR())-1].getX1(), rectarr[(Rect.getR())-1].getY1(),rectarr[(Rect.getR())-1].getX2(), rectarr[(Rect.getR())-1].getY2());
        }
        else{
            if(SelectedShape.equals("Oval")){
                g.drawOval(ovalarr[(Oval.getO())-1].getX1(), ovalarr[(Oval.getO())-1].getY1(), ovalarr[(Oval.getO())-1].getX2(), ovalarr[(Oval.getO())-1].getY2());
            }
            else{
                if(SelectedShape.equals("Line")){
                g.drawLine(linesarr[(Line.getL())-1].getX1(), linesarr[(Line.getL())-1].getY1(), linesarr[(Line.getL())-1].getX2(), linesarr[(Line.getL())-1].getY2());
                }
                else{
                    if(SelectedShape.equals("FreeHand")){
                        for(int ii=0 ; ii<p;ii++){
                            g.fillOval(points[ii][0] , points[ii][1], 10, 10);
                        }
                    }
                }
            }
        }     
        for(int j=0 ; j<Rect.getR(); j++){
           switch(rectarr[j].getColor()){
               case 0:
                   c1=Color.RED;
                   break;
               case 1:
                   c1=Color.GREEN;
                   break; 
               case 2:
                   c1=Color.BLUE;
                   break;   
           }
            g.setColor(c1);
           g.drawRect(rectarr[j].getX1(), rectarr[j].getY1(),rectarr[j].getX2(), rectarr[j].getY2());
        }
        for(int j=0 ; j<Oval.getO(); j++){
           switch(ovalarr[j].getColor()){
               case 0:
                   c1=Color.RED;
                   break;
               case 1:
                   c1=Color.GREEN;
                   break; 
               case 2:
                   c1=Color.BLUE;
                   break;   
           }
            g.setColor(c1);;
            g.drawOval(ovalarr[j].getX1(), ovalarr[j].getY1(), ovalarr[j].getX2(), ovalarr[j].getY2());
        }
        for(int j=0 ; j<Line.getL(); j++){
           switch(linesarr[j].getColor()){
               case 0:
                   c1=Color.RED;
                   break;
               case 1:
                   c1=Color.GREEN;
                   break; 
               case 2:
                   c1=Color.BLUE;
                   break;   
           }
            g.setColor(c1);
            g.drawLine(linesarr[j].getX1(), linesarr[j].getY1(), linesarr[j].getX2(), linesarr[j].getY2());
        }   
       
        for(int jj=0 ; jj<p; jj++){
                 switch(points[jj][2]){
                     case 0:
                         c1=Color.RED;
                         break;
                     case 1:
                         c1=Color.GREEN;
                         break; 
                     case 2:
                         c1=Color.BLUE;
                         break;   
                 }
                  g.setColor(c1);
                  g.fillOval(points[jj][0] , points[jj][1], 10, 10);
              }
        }
        
        else{
             // enter here if user check the dotted check box the new and also the previous shapes will be appeared in a dotted lines
            if(cb2.getState()==true){
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setStroke(dashed);
                
                g2.setColor(c);
                    if(SelectedShape.equals("Rect")){
                        g2.drawRect(rectarr[(Rect.getR())-1].getX1(), rectarr[(Rect.getR())-1].getY1(),rectarr[(Rect.getR())-1].getX2(), rectarr[(Rect.getR())-1].getY2());
                    }
                    else{
                        if(SelectedShape.equals("Oval")){
                            g2.drawOval(ovalarr[(Oval.getO())-1].getX1(), ovalarr[(Oval.getO())-1].getY1(), ovalarr[(Oval.getO())-1].getX2(), ovalarr[(Oval.getO())-1].getY2());
                        }
                        else{
                            if(SelectedShape.equals("Line")){
                            g2.drawLine(linesarr[(Line.getL())-1].getX1(), linesarr[(Line.getL())-1].getY1(), linesarr[(Line.getL())-1].getX2(), linesarr[(Line.getL())-1].getY2());
                            }
                            else{
                                    if(SelectedShape.equals("FreeHand")){
                                    for(int ii=0 ; ii<p;ii++){
                                        g2.fillOval(points[ii][0] , points[ii][1], 10, 10);
                                    }
                                }
                            }
                        }
                    }     
                   for(int j=0 ; j<Rect.getR(); j++){
                       switch(rectarr[j].getColor()){
                           case 0:
                               c1=Color.RED;
                               break;
                           case 1:
                               c1=Color.GREEN;
                               break; 
                           case 2:
                               c1=Color.BLUE;
                               break;   
                       }
                        g2.setColor(c1);
                       g2.drawRect(rectarr[j].getX1(), rectarr[j].getY1(),rectarr[j].getX2(), rectarr[j].getY2());
                    }
                    for(int j=0 ; j<Oval.getO(); j++){
                       switch(ovalarr[j].getColor()){
                           case 0:
                               c1=Color.RED;
                               break;
                           case 1:
                               c1=Color.GREEN;
                               break; 
                           case 2:
                               c1=Color.BLUE;
                               break;   
                       }
                        g2.setColor(c1);;
                        g2.drawOval(ovalarr[j].getX1(), ovalarr[j].getY1(), ovalarr[j].getX2(), ovalarr[j].getY2());
                    }
                    for(int j=0 ; j<Line.getL(); j++){
                       switch(linesarr[j].getColor()){
                           case 0:
                               c1=Color.RED;
                               break;
                           case 1:
                               c1=Color.GREEN;
                               break; 
                           case 2:
                               c1=Color.BLUE;
                               break;   
                       }
                        g2.setColor(c1);
                        g2.drawLine(linesarr[j].getX1(), linesarr[j].getY1(), linesarr[j].getX2(), linesarr[j].getY2());
                    }
                    
                    for(int jj=0 ; jj<p; jj++){
                        switch(points[jj][2]){
                            case 0:
                                c1=Color.RED;
                                break;
                            case 1:
                                c1=Color.GREEN;
                                break; 
                            case 2:
                                c1=Color.BLUE;
                                break;   
                        }
                         g.setColor(c1);
                         g.fillOval(points[jj][0] , points[jj][1], 10, 10);
                     }
            }
        }    
    }
    
    else{
         // enter here if user check the fiiled check box the new and also the previous shapes will be appeared in a fiiled way
        if(cb.getState()==true){
            
                    g.setColor(c);

                if(SelectedShape.equals("Rect")){
                    g.fillRect(rectarr[(Rect.getR())-1].getX1(), rectarr[(Rect.getR())-1].getY1(),rectarr[(Rect.getR())-1].getX2(), rectarr[(Rect.getR())-1].getY2());
                }
                else{
                    if(SelectedShape.equals("Oval")){
                        g.fillOval(ovalarr[(Oval.getO())-1].getX1(), ovalarr[(Oval.getO())-1].getY1(), ovalarr[(Oval.getO())-1].getX2(), ovalarr[(Oval.getO())-1].getY2());
                    }
                    else{
                        if(SelectedShape.equals("Line")){
                        g.drawLine(linesarr[(Line.getL())-1].getX1(), linesarr[(Line.getL())-1].getY1(), linesarr[(Line.getL())-1].getX2(), linesarr[(Line.getL())-1].getY2());
                        }
                        else{
                            if(SelectedShape.equals("FreeHand")){
                                for(int ii=0 ; ii<p;ii++){
                                    g.fillOval(points[ii][0] , points[ii][1], 10, 10);
                                }
                            }
                        }
                    }
                }     
                for(int j=0 ; j<Rect.getR(); j++){
                    switch(rectarr[j].getColor()){
                       case 0:
                           c1=Color.RED;
                           break;
                       case 1:
                           c1=Color.GREEN;
                           break; 
                       case 2:
                           c1=Color.BLUE;
                           break;   
                   }
                    g.setColor(c1);
                    g.fillRect(rectarr[j].getX1(), rectarr[j].getY1(),rectarr[j].getX2(), rectarr[j].getY2());
                }
                for(int j=0 ; j<Oval.getO(); j++){
                  switch(ovalarr[j].getColor()){
                       case 0:
                           c1=Color.RED;
                           break;
                       case 1:
                           c1=Color.GREEN;
                           break; 
                       case 2:
                           c1=Color.BLUE;
                           break;   
                   }
                    g.setColor(c1);;
                    g.fillOval(ovalarr[j].getX1(), ovalarr[j].getY1(), ovalarr[j].getX2(), ovalarr[j].getY2());
                }
               for(int j=0 ; j<Line.getL(); j++){
                 switch(linesarr[j].getColor()){
                       case 0:
                           c1=Color.RED;
                           break;
                       case 1:
                           c1=Color.GREEN;
                           break; 
                       case 2:
                           c1=Color.BLUE;
                           break;   
                   }
                    g.setColor(c1);
                    g.drawLine(linesarr[j].getX1(), linesarr[j].getY1(), linesarr[j].getX2(), linesarr[j].getY2());
                }
               
               for(int jj=0 ; jj<p; jj++){
                 switch(points[jj][2]){
                     case 0:
                         c1=Color.RED;
                         break;
                     case 1:
                         c1=Color.GREEN;
                         break; 
                     case 2:
                         c1=Color.BLUE;
                         break;   
                 }
                  g.setColor(c1);
                  g.fillOval(points[jj][0] , points[jj][1], 10, 10);
              }
            
            
            
        }
    }       
                    // to change the drawings into a PNG and a JPG images
                            g = bufferedImage.createGraphics(); 
                               File file  = new File("pic.png");
                                try {
                                    ImageIO.write(bufferedImage, "png", file);
                                } catch (IOException ex) {
                                    Logger.getLogger(New_Paint_Brush.class.getName()).log(Level.SEVERE, null, ex);
                                }

                                file = new File("pic.jpg");
                                try {
                                    ImageIO.write(bufferedImage, "jpg", file);
                                } catch (IOException ex) {
                                    Logger.getLogger(New_Paint_Brush.class.getName()).log(Level.SEVERE, null, ex);
                                } 
                                
                                
                                
}
}
}


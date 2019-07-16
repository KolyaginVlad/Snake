package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public  class HeadSneake {
   static Image image;
   static int direction;
   static final int UP =1;
    static final int DOWN =2;
    static final int LEFT =3;
    static final int RRIGHT =4;

   //Всё статическое т.к. голова одна
   static int x;
   static int y;
   static final int WIDTH = 50;//Длинна и ширина одного блока змеи, будет использоваться в Body
   static final int HEIGHT = 50;
   public HeadSneake(int x,int y,int direction){
       this.x = x;
       this.y = y;
       this.direction = direction;

       try {
           image = ImageIO.read(new File("bull.jpg"));
       } catch (IOException e) {
           e.printStackTrace();
       }

       //Присваиваем изображению файл с изображением
   }
}

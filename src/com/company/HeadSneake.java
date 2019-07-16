package com.company;

import java.awt.*;

public  class HeadSneake {
   static Image image;
   //Всё статическое т.к. голова одна
   static int x;
   static int y;
   static final int WIDTH = 50;//Длинна и ширина одного блока змеи, будет использоваться в Body
   static final int HEIGHT = 50;
   public HeadSneake(int x,int y){
       this.x=x;
       this.y=y;
       //Присваиваем изображению файл с изображением
   }
}

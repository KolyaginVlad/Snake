package com.company;

import java.awt.*;

public class Hay {
    //Сена может быть много, поэтому не статик
    //Все файлы java  в одном пакете поэтому модификатор доступа не нужен
   static Image image;
   static int x;
   static int y;
    public Hay(){
        this.x=x;
        this.y=y;
        //Присваиваем изображению файл с изображением
    }
    public static void eatHay(){
        int newX = (int)(Math.random()*Window.WIDTH);
        int newY =(int)(Math.random()*Window.HEIGHT);
        if (newX)
    }
}

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
        boolean flag = true;
        for (BodySneake body:Window.bodySneakeArrayList
             ) {
            if (Math.abs(newX-body.x)<HeadSneake.WIDTH&&Math.abs(newY-body.y)<HeadSneake.HEIGHT){
                flag = false;
                break;
            }
        }
        if (flag){
            x = newX;
            y = newY;
        }
        else eatHay();
    }
}

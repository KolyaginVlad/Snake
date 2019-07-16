package com.company;

import java.awt.*;

public class BodySneake {
    //Тел будет много, поэтому не статик
    //Все файлы java  в одном пакете поэтому модификатор доступа не нужен
    Image image;
    int x;
    int y;
    public BodySneake(int x,int y){
        this.x = x;
        this.y = y;
        //Присваиваем изображению файл с изображением
    }
}

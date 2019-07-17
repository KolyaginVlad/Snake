package com.company;

public class HeadSneake {
    static final int UP = 1;
    static final int DOWN = 2;
    static final int LEFT = 3;
    static final int RRIGHT = 4;
    static final int WIDTH = 20;//Длинна и ширина одного блока змеи, будет использоваться в Body
    static final int HEIGHT = 20;
    static int direction;
    //Всё статическое т.к. голова одна
    static int x;
    static int y;
    static int step = 20;


    public HeadSneake(int x, int y, int direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        //Присваиваем изображению файл с изображением


    }

    public static void sneakeMove(){
        if (direction==RRIGHT){
            x+=step;
        }
        else if (direction==LEFT){
            x-=step;
        }
        else if (direction==UP){
            y-=step;
        }
        else if (direction==DOWN){
            y+=step;
        }
    }

    public static void isSnakeEat(){
        if (Math.abs(x-Hay.x)<WIDTH&&Math.abs(y-Hay.y)<HEIGHT){
            Hay.eatHay();
            Window.bodySneakeArrayList.add(new BodySneake(Window.bodySneakeArrayList.get(Window.bodySneakeArrayList.size()-1).x,Window.bodySneakeArrayList.get(Window.bodySneakeArrayList.size()-1).y));
        }
    }

    public static void isCrash(){
        if (x<0||x>Window.WIDTH||y<0||y>Window.HEIGHT-40){
            Window.game = false;
            x= 100;
            y=0;
            for (int i = Window.bodySneakeArrayList.size()-1; i >=0 ; i--) {
                Window.bodySneakeArrayList.remove(i);
            }
            Canvas.first=true;
            direction=RRIGHT;
        }
        else{
            for (BodySneake body:Window.bodySneakeArrayList
                 ) {
                if (Math.abs(x-body.x)<WIDTH&&Math.abs(y-body.y)<HEIGHT){
                    Window.game = false;
                    x=100;
                    y=0;
                    for (int i = Window.bodySneakeArrayList.size()-1; i >=0 ; i--) {
                        Window.bodySneakeArrayList.remove(i);
                    }
                    Canvas.first=true;
                    direction=RRIGHT;
                    break;
                }

            }
        }
    }
}

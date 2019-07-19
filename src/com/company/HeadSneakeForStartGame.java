package com.company;

import java.util.ArrayList;

public class HeadSneakeForStartGame {
    static int x;
    static int y;
    static int step = 20;
    static final int WIDTH = 20;//Длинна и ширина одного блока змеи, будет использоваться в Body
    static final int HEIGHT = 20;
     public static ArrayList<BodySneake> bodysForStartGame = new ArrayList<>();

    public static void sneakeMove(){
        if (x>Window.WIDTH+step){
            if (y<Window.HEIGHT-step) {
                y += 20;
                x=0;
            }
            else {
                y = 0;
                x=0;
            }

        }
        else x+=20;


    }
    public static void isSnakeEat(){
        if (Math.abs(x-HayForStartGame.x)<WIDTH&&Math.abs(y-HayForStartGame.y)<HEIGHT){
            HayForStartGame.eatHay();
            bodysForStartGame.add(new BodySneake(bodysForStartGame.get(bodysForStartGame.size()-1).x,bodysForStartGame.get(bodysForStartGame.size()-1).y));
        }
    }
}

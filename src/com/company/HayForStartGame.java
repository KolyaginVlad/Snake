package com.company;

public class HayForStartGame {
    static int x;
    static int y;




    public static void eatHay() {
        int newX = (int) (Math.random() * (Window.WIDTH-100)+50);
        int newY = (int) (Math.random() * (Window.HEIGHT-100)+50);
        boolean flag = true;
        for (BodySneake body : HeadSneakeForStartGame.bodysForStartGame
        ) {
            if (Math.abs(newX - body.x) < HeadSneake.WIDTH && Math.abs(newY - body.y) < HeadSneake.HEIGHT) {
                flag = false;
                break;
            }
        }

        if (flag) {
            if (!(Math.abs(newX - HeadSneakeForStartGame.x) < HeadSneakeForStartGame.WIDTH) && !(Math.abs(newY - HeadSneakeForStartGame.y) < HeadSneakeForStartGame.HEIGHT)) {
                x = newX;
                y = newY;
            } else eatHay();
        } else eatHay();
    }
}

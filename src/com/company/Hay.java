package com.company;

public class Hay {


    static int x;
    static int y;


  

    public static void eatHay() {
        int newX = (int) (Math.random() * (Window.WIDTH-100)+50);
        int newY = (int) (Math.random() * (Window.HEIGHT-100)+50);
        boolean flag = true;
        for (BodySneake body : Window.bodySneakeArrayList
        ) {
            if (Math.abs(newX - body.x) < HeadSneake.WIDTH && Math.abs(newY - body.y) < HeadSneake.HEIGHT) {
                flag = false;
                break;
            }
        }

        if (flag) {
            if (!(Math.abs(newX - HeadSneake.x) < HeadSneake.WIDTH) && !(Math.abs(newY - HeadSneake.y) < HeadSneake.HEIGHT)) {
                x = newX;
                y = newY;
            } else eatHay();
        } else eatHay();
    }
}

package ppj.additional;

import java.awt.*;

public
class Flake
        extends Frame {

    public static void main(String[] args){
        new Flake();
    }

    int[][] arr;

    public Flake(){
        arr = new int[3][2];

        recalculatePoints();

        this.setSize( 640, 480);
        this.setVisible(true);
    }

    public void recalculatePoints(){

        int r = ((getWidth() < getHeight() ? getWidth() : getHeight()) / 2) - 30;
        System.out.println(r);
        double step = (2*Math.PI)/arr.length;

        for(int i=0; i<arr.length; i++){
            arr[i][0] = (int)(Math.sin(step*i) * r);
            arr[i][1] = (int)(Math.cos(step*i) * r);
        }
    }

    public void paint(Graphics g){
        g.setColor(
                Color.red
        );
        recalculatePoints();

        if(arr != null) {
            for(int i=0; i<arr.length; i++) {
                myDrawLine(
                        g, 10,
                        getWidth()/2+arr[i][0], getHeight()/2+arr[i][1],
                        getWidth()/2+arr[(i+1)%arr.length][0], getHeight()/2+arr[(i+1)%arr.length][1]
                );
            }
        }
    }

    final double m  = Math.sqrt(3)/6.0;

    public void myDrawLine(Graphics g, int level, int x1, int y1, int x2, int y2){
        if(level == 1){
            g.drawLine( x1, y1, x2, y2);
        }else {
            int deltaX = x2 - x1;
            int deltaY = y2 - y1;

            int x3 = x1 + deltaX / 3;
            int y3 = y1 + deltaY / 3;
            int x4 = x1 + (int) (deltaX / 2 - m * deltaY);
            int y4 = y1 + (int) (deltaY / 2 + m * deltaX);
            int x5 = x1 + 2 * deltaX / 3;
            int y5 = y1 + 2 * deltaY / 3;

            myDrawLine(g, level-1, x1, y1, x3, y3);
            myDrawLine(g, level-1, x3, y3, x4, y4);
            myDrawLine(g, level-1, x4, y4, x5, y5);
            myDrawLine(g, level-1, x5, y5, x2, y2);
        }
    }

}

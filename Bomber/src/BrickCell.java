import java.awt.*;

import static org.lwjgl.opengl.GL11.*;

public class BrickCell extends Cell {
    public  BrickCell() {
        this.background = Color.YELLOW;

        this.innerBorderLineWidth = 0;
        this.outerBorderLineWidth = 0;
    }




    @Override
    public void drawBG(Graphics g) {
        super.drawBG(g);

        glBegin(GL_QUADS);
        glColor3f(50/256f,140/256f, 194/256f );
        g.putRect(0,0, 1, 0.32f);

        glColor3f(217/256f,148/256f, 30/256f );
        g.putRect(0,0.65f, 1,1);
//
        glColor3f(50/256f,140/256f, 194/256f );
        g.putRect(0, 0.33f, 0.32f, 0.65f);
        glColor3f(50/256f,14/256f, 194/256f );
         g.putRect(0.33f, 0.33f, 1, 0.65f);

        glEnd();
    }
}



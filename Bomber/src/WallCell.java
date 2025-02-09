import java.awt.*;
import java.awt.geom.Point2D;
import static org.lwjgl.opengl.GL11.*;

public class WallCell extends Cell  {
    @Override
    public void draw(Graphics g) {
        super.draw(g);
        drawConcreteBG(g);
    }

    public void removeBorderTop() {
        outerBorderLineColorTop = background;
        innerBorderLineColorTop = background;
        outerCornerPointColorTopRight = outerBorderLineColorRight;
        innerCornerPointColorTopRight = innerBorderLineColorRight;
        outerCornerPointColorBottomLeft = outerBorderLineColorLeft;
        innerCornerPointColorBottomLeft = innerBorderLineColorLeft;
    }
    public void removeBorderBottom() {
        outerBorderLineColorBottom = background;
        innerBorderLineColorBottom = background;
        outerCornerPointColorBottomRight = outerBorderLineColorRight;
        innerCornerPointColorBottomRight = innerBorderLineColorRight;
        outerCornerPointColorBottomLeft = outerBorderLineColorLeft;
        innerCornerPointColorBottomLeft = innerBorderLineColorLeft;
    }


    public void removeBorderRight() {
        outerBorderLineColorRight = background;
        innerBorderLineColorRight = background;
        outerCornerPointColorTopRight = outerBorderLineColorTop;
        innerCornerPointColorTopRight = innerBorderLineColorTop;
        outerCornerPointColorBottomRight = outerBorderLineColorBottom;
        innerCornerPointColorBottomRight = innerBorderLineColorBottom;
    }

    public void removeBorderLeft() {
        outerBorderLineColorLeft = background;
        innerBorderLineColorLeft = background;
        outerCornerPointColorTopLeft = outerBorderLineColorTop;
        innerCornerPointColorTopLeft = innerBorderLineColorTop;
        outerCornerPointColorBottomLeft = outerBorderLineColorBottom;
        innerCornerPointColorBottomLeft = innerBorderLineColorBottom;
    }

    private class ConcretePoint extends Point2D.Float {
        public Color pointColor = Color.WHITE;
        public float pointSize;
        public ConcretePoint() {
            this.x = (float) Math.random();
            this.y = (float) Math.random();
            this.pointSize = (float) Math.random()*2 + 0.5f;
        }
    }
    private ConcretePoint[] concretePoints;
    public WallCell(float outerBorderLineWidth,
                    Color outerBorderLineColorLeft,
                    Color outerBorderLineColorTop,
                    Color outerBorderLineColorRight,
                    Color outerBorderLineColorBottom) {
        this.background = Color.LIGHT_GRAY;
        this.innerBorderLineWidth = 0;
        setOuterBorderLines(outerBorderLineWidth, outerBorderLineColorLeft, outerBorderLineColorTop,
                            outerBorderLineColorRight, outerBorderLineColorBottom);
    }

    public void setStyle(int style) {
        final Color ltGr = Color.LIGHT_GRAY.darker();
        final Color dkGr = Color.DARK_GRAY.brighter();
        switch (style) {
            case 0:
                setInnerBorderLines(0, Color.LIGHT_GRAY);
                this.concretePoints = null;
                break;
            case 4:
                setOuterCornerPointColor(Color.BLACK);
                outerCornerPointColorTopLeft = Color.LIGHT_GRAY;
                innerBorderLineWidth = outerBorderLineWidth;
                innerBorderLineColorBottom = ltGr;
                innerCornerPointColorBottomLeft = ltGr;
                innerCornerPointColorBottomRight = dkGr;
                innerBorderLineColorRight = ltGr;
                break;
            case 3:
                makeConPts(20);
            case 2:
                setInnerBorderLines(outerBorderLineWidth, ltGr);
            case 1:
                setOuterCornerPointColor(Color.BLACK);
                break;

        }

    }


    protected void makeConPts(int cntPoints) {
        concretePoints = new ConcretePoint[cntPoints];
        for (int i = 0; i < cntPoints; i++) {
            concretePoints[i] = new ConcretePoint();
        }
    }

    public void drawConcreteBG(Graphics g) {
        if(concretePoints!=null)
        for(ConcretePoint p: concretePoints) {
            glPointSize(p.pointSize);
            g.putColor(p.pointColor);
            glBegin(GL_POINTS);
            glVertex2f(p.x, p.y);
            glEnd();
        }
    }

    public WallCell() {
        this.background = Color.LIGHT_GRAY;
        this.innerBorderLineWidth = 0;
        this.outerBorderLineWidth = 0;
        makeConPts(10);

// TEST:
//        this.background = Color.LIGHT_GRAY;
//        this.innerBorderLineWidth = 0.1f;
//        this.outerBorderLineWidth = 0.1f;
//        this.outerBorderLineColorLeft   = Color.RED;
//        this.outerBorderLineColorRight  = Color.GREEN;
//        this.outerBorderLineColorBottom = Color.BLUE;
//        this.outerBorderLineColorTop    = Color.ORANGE;
//
//        this.innerBorderLineColorLeft   = Color.GREEN;
//        this.innerBorderLineColorRight  = Color.BLUE;
//        this.innerBorderLineColorBottom = Color.ORANGE;
//        this.innerBorderLineColorTop    = Color.RED;
//
//        this.innerCornerPointColorBottomLeft = Color.YELLOW;
//        this.innerCornerPointColorBottomRight = Color.PINK;
//        this.innerCornerPointColorTopLeft = Color.CYAN;
//        this.innerCornerPointColorTopRight = Color.MAGENTA;
//
//        this.outerCornerPointColorBottomLeft = Color.YELLOW;
//        this.outerCornerPointColorBottomRight = Color.PINK;
//        this.outerCornerPointColorTopLeft = Color.CYAN;
//        this.outerCornerPointColorTopRight = Color.MAGENTA;
    }
}

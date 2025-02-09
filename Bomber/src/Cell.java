import java.awt.*;

import static org.lwjgl.opengl.GL11.*;

public class Cell
implements IDrawable {

    public Color background;
    public float innerBorderLineWidth, outerBorderLineWidth;
    //public Color innerBorderLineColor, outerBorderLineColor;
    public Color innerBorderLineColorLeft, outerBorderLineColorLeft;
    public Color innerBorderLineColorRight, outerBorderLineColorRight;
    public Color innerBorderLineColorTop, outerBorderLineColorTop;
    public Color innerBorderLineColorBottom, outerBorderLineColorBottom;
    public Color innerCornerPointColorTopLeft;
    public Color innerCornerPointColorTopRight;
    public Color innerCornerPointColorBottomLeft;
    public Color innerCornerPointColorBottomRight;
    public Color outerCornerPointColorTopLeft;
    public Color outerCornerPointColorTopRight;
    public Color outerCornerPointColorBottomLeft;
    public Color outerCornerPointColorBottomRight;

    @Override
    public void draw(Graphics g) {
        drawBG(g);
        drawOuterBorder(g);
        drawInnerBorder(g);
        drawCornerPoints(g);
    }

    public Color setInnerBorderLine(float lineWidth, Color innerBorderLineColor) {
        this.innerBorderLineWidth = lineWidth;
        this.innerBorderLineColorLeft = innerBorderLineColor;
        this.innerBorderLineColorRight = innerBorderLineColor;
        this.innerBorderLineColorTop = innerBorderLineColor;
        this.innerBorderLineColorBottom = innerBorderLineColor;
        return  innerBorderLineColor;
    }
    public Color setOuterBorderLine(float lineWidth, Color outerBorderLineColor) {
        this.outerBorderLineWidth = lineWidth;
        this.outerBorderLineColorLeft = outerBorderLineColor;
        this.outerBorderLineColorRight = outerBorderLineColor;
        this.outerBorderLineColorTop = outerBorderLineColor;
        this.outerBorderLineColorBottom = outerBorderLineColor;
        return  outerBorderLineColor;
    }
    public void setOuterBorderLines(float outerBorderLineWidth,
                                    Color outerBorderLineColorLeft, Color outerBorderLineColorTop,
                                    Color outerBorderLineColorRight, Color outerBorderLineColorBottom) {
        this.outerBorderLineWidth = outerBorderLineWidth;
        this.outerBorderLineColorLeft   = outerBorderLineColorLeft;
        this.outerBorderLineColorTop    = outerBorderLineColorTop;
        this.outerBorderLineColorRight  = outerBorderLineColorRight;
        this.outerBorderLineColorBottom = outerBorderLineColorBottom;
    }
    public void setInnerBorderLines(float innerBorderLineWidth, Color innerBorderLineColor) {
        setInnerBorderLines(innerBorderLineWidth, innerBorderLineColor,
                innerBorderLineColor, innerBorderLineColor, innerBorderLineColor);
    }
    public void setInnerBorderLines(float innerBorderLineWidth,
                                    Color innerBorderLineColorLeft, Color innerBorderLineColorTop,
                                    Color innerBorderLineColorRight, Color innerBorderLineColorBottom) {
        this.innerBorderLineWidth       = innerBorderLineWidth;
        this.innerBorderLineColorLeft   = innerBorderLineColorLeft;
        this.innerBorderLineColorTop    = innerBorderLineColorTop;
        this.innerBorderLineColorRight  = innerBorderLineColorRight;
        this.innerBorderLineColorBottom = innerBorderLineColorBottom;
    }
    public Color setOuterCornerPointColor(Color outerCornerPointColor) {
        this.outerCornerPointColorTopLeft       = outerCornerPointColor;
        this.outerCornerPointColorTopRight      = outerCornerPointColor;
        this.outerCornerPointColorBottomLeft    = outerCornerPointColor;
        this.outerCornerPointColorBottomRight   = outerCornerPointColor;
        return outerCornerPointColor;
    }
    public Color setInnerCornerPointColor(Color innerCornerPointColor) {
        this.innerCornerPointColorTopLeft       = innerCornerPointColor;
        this.innerCornerPointColorTopRight      = innerCornerPointColor;
        this.innerCornerPointColorBottomLeft    = innerCornerPointColor;
        this.innerCornerPointColorBottomRight   = innerCornerPointColor;
        return innerCornerPointColor;
    }
    public void drawOuterBorder(Graphics g) {
        if(outerBorderLineWidth>0) {
            if(outerBorderLineColorLeft!=null) {
                glBegin(GL_QUADS);
                g.putColor(outerBorderLineColorLeft);
                g.putRect(0,outerBorderLineWidth, outerBorderLineWidth,1-outerBorderLineWidth);
                glEnd();
            }
            if(outerBorderLineColorRight!=null) {
                glBegin(GL_QUADS);
                g.putColor(outerBorderLineColorRight);
                g.putRect(1-outerBorderLineWidth, outerBorderLineWidth,1, 1-outerBorderLineWidth);
                glEnd();
            }
            if(outerBorderLineColorBottom!=null) {
                glBegin(GL_QUADS);
                g.putColor(outerBorderLineColorBottom);
                g.putRect(outerBorderLineWidth, 0,1-outerBorderLineWidth, outerBorderLineWidth);
                glEnd();
            }
            if(outerBorderLineColorTop!=null) {
                glBegin(GL_QUADS);
                g.putColor(outerBorderLineColorTop);
                g.putRect(outerBorderLineWidth, 1-outerBorderLineWidth,1-outerBorderLineWidth, 1);
                glEnd();
            }
        }
    }

    public void drawInnerBorder(Graphics g) {
        if(innerBorderLineWidth>0) {
            if(innerBorderLineColorLeft!=null) {
                glBegin(GL_QUADS);
                g.putColor(innerBorderLineColorLeft);
                g.putRect(innerBorderLineWidth,2*innerBorderLineWidth,
                          2*innerBorderLineWidth,1-2*innerBorderLineWidth);
                glEnd();
            }
            if(innerBorderLineColorRight!=null) {
                glBegin(GL_QUADS);
                g.putColor(innerBorderLineColorRight);
                g.putRect(1-2*innerBorderLineWidth, 2*innerBorderLineWidth,
                          1-innerBorderLineWidth, 1-2*innerBorderLineWidth);
                glEnd();
            }
            if(innerBorderLineColorBottom!=null) {
                glBegin(GL_QUADS);
                g.putColor(innerBorderLineColorBottom);
                g.putRect(2*innerBorderLineWidth, innerBorderLineWidth,
                        1-2*innerBorderLineWidth, 2*innerBorderLineWidth);
                glEnd();
            }
            if(innerBorderLineColorTop!=null) {
                glBegin(GL_QUADS);
                g.putColor(innerBorderLineColorTop);
                g.putRect(2*innerBorderLineWidth, 1-2*innerBorderLineWidth,
                        1-2*innerBorderLineWidth, 1-innerBorderLineWidth);
                glEnd();
            }
        }
    }

    public void drawCornerPoints(Graphics g) {
        if(outerBorderLineWidth>0) {
            if(outerCornerPointColorTopLeft!=null){
                glBegin(GL_QUADS);
                g.putColor(outerCornerPointColorTopLeft);
                g.putRect(0, 1-outerBorderLineWidth,outerBorderLineWidth, 1);
                glEnd();
            };
            if(outerCornerPointColorTopRight!=null){
                glBegin(GL_QUADS);
                g.putColor(outerCornerPointColorTopRight);
                g.putRect(1-outerBorderLineWidth, 1-outerBorderLineWidth,1, 1);
                glEnd();
            };
            if(outerCornerPointColorBottomLeft!=null){
                glBegin(GL_QUADS);
                g.putColor(outerCornerPointColorBottomLeft);
                g.putRect(0, 0,outerBorderLineWidth, outerBorderLineWidth);
                glEnd();
            };
            if(outerCornerPointColorBottomRight!=null){
                glBegin(GL_QUADS);
                g.putColor(outerCornerPointColorBottomRight);
                g.putRect(1-outerBorderLineWidth, 0,1, outerBorderLineWidth);
                glEnd();
            };
        }
        if(innerBorderLineWidth>0) {
            if(innerCornerPointColorTopLeft!=null){
                glBegin(GL_QUADS);
                g.putColor(innerCornerPointColorTopLeft);
                g.putRect(outerBorderLineWidth,1-2*innerBorderLineWidth,
                        2*innerBorderLineWidth,1-innerBorderLineWidth);
                glEnd();
            };
            if(innerCornerPointColorTopRight!=null){
                glBegin(GL_QUADS);
                g.putColor(innerCornerPointColorTopRight);
                g.putRect(1-2*innerBorderLineWidth, 1-2*innerBorderLineWidth,
                        1-innerBorderLineWidth, 1-innerBorderLineWidth);
                glEnd();
            };
            if(innerCornerPointColorBottomLeft!=null){
                glBegin(GL_QUADS);
                g.putColor(innerCornerPointColorBottomLeft);
                g.putRect(outerBorderLineWidth, outerBorderLineWidth,
                        outerBorderLineWidth+innerBorderLineWidth,
                        outerBorderLineWidth+innerBorderLineWidth);
                glEnd();

            };
            if(innerCornerPointColorBottomRight!=null){
                glBegin(GL_QUADS);
                g.putColor(innerCornerPointColorBottomRight);
                g.putRect(1-2*innerBorderLineWidth, innerBorderLineWidth,
                        1-innerBorderLineWidth, 2*innerBorderLineWidth);
                glEnd();
            };
        }
    }

/*    public void drawOuterBorder0(Graphics g) {
        if(outerBorderLineWidth>0 && outerBorderLineColor!=null) {
            glBegin(GL_LINE_LOOP);
            glLineWidth(1.0f);
            glColor3f(outerBorderLineColor.getRed() / 256f,
                    outerBorderLineColor.getGreen() / 256f,
                    outerBorderLineColor.getBlue() / 256f);
            g.putRect(0,0, 1,1);
            glEnd();
        }
    }
*/

    public void drawBG(Graphics g) {
        glBegin(GL_QUADS);
        glColor3f(background.getRed()/256f,
                 background.getGreen()/256f,
                 background.getBlue()/256f);

        g.putRect(0,0, 1,1);
        glEnd();
    }
}

import java.awt.*;

public class EmptyCell extends Cell {
    public EmptyCell() {
        this.background = Color.GREEN.darker();
        setInnerBorderLine(0, null);
        setOuterBorderLine(0.05f, this.background.darker());
    }
}

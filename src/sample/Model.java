package sample;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class Model {
    /**
     * Х координата
     */
    private DoubleProperty x;
    /**
     * Y координата
     */
    private DoubleProperty y;

    public Model(){
        this.x = new SimpleDoubleProperty(0);
        this.y = new SimpleDoubleProperty(0);
    }


    public double getY() {
        return y.get();
    }

    public DoubleProperty yProperty() {
        return y;
    }

    public double getX() {
        return x.get();
    }

    public DoubleProperty xProperty() {
        return x;
    }

    public void setY(double y) {
        this.y.set(y);
    }

    public void setX(double x) {
        this.x.set(x);
    }
}

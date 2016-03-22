package sample;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.chart.XYChart;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    final double xLowerBound = -20;
    final double yLowerBound = -20;
    final double xUpperBound = 20;
    final double yUpperBound = 20;

    private Model model;
    /**
     *Поле для считывания Х координаты
     */
    @FXML
    private TextField x;
    /**
     *Поле для считывания Y координаты
     */
    @FXML
    private TextField y;

    @FXML
    private Label errorLabel;

    /**
     *Координатная плоскость
     */
    @FXML
    private AreaChart coordinatePlane;

    private XYChart.Data dot = new Data(0,0);

    //private BooleanProperty isError = new SimpleBooleanProperty(true);

    public Controller(){
        this.model = new Model();
    }

    /**
     *Метод отображает заданную точку на координатной плоскости оп нажатию на кнопку
     * @param actionEvent
     */
    public void showDot(ActionEvent actionEvent) {
        if (isError()){
            errorLabel.setVisible(false);
            dot.setXValue(model.getX());
            dot.setYValue(model.getY());
        } else {
            errorLabel.setVisible(true);
        }
    }

    /**
     * Проверяет входит ли точка в заданный диапазон
     * @return
     */
    public boolean isError(){
        if((model.getX() > xUpperBound) || (model.getX() < xLowerBound) || (model.getY() < yLowerBound) ||
                (model.getY() >yUpperBound)){
            return false;
        }
        return true;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        XYChart.Series series = new XYChart.Series();
        series.getData().add(dot);
        coordinatePlane.getData().addAll(series);
        x.textProperty().addListener((observable, oldValue, newValue) -> {
            try {
                model.setX(new Double(newValue));
                errorLabel.setVisible(false);
            } catch (RuntimeException e) {
                errorLabel.setVisible(true);
            }
        });
        y.textProperty().addListener((observable, oldValue, newValue) -> {
            try {
                model.setY(new Double(newValue));
                errorLabel.setVisible(false);
            } catch (RuntimeException e) {
                errorLabel.setVisible(true);
            }
        });
    }
}

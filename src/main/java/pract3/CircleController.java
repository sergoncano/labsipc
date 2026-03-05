package pract3;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Slider;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class CircleController implements Initializable {
    @FXML
    Circle circle;

    @FXML
    ColorPicker colorPicker;

    @FXML
    ToggleButton toggleButton;

    @FXML
    Slider slider;

    GridPane gridPane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        circle.fillProperty().bind(colorPicker.valueProperty());
        circle.strokeProperty().bind(colorPicker.valueProperty());
        this.gridPane = (GridPane) circle.getParent();
        circle.radiusProperty().bind(Bindings.min(gridPane.widthProperty(), gridPane.heightProperty()).divide(5).divide(2).multiply(slider.valueProperty()));
        toggleButton.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue) {
                circle.fillProperty().unbind();
                circle.setFill(Color.TRANSPARENT);
            } else {
                circle.fillProperty().bind(colorPicker.valueProperty());
            }
        });
    }

    @FXML
    public void handleKeyPressed(KeyEvent e) {
        int sizey = gridPane.getRowCount() -1 ;
        int sizex = gridPane.getColumnCount()-1;
        int x = GridPane.getColumnIndex(circle);
        int y = GridPane.getRowIndex(circle);
        switch (e.getCode()) {
            case W:
                y--;
                if(y==-1) y += sizey + 1;
                break;
            case S:
                y++;
                if(y==sizey+1) y = 0;
                break;
            case A:
                x--;
                if(x==-1) x += sizex + 1;
                break;
            case D:
                x++;
                if(x==sizex+1) x = 0;
                break;
            default:
                break;
        }
        GridPane.setColumnIndex(circle, x);
        GridPane.setRowIndex(circle, y);
    }

    private double x;
    private double y;
    @FXML
    public void handleMousePressed(MouseEvent event) {
        x = event.getSceneX();
        y = event.getSceneY();
        System.out.println("PRESS EVENT");
    }

    @FXML
    public void handleMouseDragged(MouseEvent event) {
        circle.setTranslateX(event.getSceneX()-x);
        circle.setTranslateY(event.getSceneY()-y);
    }

    @FXML
    public void handleMouseReleased(MouseEvent event) {
        circle.setTranslateX(0);
        circle.setTranslateY(0);
        GridPane.setColumnIndex(circle, columnCalc(gridPane, (int) x));
        GridPane.setRowIndex(circle, rowCalc(gridPane,(int) y));
        event.consume();
    }

    private int columnCalc(GridPane grid, int x) {
        int cellWidth = (int) grid.getWidth() / grid.getColumnCount();
        return (int) (x/cellWidth);
    }

    private int rowCalc(GridPane grid, int y) {
        int cellHeight = (int) grid.getWidth() / grid.getRowCount();
        return (int) (y/cellHeight);
    }
}

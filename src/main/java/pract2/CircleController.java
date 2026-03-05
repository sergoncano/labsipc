package pract2;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;

public class CircleController implements Initializable {

    @FXML
    Circle circle;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    @FXML
    public void handleKeyPressed(KeyEvent e) {
        GridPane gridPane = (GridPane) circle.getParent();
        System.out.println("Event received");
        int sizey = gridPane.getRowCount() -1 ;
        int sizex = gridPane.getColumnCount()-1;
        int x = GridPane.getColumnIndex(circle);
        int y = GridPane.getRowIndex(circle);
        switch (e.getCode()) {
            case UP:
                y--;
                if(y==-1) y += sizey;
                break;
            case DOWN:
                y++;
                break;
            case LEFT:
                x--;
                if(x==-1) x += sizex;
                break;
            case RIGHT:
                x++;
                break;
            default:
                break;
        }
        GridPane.setColumnIndex(circle, x);
        GridPane.setRowIndex(circle, y);
    }
}

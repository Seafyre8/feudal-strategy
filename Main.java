import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.control.ScrollPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.scene.paint.Color;

public class Main extends Application{
    
    AnchorPane gameBoard = new AnchorPane();

    GridPane gameMap = new GridPane();

    GameEngine gameEngine = new GameEngine();

    @SuppressWarnings("unused")
    @Override
    public void start(Stage stage) {
        gameMap.setStyle("-fx-border-color: black; -fx-border-width: 2;");
        for(int i = 0; i < 30; i++){
            for(int j = 0; j < 20; j++){
                Rectangle tile = new Rectangle(48, 48);
                tile.setFill(null);
                tile.setFill(colorPicker(gameEngine.getMapTiles()[i][j]));
                tile.setStroke(Color.GRAY);
                tile.setStrokeWidth(1);
                tile.setStrokeType(StrokeType.INSIDE);
                tile.setOnMouseEntered(event -> {
                    tile.setStroke(Color.BLACK);
                    tile.setStrokeWidth(2);
                });
                tile.setOnMouseExited(event ->{
                    tile.setStroke(Color.GRAY);
                tile.setStrokeWidth(1);
                });
                gameMap.add(tile, i, j);
            }
        }
        Rectangle topBorder = new Rectangle(1476, 16);
        Rectangle leftBorder = new Rectangle(16, 960);
        Rectangle rightBorder = new Rectangle(16, 960);
        Rectangle bottomBorder = new Rectangle(1476, 32);
        gameBoard.getChildren().addAll(topBorder, leftBorder, rightBorder, bottomBorder, gameMap);
        AnchorPane.setTopAnchor(topBorder, 0.0);
        AnchorPane.setLeftAnchor(topBorder, 0.0);
        AnchorPane.setTopAnchor(leftBorder, 16.0);
        AnchorPane.setLeftAnchor(leftBorder, 0.0);
        AnchorPane.setTopAnchor(rightBorder, 16.0);
        AnchorPane.setRightAnchor(rightBorder, 0.0);
        AnchorPane.setBottomAnchor(bottomBorder, 0.0);
        AnchorPane.setLeftAnchor(bottomBorder, 0.0);
        AnchorPane.setTopAnchor(gameMap, 16.0);
        AnchorPane.setLeftAnchor(gameMap, 16.0);
        Scene scene = new Scene(gameBoard, 1476, 1008);
        stage.setScene(scene);
        stage.show();
    }

    private Color colorPicker(Tile tile){
        if(tile.getTerrain() == Terrain.PLAINS){
            return Color.CHARTREUSE;
        }
        if(tile.getTerrain() == Terrain.WATER){
            return Color.CYAN;
        }
        if(tile.getTerrain() == Terrain.FOREST){
            return Color.DARKGREEN;
        }
        if(tile.getTerrain() == Terrain.HILLS){
            return Color.PERU;
        }
        return Color.BLACK;
    }

    public static void main(String[] args) {
        launch();
    }

}

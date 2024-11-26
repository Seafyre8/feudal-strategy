import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.scene.paint.Color;

public class Main extends Application{

    BorderPane gameBoard;

    GridPane gameMap;

    GameEngine gameEngine;

    @SuppressWarnings("unused")
    @Override
    public void start(Stage stage) {
        gameBoard = new BorderPane();
        gameMap = new GridPane();
        gameEngine = new GameEngine();
        gameMap.setPrefSize(960, 640);
        gameBoard.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, null, new BorderWidths(32, 0, 64, 0))));
        for(int i = 0; i < 30; i++){
            for(int j = 0; j < 20; j++){
                Rectangle tile = new Rectangle(32, 32);
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
        gameBoard.setCenter(gameMap);
        Scene scene = new Scene(gameBoard, 960, 736);
        stage.setScene(scene);
        stage.setResizable(false);
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

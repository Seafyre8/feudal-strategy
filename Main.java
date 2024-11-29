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
    Rectangle[][] tileRectangles;

    @Override
    public void start(Stage stage) {
        gameBoard = new BorderPane();
        gameMap = new GridPane();
        gameEngine = new GameEngine();
        tileRectangles = new Rectangle[30][20];
        gameMap.setPrefSize(960, 640);
        gameBoard.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, null, new BorderWidths(32, 0, 64, 0))));
        buildMap();
        gameBoard.setCenter(gameMap);
        Scene scene = new Scene(gameBoard, 960, 736);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    private void buildMap(){
        for(int i = 0; i < 30; i++){
            for(int j = 0; j < 20; j++){
                Rectangle tile = new Rectangle(32, 32);
                tile.setFill(colorPicker(gameEngine.getMapTiles()[i][j]));
                tile.setStrokeType(StrokeType.INSIDE);
                setUpStroke(Color.GRAY, Color.BLACK, tile, false);
                gameMap.add(tile, i, j);
                tileRectangles[i][j] = tile;
            }
        }
        setUpStrokeOwner(6, 4);
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

    @SuppressWarnings("unused")
    public void updateVisuals(int xcoord, int ycoord){
        Tile tile = gameEngine.getMapTiles()[xcoord][ycoord];
        Rectangle tileRectangle = tileRectangles[xcoord][ycoord];
        if(tile.getOwner() == TileOwner.PLAYER){
            tileRectangle.setStroke(Color.GRAY);
            tileRectangle.setStrokeWidth(1);
            tileRectangle.setStrokeType(StrokeType.INSIDE);
            tileRectangle.setOnMouseEntered(event -> {
                tileRectangle.setStroke(Color.BLACK);
                tileRectangle.setStrokeWidth(2);
                });
                tileRectangle.setOnMouseExited(event ->{
                    tileRectangle.setStroke(Color.GRAY);
                    tileRectangle.setStrokeWidth(1);
                });
        }
        
    }

    private void setUpStrokeOwner(int xcoord, int ycoord){
        Tile tile = gameEngine.getMapTiles()[xcoord][ycoord];
        Rectangle tileRectangle = tileRectangles[xcoord][ycoord];
        if(tile.getOwner() == TileOwner.AI){
            setUpStroke(Color.CRIMSON, Color.DARKRED, tileRectangle, true);
        }
        if(tile.getOwner() == TileOwner.PLAYER){
            setUpStroke(Color.DODGERBLUE, Color.NAVY, tileRectangle, true);
        }
    }

    @SuppressWarnings("unused")
    private void setUpStroke(Color unhoveredColor, Color hoveredColor, Rectangle tileRectangle, boolean isClaim){
        tileRectangle.setStroke(unhoveredColor);
        // tileRectangle.setStrokeWidth(1);
        tileRectangle.setOnMouseEntered(event -> {
            tileRectangle.setStroke(hoveredColor);
            // tileRectangle.setStrokeWidth(2);
        });
        tileRectangle.setOnMouseExited(event ->{
            tileRectangle.setStroke(unhoveredColor);
            // tileRectangle.setStrokeWidth(1);
        });
        if(isClaim){
            tileRectangle.setStrokeWidth(4);
            tileRectangle.setOnMouseEntered(event -> {
                tileRectangle.setStrokeWidth(8);
            });
            tileRectangle.setOnMouseExited(event ->{
                tileRectangle.setStrokeWidth(4);
            });
        }
        else{
            tileRectangle.setStrokeWidth(1);
            tileRectangle.setOnMouseEntered(event -> {
                tileRectangle.setStrokeWidth(2);
            });
            tileRectangle.setOnMouseExited(event ->{
                tileRectangle.setStrokeWidth(1);
            });
        }
    }

    public static void main(String[] args) {
        launch();
    }

}

import java.util.ArrayList;

public class GameEngine {
    
    private Tile[][] mapTiles;
    private ArrayList<Tile> playerTiles;
    private int playerWheat;

    public GameEngine(){
        mapTiles = new Tile[10][10];
        playerTiles = new ArrayList<Tile>();
        fillMap();
        playerTiles.add(mapTiles[0][0]);
        playerWheat = 0;
    }

    private void fillMap(){
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                mapTiles[i][j] = new Tile(Terrain.PLAINS, i, j);
            }
        }
    }

    public String build(int xcoord, int ycoord, Building building){
        checkCoords(xcoord, ycoord);
        Tile tile = mapTiles[xcoord][ycoord];
        if(tile.getBuilding() != null){
            return "Building already present";
        }
        if(tile.getTerrain() == Terrain.WATER){
            return "Invalid terrain";
        }
        mapTiles[xcoord][ycoord].setBuilding(building);
        return "Building successful";
    }

    public void turn(){
        for(int i = 0; i < playerTiles.size(); i++){
            if(playerTiles.get(i).getBuilding() == Building.FARM){
                playerWheat++;
            }
        }
    }

    public Tile[][] getMapTiles() {
        return mapTiles;
    }

    public void setMapTiles(Tile[][] mapTiles) {
        this.mapTiles = mapTiles;
    }

    public ArrayList<Tile> getPlayerTiles() {
        return playerTiles;
    }

    public void setPlayerTiles(ArrayList<Tile> playerTiles) {
        this.playerTiles = playerTiles;
    }

    public int getPlayerWheat() {
        return playerWheat;
    }

    public void setPlayerWheat(int playerWheat) {
        this.playerWheat = playerWheat;
    }

    public String getTileToString(int xcoord, int ycoord){
        checkCoords(xcoord, ycoord);
        return mapTiles[xcoord][ycoord].toString();
    }

    private void checkCoords(int xcoord, int ycoord){
        if(xcoord < 0 || xcoord > mapTiles.length-1){
            throw new IllegalArgumentException("X-Coord out of bounds");
        }
        if(ycoord < 0 || ycoord > mapTiles.length-1){
            throw new IllegalArgumentException("Y-Coord out of bounds");
        }
    }

}

import java.util.HashMap;

public class GameEngine {
    
    private Tile[][] mapTiles;
    private HashMap<Building, Resource> buildingResources;
    private int playerWheat;
    private int aiWheat;

    public GameEngine(){
        mapTiles = new Tile[30][20];
        buildingResources = new HashMap<Building, Resource>();
        fillMap();
        fillResourceMap();
        mapTiles[5][5].setOwner(TileOwner.PLAYER);
        mapTiles[5][6].setOwner(TileOwner.PLAYER);
        mapTiles[5][7].setOwner(TileOwner.PLAYER);
        playerWheat = 0;
        aiWheat = 0;
    }

    private void fillMap(){
        for(int i = 0; i < 30; i++){
            for(int j = 0; j < 20; j++){
                mapTiles[i][j] = new Tile(Terrain.PLAINS, i, j);
            }
        }
        for(int i = 4; i < 12; i++){
            for(int j = 0; j < 7; j++){
                mapTiles[i][j].setTerrain(Terrain.FOREST);
            }
        }
        for(int i = 23; i < 30; i++){
            for(int j = 16; j < 20; j++){
                mapTiles[i][j].setTerrain(Terrain.WATER);
            }
        }
    }

    private void fillResourceMap(){
        buildingResources.put(Building.FARM, Resource.WHEAT);
    }

    public String build(int xcoord, int ycoord, Building building, TileOwner owner){
        checkCoords(xcoord, ycoord);
        Tile tile = mapTiles[xcoord][ycoord];
        if(tile.getBuilding() != null){
            return "Building already present";
        }
        if(tile.getTerrain() == Terrain.WATER){
            return "Invalid terrain";
        }
        if(tile.getOwner() != owner){
            return "Territory not owned";
        }
        mapTiles[xcoord][ycoord].setBuilding(building);
        return "Building successful";
    }

    public void turn(){
        for(int i = 0; i < 30; i++){
            for(int j = 0; j < 20; j++){
                Tile tile = mapTiles[i][j];
                if(tile.getBuilding() != null){
                    Resource resource = buildingResources.get(tile.getBuilding());
                    if(tile.getOwner() == TileOwner.PLAYER){
                        if(resource == Resource.WHEAT){
                            playerWheat++;
                        }
                    }
                    if(tile.getOwner()==TileOwner.AI){
                        if(resource == Resource.WHEAT){
                            aiWheat++;
                        }
                    }
                }
                
            }
        }
    }

    public HashMap<Building, Resource> getBuildingResources() {
        return buildingResources;
    }

    public void setBuildingResources(HashMap<Building, Resource> buildingResources) {
        this.buildingResources = buildingResources;
    }


    public Tile[][] getMapTiles() {
        return mapTiles;
    }

    public void setMapTiles(Tile[][] mapTiles) {
        this.mapTiles = mapTiles;
    }

    public int getPlayerWheat() {
        return playerWheat;
    }

    public void setPlayerWheat(int playerWheat) {
        this.playerWheat = playerWheat;
    }

    public int getAiWheat() {
        return aiWheat;
    }

    public void setAiWheat(int aiWheat) {
        this.aiWheat = aiWheat;
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

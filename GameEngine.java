// import java.util.HashMap;

public class GameEngine {
    
    private Tile[][] mapTiles;
    // private HashMap<Building, Resource> buildingResources;
    private int playerGold;
    private int aiGold;

    public GameEngine(){
        mapTiles = new Tile[30][20];
        // buildingResources = new HashMap<Building, Resource>();
        fillMap();
        // fillResourceMap();

        playerGold = 0;
        aiGold = 0;
    }

    private void fillMap(){
        for(int i = 0; i < 30; i++){
            for(int j = 0; j < 20; j++){
                mapTiles[i][j] = new Tile(Terrain.PLAINS, i, j);
            }
        }
        fillRegionBuilder(4, 12, 0, 3, Terrain.FOREST);
        fillRegionBuilder(23, 30, 16, 20, Terrain.WATER);
        mapTiles[6][4].setOwner(TileOwner.PLAYER);
    }

    private void fillRegionBuilder(int startx, int endx, int starty, int endy, Terrain terrain){
        for(int i = startx; i < endx; i++){
            for(int j = starty; j < endy; j++){
                mapTiles[i][j].setTerrain(terrain);
            }
        }
    }

    // private void fillResourceMap(){
    //     buildingResources.put(Building.FARM, Resource.WHEAT);
    // }

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
                    // Resource resource = buildingResources.get(tile.getBuilding());
                    if(tile.getOwner() == TileOwner.PLAYER){
                        // if(resource == Resource.WHEAT){
                            playerGold++;
                        // }
                    }
                    if(tile.getOwner()==TileOwner.AI){
                        // if(resource == Resource.WHEAT){
                            aiGold++;
                        // }
                    }
                }
                
            }
        }
    }

    // public HashMap<Building, Resource> getBuildingResources() {
    //     return buildingResources;
    // }

    // public void setBuildingResources(HashMap<Building, Resource> buildingResources) {
    //     this.buildingResources = buildingResources;
    // }


    public Tile[][] getMapTiles() {
        return mapTiles;
    }

    public void setMapTiles(Tile[][] mapTiles) {
        this.mapTiles = mapTiles;
    }

    public int getPlayerGold() {
        return playerGold;
    }

    public void setPlayerGold(int playerGold) {
        this.playerGold = playerGold;
    }

    public int getAiGold() {
        return aiGold;
    }

    public void setAiGold(int aiGold) {
        this.aiGold = aiGold;
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

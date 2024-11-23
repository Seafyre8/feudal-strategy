public class Tile{

    private Terrain terrain;
    private Building building;
    private int xcoord;
    private int ycoord;

    public Tile(Terrain terrain, int xcoord, int ycoord){
        this.terrain = terrain;
        building = null;
        this.xcoord = xcoord;
        this.ycoord = ycoord;
    }

    public Terrain getTerrain() {
        return terrain;
    }

    public void setTerrain(Terrain terrain) {
        this.terrain = terrain;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public int getXcoord() {
        return xcoord;
    }

    public void setXcoord(int xcoord) {
        this.xcoord = xcoord;
    }

    public int getYcoord() {
        return ycoord;
    }

    public void setYcoord(int ycoord) {
        this.ycoord = ycoord;
    }

    public String toString(){
        return "Terrain: "+terrain+"\nBuilding: "+building;
    }

}

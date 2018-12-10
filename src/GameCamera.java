/**
 * Allows player to move around the map
 */
public class GameCamera {

    private float xOffset, yOffset; // How far we are moving each tile when a character is moved
    private Handler handler;

    // CONSTRUCTOR
    public GameCamera(Handler handler, float xOffset, float yOffset) {
        this.xOffset = xOffset;
        this.yOffset = yOffset;
        this.handler = handler;
    }

    /**
     * Check to see if the camera is displaying any blank space (off map)
     */
    public void checkBlankSpace(){

        // Check Left
        if (xOffset < 0) {
            xOffset = 0;
        }

        // Check Right
        else if (xOffset > handler.getWorld().getWidth() * Tile.TILE_WIDTH - handler.getWidth()){
            xOffset = handler.getWorld().getWidth() * Tile.TILE_WIDTH - handler.getWidth();
        }

        // Check Top
        if (yOffset < 0) {
            yOffset = 0;
        }

        // Check Bottom
        else if (yOffset > handler.getWorld().getHeight() * Tile.TILE_HEIGHT - handler.getHeight()){
            yOffset = handler.getWorld().getHeight() * Tile.TILE_HEIGHT - handler.getHeight();
        }
    }

    /**
     * Sets the x and y offsets to the entity (player)
     * @param e
     */
    public void centerOnEntity(Entity e){
        xOffset = e.getX() - handler.getWidth() / 2 +  e.getWidth()/2;
        yOffset = e.getY() - handler.getHeight() / 2 + e.getHeight()/2;
        checkBlankSpace();
    }

    /**
     * Used to actually move each tile
     * @param xAmt amount to move each tile in x plane
     * @param yAmt amount to move each tile in y plane
     */
    public void move(float xAmt, float yAmt){
        xOffset += xAmt;
        yOffset -= yAmt;
        checkBlankSpace();
    }

    //GETTERS AND SETTERS
    public float getxOffset() {
        return xOffset;
    }
    public void setxOffset(float xOffset) {
        this.xOffset = xOffset;
    }
    public float getyOffset() {
        return yOffset;
    }
    public void setyOffset(float yOffset) {
        this.yOffset = yOffset;
    }
}

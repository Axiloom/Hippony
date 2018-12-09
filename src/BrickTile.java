import java.awt.image.BufferedImage;

public class BrickTile extends Tile {

  public BrickTile(int id) {
    super(Assets.brick, id);
  }

  @Override
  public boolean isWalkable() {
    return true;
  }
}

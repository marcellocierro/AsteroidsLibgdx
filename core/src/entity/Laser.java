package entity;

import com.badlogic.gdx.math.Vector2;
import com.spaceinvaders.invaders.MainGame;
import com.spaceinvaders.invaders.TextureManager;

/**
 * Created by Marcello395 on 1/25/18.
 */
public class Laser extends Entity {

    public Laser(Vector2 position) {
        super(TextureManager.LASER, position, new Vector2(0,5 ));
    }

    @Override
    public void update() {
        position.add(direction);
    }

    public boolean checkEnd(){
        return position.y >= MainGame.HEIGHT;
    }
}

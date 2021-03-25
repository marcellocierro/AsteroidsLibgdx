package entity;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.spaceinvaders.invaders.MainGame;
import com.spaceinvaders.invaders.TextureManager;

/**
 * Created by Marcello395 on 1/25/18.
 */
public class MeteorBig extends Entity {

    public MeteorBig(Vector2 position, Vector2 direction) {
        super(TextureManager.METEORBIG, position, direction);
    }

    @Override
    public void update() {
        position.add(direction);
        if(position.y <= -TextureManager.METEORBIG.getHeight()) {
            float x = MathUtils.random(0, MainGame.WIDTH - TextureManager.METEORBIG.getWidth());
            position.set(x, MainGame.HEIGHT);
        }
    }
}

package entity;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.spaceinvaders.invaders.MainGame;
import com.spaceinvaders.invaders.TextureManager;

/**
 * Created by Marcello395 on 1/25/18.
 */
public class MeteorMedium extends Entity {

    public MeteorMedium(Vector2 position, Vector2 direction) {
        super(TextureManager.METEORMED, position, direction);
    }

    @Override
    public void update() {
        position.add(direction);
        if(position.y <= -TextureManager.METEORMED.getHeight()) {
            float x = MathUtils.random(0, MainGame.WIDTH - TextureManager.METEORMED.getWidth());
            position.set(x, MainGame.HEIGHT);
        }
    }
}

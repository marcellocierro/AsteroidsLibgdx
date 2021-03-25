package entity;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.spaceinvaders.invaders.MainGame;
import com.spaceinvaders.invaders.TextureManager;

/**
 * Created by Marcello395 on 11/20/17.
 */
public class EnemyBlue extends Entity {

    public EnemyBlue(Vector2 position, Vector2 direction) {

        super(TextureManager.ENEMYBLUE, position, direction);
    }

    @Override
    public void update() {
        position.add(direction);
        if(position.y <= -TextureManager.ENEMYBLUE.getHeight()){
            float x = MathUtils.random(0, MainGame.WIDTH - TextureManager.ENEMYBLUE.getWidth());
            position.set(x, MainGame.HEIGHT);

        }
    }
}

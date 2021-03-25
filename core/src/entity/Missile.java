package entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.spaceinvaders.invaders.MainGame;
import com.spaceinvaders.invaders.TextureManager;

/**
 * Created by Marcello395 on 1/24/18.
 */
public class Missile extends Entity {


    public Missile(Vector2 position) {
        super(TextureManager.MISSILE, position, new Vector2(0,5 ));
    }

    @Override
    public void update() {
        position.add(direction);
    }

    public boolean checkEnd(){
        return position.y >= MainGame.HEIGHT;
    }


}

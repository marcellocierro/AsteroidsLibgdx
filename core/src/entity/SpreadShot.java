package entity;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.spaceinvaders.invaders.MainGame;
import com.spaceinvaders.invaders.TextureManager;

/**
 * Created by Marcello395 on 1/25/18.
 */
public class SpreadShot extends Entity {

        public SpreadShot(Vector2 position) {
            super(TextureManager.SPREADSHOT, position, new Vector2(MathUtils.random(-10, 10),5 ));
        }

        @Override
        public void update() {
            position.add(direction);
        }

        public boolean checkEnd(){
            return position.y >= MainGame.HEIGHT;
        }
    }

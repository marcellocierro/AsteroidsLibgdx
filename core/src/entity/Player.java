package entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.spaceinvaders.invaders.TextureManager;
import screen.GameOverScreen;
import screen.GameScreen;
import screen.ScreenManager;

/**
 * Created by Marcello395 on 11/20/17.
 */
public class Player extends Entity {

    private final EntityManager entityManager;
    private long lastFire;

    public Player(Vector2 position, Vector2 direction, EntityManager entityManager) {
        super(TextureManager.PlAYER, position, direction);
        this.entityManager = entityManager;
    }

    @Override
    public void update() {
        position.add(direction);

        if (Gdx.input.isKeyPressed(Input.Keys.W) && Gdx.input.isKeyPressed(Input.Keys.A)){
            setDirection(-500, 500);
        }
        else if (Gdx.input.isKeyPressed(Input.Keys.W) && Gdx.input.isKeyPressed(Input.Keys.D)){
            setDirection(500, 500);
        }
        else if (Gdx.input.isKeyPressed(Input.Keys.S) && Gdx.input.isKeyPressed(Input.Keys.A)){
            setDirection(-500, -500);
        }
        else if (Gdx.input.isKeyPressed(Input.Keys.S) && Gdx.input.isKeyPressed(Input.Keys.D)){
            setDirection(500, -500);
        }
        else if (Gdx.input.isKeyPressed(Input.Keys.A)){
            setDirection(-1000, 0);
        }
        else if (Gdx.input.isKeyPressed(Input.Keys.D)){
            setDirection(1000, 0);
        }
        else if (Gdx.input.isKeyPressed(Input.Keys.W)){
            setDirection(0, 1000);
        }
        else if (Gdx.input.isKeyPressed(Input.Keys.S)){
            setDirection(0, -1000);
        }
        else {
            setDirection(0,0);
        }

        if (Gdx.input.isKeyPressed(Input.Keys.J)){
            if(System.currentTimeMillis() - lastFire >= 250){
                entityManager.addEntity(new Missile(position.cpy().add(0,TextureManager.PlAYER.getHeight() - 25)));
                entityManager.addEntity(new Missile(position.cpy().add(50,TextureManager.PlAYER.getHeight())));
                entityManager.addEntity(new Missile(position.cpy().add(100,TextureManager.PlAYER.getHeight() - 25)));
                lastFire = System.currentTimeMillis();
            }
        }

        if (Gdx.input.isKeyPressed(Input.Keys.L)){
            if(System.currentTimeMillis() - lastFire >= 0){
                entityManager.addEntity(new Laser(position.cpy().add(50,TextureManager.PlAYER.getHeight())));
                //entityManager.addEntity(new Missile(position.cpy().add(100,TextureManager.PlAYER.getHeight())));
                lastFire = System.currentTimeMillis();
            }
        }

        if (Gdx.input.isKeyPressed(Input.Keys.K)){
            if(System.currentTimeMillis() - lastFire >= 20){
                entityManager.addEntity(new SpreadShot(position.cpy().add(40,TextureManager.PlAYER.getHeight())));
                //entityManager.addEntity(new Missile(position.cpy().add(100,TextureManager.PlAYER.getHeight())));
                lastFire = System.currentTimeMillis();
            }
        }

    }

}

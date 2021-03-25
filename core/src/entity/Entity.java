package entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Marcello395 on 11/20/17.
 */
public abstract class Entity {

    protected Texture texture;
    protected Vector2 position, direction;

    public Entity(Texture texture, Vector2 position, Vector2 direction){
        this.texture = texture;
        this.position = position;
        this.direction = direction;
    }

    public abstract void update();

    public void render(SpriteBatch sb){
        //System.out.println("Render");
        sb.draw(texture, position.x, position.y);
    }


    public void setDirection(float x, float y){
        direction.set(x, y);
        direction.scl(Gdx.graphics.getDeltaTime());
    }

    public Vector2 getDirection() {
        return direction;
    }

    public Vector2 getPosition() {
        return position;
    }

    public Rectangle getBounds(){
        return new Rectangle(position.x, position.y, texture.getWidth(), texture.getHeight());

    }
}

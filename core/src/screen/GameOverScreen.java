package screen;

import camera.OrthoCamera;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.spaceinvaders.invaders.MainGame;
import com.spaceinvaders.invaders.TextureManager;
import entity.EntityManager;

/**
 * Created by Marcello395 on 1/24/18.
 */
public class GameOverScreen extends Screen {

    private OrthoCamera camera;
    private EntityManager entityManager;

    private Texture texture;

    FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("KenneyFutureNarrow.ttf"));
    FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
    BitmapFont font13 = generator.generateFont(parameter);

    public GameOverScreen(boolean won){
        if(won){
            texture = TextureManager.GAMEWON;
        }else{
            texture = TextureManager.GAMEOVER;
        }
    }

    @Override
    public void create() {
        camera = new OrthoCamera();
        camera.resize();


    }

    @Override
    public void update() {
        camera.update();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(camera.combined);
        sb.begin();
        sb.draw(texture, MainGame.WIDTH / 2 - texture.getWidth() / 2 , MainGame.HEIGHT / 2 - texture.getHeight() / 2);
        sb.end();
    }


    @Override
    public void resize(int width, int height) {
        camera.resize();
    }

    @Override
    public void dispose() {
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

}

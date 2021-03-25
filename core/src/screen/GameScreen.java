package screen;

import camera.OrthoCamera;
import camera.VirtualViewport;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.spaceinvaders.invaders.MainGame;
import com.spaceinvaders.invaders.TextureManager;
import entity.EnemyBlue;
import entity.EntityManager;

/**
 * Created by Marcello395 on 11/17/17.
 */
public class GameScreen extends Screen {

    private OrthoCamera camera;
    //private Player player;
    //private EnemyBlue enemyBlue;
    private EntityManager entityManager;


    FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("KenneyFutureNarrow.ttf"));
    FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
    BitmapFont font12 = generator.generateFont(parameter);
    //FreeTypeFontGenerator= 12 // font size


    //generator.dispose(); // avoid memory leaks, important

//    FreeTypeFontGenerator generator = new FreeTypeFontGenerator(fontFile);
//    FreeTypeFontGenerator.FreeTypeBitmapFontData font15 = generator.generateData(15);
//    FreeTypeFontGenerator.FreeTypeBitmapFontData font22 = generator.generateData(22);
//    //generator.dispose();


    //private Texture texture = TextureManager.BACKGROUND;


    @Override
    public void create() {
        camera = new OrthoCamera();
        //player = new Player(new Vector2(230, 15), new Vector2(0,0));
        //enemyBlue = new EnemyBlue(new Vector2(230, 200), new Vector2(0,0));
        //entityManager = new EnemyBlue(10);
        entityManager = new EntityManager(10, 6, 100, 2, 5, 50);
//        entityManager = new EntityManager(10, 0, 0, 10, 0, 0);
//        entityManager = new EntityManager(10, 10, 10, 0, 0, 0);
    }

    @Override
    public void update(){
        camera.update();
        entityManager.update();
        //player.update();
    }


    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(camera.combined);
        sb.begin();
        //scoreRender(sb);
        //sb.draw(TextureManager.GAMEWON, MainGame.WIDTH / 2 - TextureManager.GAMEWON.getWidth() / 2 , MainGame.HEIGHT / 2 - TextureManager.GAMEWON.getHeight() / 2);
        sb.draw(TextureManager.BACKGROUND, MainGame.WIDTH / 10 - TextureManager.BACKGROUND.getWidth() / 2, MainGame.HEIGHT / 7 - TextureManager.BACKGROUND.getHeight() / 2,1400, 1000);
        //sb.draw(TextureManager.BACKGROUND, 0, 0, )
        entityManager.render(sb);
        font12.draw(sb, entityManager.getScore(), 10, 20);
        //player.render(sb);
//        parameter.size = 20;
//        BitmapFont font12 = generator.generateFont(parameter);
//        font12.draw(sb, entityManager.getScore(), 10, 20);

        //scoreFont.draw(sb, entityManager.getScore(), 10, 20);
        sb.end();
    }

    @Override
    public void resize(int width, int height) {
        camera.resize();
        System.out.println("Resize");

    }

    @Override
    public void dispose() {
        generator.dispose();
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {

    }
}

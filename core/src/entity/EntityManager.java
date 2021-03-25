package entity;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.spaceinvaders.invaders.MainGame;
import com.spaceinvaders.invaders.TextureManager;
import screen.GameOverScreen;
import screen.ScreenManager;

/**
 * Created by Marcello395 on 11/20/17.
 */
public class EntityManager {

    private final Array<Entity> entities = new Array<Entity>();
    private final Player player;
    public int score = 0;
    public int highScore = 0;

    public EntityManager(int enemyBlueAmount, int enemyGreenAmount, int enemyRedAmount, int bigMeteorAmount, int medMeteorAmount, int smallMeteorAmount) {
        player = new Player(new Vector2(300, 15), new Vector2(0, 0), this);
        for (int i = 0; i < enemyBlueAmount; i++) {
            float x = MathUtils.random(0, MainGame.WIDTH - TextureManager.ENEMYBLUE.getWidth());
            float y = MathUtils.random(MainGame.HEIGHT, MainGame.HEIGHT * 3);
            float speed = MathUtils.random(2, 7);
            addEntity(new EnemyBlue(new Vector2(x, y), new Vector2(0, -speed)));
        }
        for (int i = 0; i < enemyGreenAmount; i++) {
            float x = MathUtils.random(0, MainGame.WIDTH - TextureManager.ENEMYGREEN.getWidth());
            float y = MathUtils.random(MainGame.HEIGHT, MainGame.HEIGHT * 3);
            float speed = 15;
            addEntity(new EnemyGreen(new Vector2(x, y), new Vector2(0, -speed)));
        }
        for (int i = 0; i < enemyRedAmount; i++) {
            float x = MathUtils.random(0, MainGame.WIDTH - TextureManager.ENEMYRED.getWidth());
            float y = MainGame.HEIGHT - 100;
            float speed = 1;
            addEntity(new EnemyRed(new Vector2(x, y), new Vector2(0, -speed)));
        }
        for (int i = 0; i < bigMeteorAmount; i++) {
            float x = MathUtils.random(0, MainGame.WIDTH - TextureManager.METEORBIG.getWidth());
            float y = MathUtils.random(MainGame.HEIGHT, MainGame.HEIGHT * 3);
            float speed = MathUtils.random(1, 2);
            addEntity(new MeteorBig(new Vector2(x, y), new Vector2(0, -speed)));
        }
        for (int i = 0; i < medMeteorAmount; i++) {
            float x = MathUtils.random(0, MainGame.WIDTH - TextureManager.METEORMED.getWidth());
            float y = MathUtils.random(MainGame.HEIGHT, MainGame.HEIGHT * 3);
            float speed = MathUtils.random(2, 3);
            addEntity(new MeteorMedium(new Vector2(x, y), new Vector2(0, -speed)));
        }
        for (int i = 0; i < smallMeteorAmount; i++) {
            float x = MathUtils.random(0, MainGame.WIDTH - TextureManager.METEORSMALL.getWidth());
            float y = MathUtils.random(MainGame.HEIGHT, MainGame.HEIGHT * 3);
            float speed = MathUtils.random(3, 6);
            addEntity(new MeteorSmall(new Vector2(x, y), new Vector2(0, -speed)));
        }
    }


    public void update() {
        for (Entity e : entities) {
            e.update();
        }
        for (Missile m : getMissile()) {
            if (m.checkEnd()) {
                entities.removeValue(m, false);
            }
        }
        player.update();
        checkEnemyCollisions();
        checkMeteorCollisions();
    }

    public void render(SpriteBatch sb) {

        for (Entity e : entities) {
            e.render(sb);
        }
        player.render(sb);

    }


    private void checkEnemyCollisions() {
        for (EnemyBlue eb : getEnemiesBlue()) {
            for (Missile m : getMissile()) {
                if (eb.getBounds().overlaps(m.getBounds())) {
                    entities.removeValue(eb, false);
                    entities.removeValue(m, false);
                    score++;
                    if (score > highScore) {
                        highScore = score;
                    }
                    if (gameOver()) {
                        ScreenManager.setScreen(new GameOverScreen(true));
                        ScreenManager.getCurrent_screen().dispose();
                    }
                }
            }

            for (SpreadShot ss : getSpreadShot()) {
                if (eb.getBounds().overlaps(ss.getBounds())) {
                    entities.removeValue(ss, false);
                }
            }

            for (Laser l : getLaser()) {
                if (eb.getBounds().overlaps(l.getBounds())) {
                    entities.removeValue(l, false);
                }
            }

            if (eb.getBounds().overlaps(player.getBounds())) {
                ScreenManager.setScreen(new GameOverScreen(false));
                ScreenManager.getCurrent_screen().dispose();
            }
        }

        for (EnemyGreen eg : getEnemiesGreen()) {
            for (SpreadShot ss : getSpreadShot()) {
                if (eg.getBounds().overlaps(ss.getBounds())) {
                    entities.removeValue(eg, false);
                    entities.removeValue(ss, false);
                    score++;
                    if (score > highScore) {
                        highScore = score;
                    }
                }
            }

            for (Missile m : getMissile()) {
                if (eg.getBounds().overlaps(m.getBounds())) {
                    entities.removeValue(m, false);
                }
            }

            for (Laser l : getLaser()) {
                if (eg.getBounds().overlaps(l.getBounds())) {
                    entities.removeValue(l, false);
                }
            }

            if (eg.getBounds().overlaps(player.getBounds())) {
                ScreenManager.setScreen(new GameOverScreen(false));
                ScreenManager.getCurrent_screen().dispose();
            }
        }

        for (EnemyRed er : getEnemiesRed()) {
            for (Laser l : getLaser()) {
                if (er.getBounds().overlaps(l.getBounds())) {
                    entities.removeValue(er, false);
                    entities.removeValue(l, false);
                    score++;
                    if (score > highScore) {
                        highScore = score;
                    }
                }
            }

            for (Missile m : getMissile()) {
                if (er.getBounds().overlaps(m.getBounds())) {
                    entities.removeValue(m, false);
                }
            }

            for (SpreadShot ss : getSpreadShot()) {
                if (er.getBounds().overlaps(ss.getBounds())) {
                    entities.removeValue(ss, false);
                }
            }

            if (er.getBounds().overlaps(player.getBounds())) {
                ScreenManager.setScreen(new GameOverScreen(false));
                ScreenManager.getCurrent_screen().dispose();
            }
        }

    }


    private void checkMeteorCollisions() {
        for (MeteorBig mb : getMeteorBig()) {
            for (Missile m : getMissile()) {
                if (mb.getBounds().overlaps(m.getBounds())) {
                    entities.removeValue(m, false);
                }
            }
            for (Laser l : getLaser()) {
                if (mb.getBounds().overlaps(l.getBounds())) {
                    entities.removeValue(l, false);
                }
            }
            for (SpreadShot ss : getSpreadShot()) {
                if (mb.getBounds().overlaps(ss.getBounds())) {
                    entities.removeValue(ss, false);
                }
            }

            if (mb.getBounds().overlaps(player.getBounds())) {
                ScreenManager.setScreen(new GameOverScreen(false));
                ScreenManager.getCurrent_screen().dispose();
            }
        }
        for (MeteorMedium mm : getMeteorMed()) {
            for (Missile m : getMissile()) {
                if (mm.getBounds().overlaps(m.getBounds())) {
                    entities.removeValue(mm, false);
                    entities.removeValue(m, false);
                    score++;
                    if (score > highScore) {
                        highScore = score;
                    }

                }
            }

            for (SpreadShot ss : getSpreadShot()) {
                if (mm.getBounds().overlaps(ss.getBounds())) {
                    entities.removeValue(ss, false);
                    score++;
                    if (score > highScore) {
                        highScore = score;
                    }
                }
            }

            for (Laser l : getLaser()) {
                if (mm.getBounds().overlaps(l.getBounds())) {
                    entities.removeValue(l, false);
                }
            }


            if (mm.getBounds().overlaps(player.getBounds())) {
                ScreenManager.setScreen(new GameOverScreen(false));
                ScreenManager.getCurrent_screen().dispose();
            }
        }


        for (MeteorSmall ms : getMeteorSmall()) {
            for (Missile m : getMissile()) {
                if (ms.getBounds().overlaps(m.getBounds())) {
                    entities.removeValue(ms, false);
                    score++;
                    if (score > highScore) {
                        highScore = score;
                    }
                }
            }

            for (SpreadShot ss : getSpreadShot()) {
                if (ms.getBounds().overlaps(ss.getBounds())) {
                    entities.removeValue(ms, false);
                    score++;
                    if (score > highScore) {
                        highScore = score;
                    }
                }
            }

            for (Laser l : getLaser()) {
                if (ms.getBounds().overlaps(l.getBounds())) {
                    entities.removeValue(l, false);
                }
            }
            if (ms.getBounds().overlaps(player.getBounds())) {
                ScreenManager.setScreen(new GameOverScreen(false));
                ScreenManager.getCurrent_screen().dispose();
            }
        }

    }

    public void addEntity(Entity entity) {
        entities.add(entity);
    }

    private Array<EnemyBlue> getEnemiesBlue() {
        Array<EnemyBlue> ret = new Array<EnemyBlue>();
        for (Entity e : entities) {
            if (e instanceof EnemyBlue) {
                ret.add((EnemyBlue) e);
            }
        }
        return ret;
    }

    private Array<EnemyGreen> getEnemiesGreen() {
        Array<EnemyGreen> ret = new Array<EnemyGreen>();
        for (Entity e : entities) {
            if (e instanceof EnemyGreen) {
                ret.add((EnemyGreen) e);
            }
        }
        return ret;
    }

    private Array<EnemyRed> getEnemiesRed() {
        Array<EnemyRed> ret = new Array<EnemyRed>();
        for (Entity e : entities) {
            if (e instanceof EnemyRed) {
                ret.add((EnemyRed) e);
            }
        }
        return ret;
    }

    private Array<Missile> getMissile() {
        Array<Missile> ret = new Array<Missile>();
        for (Entity e : entities) {
            if (e instanceof Missile) {
                ret.add((Missile) e);
            }
        }
        return ret;
    }

    private Array<Laser> getLaser() {
        Array<Laser> ret = new Array<Laser>();
        for (Entity e : entities) {
            if (e instanceof Laser) {
                ret.add((Laser) e);
            }
        }
        return ret;
    }

    private Array<SpreadShot> getSpreadShot() {
        Array<SpreadShot> ret = new Array<SpreadShot>();
        for (Entity e : entities) {
            if (e instanceof SpreadShot) {
                ret.add((SpreadShot) e);
            }
        }
        return ret;
    }

    private Array<MeteorBig> getMeteorBig() {
        Array<MeteorBig> ret = new Array<MeteorBig>();
        for (Entity e : entities) {
            if (e instanceof MeteorBig) {
                ret.add((MeteorBig) e);
            }
        }
        return ret;
    }

    private Array<MeteorMedium> getMeteorMed() {
        Array<MeteorMedium> ret = new Array<MeteorMedium>();
        for (Entity e : entities) {
            if (e instanceof MeteorMedium) {
                ret.add((MeteorMedium) e);
            }
        }
        return ret;
    }

    private Array<MeteorSmall> getMeteorSmall() {
        Array<MeteorSmall> ret = new Array<MeteorSmall>();
        for (Entity e : entities) {
            if (e instanceof MeteorSmall) {
                ret.add((MeteorSmall) e);
            }
        }
        return ret;
    }

    public String getScore() {
        return Integer.toString(score);
    }

    public String getHighscore() {
        return Integer.toString(highScore);
    }

    public boolean gameOver() {
        return getEnemiesBlue().size <= 0;

    }

}

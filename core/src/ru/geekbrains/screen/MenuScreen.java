package ru.geekbrains.screen;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.base.BaseScreen;
import ru.geekbrains.math.Rect;
import ru.geekbrains.sprite.Background;
import ru.geekbrains.sprite.Logo;

public class MenuScreen extends BaseScreen {

    float SPEED = 0.1f;

    private Texture img;
    private Texture bg;
    private Background background;
    private Logo badlogic;

    private Vector2 newTouch;
    private Vector2 distance;

    @Override
    public void show() {
        super.show();
        img = new Texture("badlogic.jpg");
        bg = new Texture("textures/bg.png");
        background = new Background(bg);
        badlogic = new Logo(img);

        newTouch = new Vector2();
        distance = new Vector2();

    }

    @Override
    public void resize(Rect worldBounds) {
        background.resize(worldBounds);
        badlogic.resize(worldBounds);
    }

    @Override
    public void render(float delta) {
        super.render(delta);

        distance.set(newTouch);
        distance.sub(badlogic.pos);
        if (distance.len() >= 0.01f) { badlogic.pos.add( distance.scl(SPEED) ); }
        batch.begin();
        background.draw(batch);
        badlogic.draw(batch);
        batch.end();
    }

    public boolean touchDown(Vector2 touch, int pointer, int button) {
        newTouch.set(touch);
        return false;
    }

    @Override
    public void dispose() {
        img.dispose();
        bg.dispose();
        super.dispose();
    }

}
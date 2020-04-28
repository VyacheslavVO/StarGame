package ru.geekbrains.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.base.BaseScreen;

public class MenuScreen extends BaseScreen {

    private Texture img;
    private Vector2 pos;
    private Vector2 v;
    private Vector2 touch;

    @Override
    public void show() {
        super.show();
        img = new Texture("badlogic.jpg");
        pos = new Vector2();
        v = new Vector2();
        touch = new Vector2();
    }

    @Override
    public void render(float delta) {
        super.render(delta);

        if (enMoveImage01(pos, touch)) pos.add(v);

        batch.begin();
        batch.draw(img, pos.x, pos.y);
        batch.end();
    }

    @Override
    public void dispose() {
        img.dispose();
        super.dispose();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        Vector2 _touch = new Vector2();
        touch.set(screenX, Gdx.graphics.getHeight() - screenY);
        _touch.set(touch);
        v.set(_touch.sub(pos));
        v.nor();
        return super.touchDown(screenX, screenY, pointer, button);
    }

    private boolean enMoveImage01(Vector2 _pos, Vector2 _touch)
    {
        Vector2 _move = new Vector2();
        _move.set(_touch);
        _move.sub(_pos);
        if (_move.len() <= 1.0f)  return false;
        else return true;
    }
}

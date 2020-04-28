package ru.geekbrains.base;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class BaseScreen implements Screen, InputProcessor {

    protected SpriteBatch batch;

    @Override
    // Срабатывает первый после конструктора (аналог метода Create)
    public void show() {
        System.out.println("show");
        Gdx.input.setInputProcessor(this);
        batch = new SpriteBatch();
    }

    @Override
    // Срабатывает 60 раз в сек. delta - отрезок времени между срабатываниями
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

    @Override
    // Срабатывает в начале когда устанавливается размер экрна и когда изменили размер экрана
    public void resize(int width, int height) {
        //System.out.println("resize width = " + width + " height = " + height);
    }

    @Override
    // Срабатывает когда свернули приложение
    public void pause() {
        //System.out.println("pause");
    }

    @Override
    // Срабатывает когда развернули приложение
    public void resume() {
        //System.out.println("resume");
    }

    @Override
    // Срабатывает когда мы приложение закрываем или закрываем экран
    public void hide() {
        //System.out.println("hide");
        dispose();
    }

    @Override
    // Деструктор, очищение ресурсов памяти
    public void dispose() {
        //System.out.println("dispose");
        batch.dispose();
    }

    @Override
    // Событие нажатия клавиши
    public boolean keyDown(int keycode) {
        //System.out.println("keyDown keycode = " + keycode);
        return false;
    }

    @Override
    // Событие отпускания клавиши
    public boolean keyUp(int keycode) {
        //System.out.println("keyUp keycode = " + keycode);
        return false;
    }

    @Override
    // Событие самоого факта наличие срабатывания клавиши
    public boolean keyTyped(char character) {
        //System.out.println("keyTyped character = " + character);
        return false;
    }

    @Override
    // Событие начало клика мышкой на экране или тап пальцем на экране
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        //System.out.println("touchDown screenX = " + screenX + " screenY = " + screenY);
        return false;
    }

    @Override
    // Событие конец клика мышкой на экране или тап пальцем на экране
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        //System.out.println("touchUp screenX = " + screenX + " screenY = " + screenY);
        return false;
    }

    @Override
    // Событие когда нажали в одной точке на экране, протащили, отпустили в другой точке
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        //System.out.println("touchDragged screenX = " + screenX + " screenY = " + screenY);
        return false;
    }

    @Override
    // Срабатывает при любом движении мыши
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    // Срабатывает при прокрутке колесика мыши. amount возвращает 1 или -1, это направление прокрутки
    public boolean scrolled(int amount) {
        //System.out.println("scrolled amount = " + amount);
        return false;
    }
}

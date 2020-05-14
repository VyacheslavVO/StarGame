package ru.geekbrains.sprite;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import ru.geekbrains.base.Sprite;
import ru.geekbrains.math.Rect;

public class MainShip extends Sprite {

    private static final float MARGIN = 0.1f;
    TextureRegion textureRegion;

    public MainShip(TextureAtlas atlas) {
        super(atlas.findRegion("main_ship"));
    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(0.2f);
        setBottom(worldBounds.getBottom() + MARGIN);
    }

    @Override
    public void update(float delta) {

    }
}

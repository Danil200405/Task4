package com.cgvsu.affineTransformation.affineComposite;

import com.cgvsu.affineTransformation.affineComposite.AffineComposite;
import com.cgvsu.math.Matrix4f;

public class Translate implements AffineComposite {
    private Matrix4f translationMatrix;

    public Translate(float dx, float dy, float dz) {
        translationMatrix = new Matrix4f(new float[][]{
                {1, 0, 0, dx},
                {0, 1, 0, dy},
                {0, 0, 1, dz},
                {0, 0, 0, 1}});
    }

    @Override
    public void applyTransform(Matrix4f m) {
        m.multiplyThis(translationMatrix);
    }
}

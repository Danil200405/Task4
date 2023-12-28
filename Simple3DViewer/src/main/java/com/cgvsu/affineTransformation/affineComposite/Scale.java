package com.cgvsu.affineTransformation.affineComposite;

import com.cgvsu.affineTransformation.affineComposite.AffineComposite;
import com.cgvsu.math.Matrix4f;

public class Scale implements AffineComposite {
    private Matrix4f scaleMatrix;

    public Scale(float sX, float sY, float sZ) {
        scaleMatrix = new Matrix4f(new float[][]{
                {sX, 0, 0, 0},
                {0, sY, 0, 0},
                {0, 0, sZ, 0},
                {0, 0, 0, 1}
        });
    }

    @Override
    public void applyTransform(Matrix4f m) {
        m.multiplyThis(scaleMatrix);
    }
}

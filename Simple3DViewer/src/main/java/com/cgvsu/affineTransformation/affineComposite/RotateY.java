package com.cgvsu.affineTransformation.affineComposite;

import com.cgvsu.affineTransformation.affineComposite.AffineComposite;
import com.cgvsu.math.Matrix4f;

public class RotateY implements AffineComposite {
    private Matrix4f rotationMatrix;
    public RotateY(double thetaY) {
        rotationMatrix = new Matrix4f(new float[][]{
                {(float) Math.cos(thetaY), 0, (float) Math.sin(thetaY), 0},
                {0, 1, 0, 0},
                {(float) -Math.sin(thetaY), 0, (float) Math.cos(thetaY), 0},
                {0, 0, 0, 1}
        });
    }

    @Override
    public void applyTransform(Matrix4f m) {
        m.multiplyThis(rotationMatrix);
    }
}

package com.cgvsu.affineTransformation.affineComposite;

import com.cgvsu.affineTransformation.AffineApplier;
import com.cgvsu.math.Matrix4f;
import com.cgvsu.math.Vector3f;
import com.cgvsu.math.Vector4f;

import java.util.ArrayList;
import java.util.List;

public class Affine implements AffineComposite {
    List<AffineComposite> affineComposites = new ArrayList<>();
    private Matrix4f base;
    public Affine() {
        base = new Matrix4f(new float[][]{
                {1, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1}});
    }

    public void add(AffineComposite af) {
        affineComposites.add(af);
    }

    @Override
    public void applyTransform(Matrix4f m) {
        for (int i = affineComposites.size() - 1; i >= 0; i--) {
            affineComposites.get(i).applyTransform(m);
        }
    }

    public AffineApplier createApplier() {
        Matrix4f affineTransform = new Matrix4f(base);
        applyTransform(affineTransform);
        return new AffineApplier(affineTransform);
    }

    public Vector3f applyAffineToVector(Vector3f v) {
        Matrix4f affineTransform = new Matrix4f(base);
        applyTransform(affineTransform);

        Vector4f v4 = new Vector4f(v.getX(), v.getY(), v.getZ(), 1);
        Vector4f result = affineTransform.multiply(v4);
        return new Vector3f(result.getX(), result.getY(), result.getZ());
    }
}

package com.cgvsu.affineTransformation.affineComposite;

import com.cgvsu.math.Matrix4f;

public interface AffineComposite {
    void applyTransform(Matrix4f m);
}

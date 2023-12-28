package com.cgvsu.affineTransformation;

import com.cgvsu.math.Matrix4f;
import com.cgvsu.math.Vector3f;
import com.cgvsu.math.Vector4f;
import com.cgvsu.model.Model;

import java.util.ArrayList;

public class AffineApplier {
    Matrix4f affineMatrix;
    public AffineApplier(Matrix4f affineMatrix) {
        this.affineMatrix = affineMatrix;
    }

    public void apply(Model model) {
        ArrayList<Vector3f> resultVertices = new ArrayList<>();
        for (Vector3f v : model.getVertices()) {
            resultVertices.add(createVector3(affineMatrix.multiply(createVector4(v))));
        }
        model.setVertices(resultVertices);
    }

    private Vector4f createVector4(Vector3f v) {
        return new Vector4f(v.getX(), v.getY(), v.getZ(), 1);
    }

    private Vector3f createVector3(Vector4f v) {
        return new Vector3f(v.getX(), v.getY(), v.getZ());
    }
}

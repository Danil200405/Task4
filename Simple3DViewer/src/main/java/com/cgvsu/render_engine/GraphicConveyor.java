package com.cgvsu.render_engine;
import com.cgvsu.math.*;

public class GraphicConveyor {

    public static Matrix4f rotateScaleTranslate() {
        float[] matrix = new float[]{
                1, 0, 0, 0,
                0, 1, 0, 0,
                0, 0, 1, 0,
                0, 0, 0, 1};
        return new Matrix4f(matrix);
    }

    public static Matrix4f lookAt(Vector3f eye, Vector3f target) {
        return lookAt(eye, target, new Vector3f(0F, 1.0F, 0F));
    }


    public static Matrix4f lookAt(Vector3f eye, Vector3f target, Vector3f up) {
        Vector3f resultX;
        Vector3f resultY;
        Vector3f resultZ;

        target.minusFromThis(eye);
        resultZ = target;//
        resultX = up.multiplyVector(resultZ);// сross возвращает тот же вектор, а multiply возвращает новый вектор
        resultY = resultZ.multiplyVector(resultX); //аналогично

        resultX.normalizeThis();
        resultY.normalizeThis();
        resultZ.normalizeThis();


        float[] matrix = new float[]{
                resultX.getX(), resultY.getX(), resultZ.getX(), 0,
                resultX.getY(), resultY.getY(), resultZ.getY(), 0,
                resultX.getZ(), resultY.getZ(), resultZ.getZ(), 0,
                -resultX.multiplyScalar(eye), -resultY.multiplyScalar(eye), -resultZ.multiplyScalar(eye), 1};
        return new Matrix4f(matrix);
    }






    public static Matrix4f perspective(
            final float fov,
            final float aspectRatio,
            final float nearPlane,
            final float farPlane) {
        Matrix4f result = new Matrix4f();
        float tangentMinusOnDegree = (float) (1.0F / (Math.tan(fov * 0.5F)));
        result.getMatrix()[0][0] = tangentMinusOnDegree / aspectRatio;
        result.getMatrix()[1][1] = tangentMinusOnDegree;
        result.getMatrix()[2][2] = (farPlane + nearPlane) / (farPlane - nearPlane);
        result.getMatrix()[2][3] = 1.0F;
        result.getMatrix()[3][2] = 2 * (nearPlane * farPlane) / (nearPlane - farPlane);
        return result;
    }

    public static Vector3f multiplyMatrix4ByVector3(final Matrix4f matrix, final Vector3f vertex) {// ?
        final float x = (vertex.getX() * matrix.getMatrix()[0][0]) + (vertex.getY() * matrix.getMatrix()[1][0]) + (vertex.getZ() * matrix.getMatrix()[2][0]) + matrix.getMatrix()[3][0];
        final float y = (vertex.getX() * matrix.getMatrix()[0][1]) + (vertex.getY() * matrix.getMatrix()[1][1]) + (vertex.getZ() * matrix.getMatrix()[2][1]) + matrix.getMatrix()[3][1];
        final float z = (vertex.getX() * matrix.getMatrix()[0][2]) + (vertex.getY() * matrix.getMatrix()[1][2]) + (vertex.getZ() * matrix.getMatrix()[2][2]) + matrix.getMatrix()[3][2];
        final float w = (vertex.getX() * matrix.getMatrix()[0][3]) + (vertex.getY() * matrix.getMatrix()[1][3]) + (vertex.getZ() * matrix.getMatrix()[2][3]) + matrix.getMatrix()[3][3];
        return new Vector3f(x / w, y / w, z / w);
    }

    public static Vector2f vertexToPoint(final Vector3f vertex, final int width, final int height) {
        return new Vector2f(vertex.getX() * width + width / 2.0F, -vertex.getY() * height + height / 2.0F);
    }
}

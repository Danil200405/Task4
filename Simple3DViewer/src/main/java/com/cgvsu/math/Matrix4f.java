package com.cgvsu.math;

import java.util.Arrays;

/**
 * Класс матрицы размерности 4.
 *
 * @version 1.1
 */
public class Matrix4f {
    /**
     * Поле размер.
     */
    private static final int size = 4;
    /**
     * Поле элементов матрицы.
     */
    private float[][] values;

    /**
     * Конструктор матрицы через двумерный массив float.
     */
    public Matrix4f(float[][] values) {
        if (values.length == 4 && values[0].length == 4) {
            this.values = values;
        } else {
            throw new ArithmeticException("The number of columns of one of the matrices is not equal to the number of rows");
        }
    }

    /**
     * Конструктор матрицы через другую матрицу Matrix4f.
     */
    public Matrix4f(Matrix4f matrix) {
        this.values = matrix.values;
    }

    /**
     * Сложение матриц.
     * Возвращает матрицу.
     */
    public Matrix4f plus(Matrix4f matrix) {
        return new Matrix4f(MatrixOperations.plus(this.values, matrix.values));
    }

    /**
     * Сложение матриц.
     * Сложение остается в матрице, от которой вызывается.
     */
    public void plusToThis(Matrix4f matrix) {
        setMatrix(new Matrix4f(MatrixOperations.plus(this.values, matrix.values)));
    }

    /**
     * Вычитание матриц.
     * Возвращает матрицу.
     */
    public Matrix4f minus(Matrix4f matrix) {
        return new Matrix4f(MatrixOperations.minus(this.values, matrix.values));
    }

    /**
     * Вычитание матриц.
     * Вычитание остается в матрице, от которой вызывается.
     */
    public void minusFromThis(Matrix4f matrix) {
        setMatrix(new Matrix4f(MatrixOperations.minus(this.values, matrix.values)));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Matrix4f matrix4f = (Matrix4f) o;
        return Arrays.equals(values, matrix4f.values);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(values);
    }

    /**
     * Умножение матрицы на вектор.
     * Возвращает вектор.
     */
    public Vector4f multiply(Vector4f vector) {
        float[] returnVector = MatrixOperations.multiply(this.values, new float[]{vector.getX(), vector.getY(), vector.getZ(), vector.getW()});
        return new Vector4f(returnVector[0], returnVector[1], returnVector[2], returnVector[3]);
    }

    /**
     * Умножение матриц.
     * Возвращает матрицу.
     */
    public Matrix4f multiply(Matrix4f matrix) {
        return new Matrix4f(MatrixOperations.multiply(this.values, matrix.values));
    }

    /**
     * Умножение матриц.
     * Умножение остается в матрице, от которой вызывается.
     */
    public void multiplyThis(Matrix4f matrix) {
        setMatrix(new Matrix4f(MatrixOperations.multiply(this.values, matrix.values)));
    }

    /**
     * Создание единичной матрицы.
     * Возвращает матрицу.
     */
    public static Matrix4f createUnitMatrix() {
        return new Matrix4f(MatrixOperations.createUnitMatrix(size));
    }

    /**
     * Создание нулевой матрицы.
     * Возвращает матрицу.
     */
    public static Matrix4f createNullMatrix() {
        return new Matrix4f(MatrixOperations.createNullMatrix(size));
    }

    /**
     * Нахождение определителя матрицы, от которой вызывается.
     * Возвращает определитель.
     */
    public float getDeterminant() {
        return MatrixOperations.getDeterminant(values);
    }

    /**
     * Создание обратной матрицы.
     * Возвращает матрицу.
     */
    public Matrix4f inverse() {
        return new Matrix4f(MatrixOperations.inverse(this.values));
    }

    /**
     * Создание обратной матрицы.
     * Замещает матрицу, от которой вызывается.
     */
    public void inverseThis() {
        setMatrix(new Matrix4f(MatrixOperations.inverse(this.values)));
    }

    /**
     * Транспонирование матрицы.
     * Возвращает матрицу.
     */
    public Matrix4f transpose() {
        return new Matrix4f(MatrixOperations.transpose(this.values));
    }

    /**
     * Транспонирование матрицы.
     * Замещает матрицу, от которой вызывается.
     */
    public void transposeThis() {
        setMatrix(new Matrix4f(MatrixOperations.transpose(this.values)));
    }

    /**
     * Замещает матрицу, от которой вызывается, на переданный двумерный массив размерности 4.
     */
    public void setMatrix(float[][] matrix) {
        this.values = matrix;
    }

    /**
     * Замещает матрицу, от которой вызывается, на переданную матрицу Matrix4f.
     */
    public void setMatrix(Matrix4f matrix) {
        this.values = matrix.values;
    }

    /**
     * Возвращает элементы матрицы.
     */
    public float[][] getMatrix() {
        return values;
    }

    @Override
    public String toString() {
        return "Matrix4f{" +
                "values=" + Arrays.toString(values) +
                '}';
    }
}
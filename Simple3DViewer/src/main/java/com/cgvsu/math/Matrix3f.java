package com.cgvsu.math;

import java.util.Arrays;

/**
 * Класс матрицы размерности 3.
 *
 * @version 1.0
 */
public class Matrix3f {
    /**
     * Поле размер.
     */
    private static final int size = 3;
    /**
     * Поле элементов матрицы.
     */
    private float[][] values = new float[3][3];

    /**
     * Конструктор матрицы через двумерный массив float.
     */
    public Matrix3f(float[][] values) {
        if (values.length == 3 && values[0].length == 3) {
            this.values = values;
        } else {
            throw new ArithmeticException("The number of columns of one of the matrices is not equal to the number of rows");
        }
    }

    /**
     * Конструктор матрицы через другую матрицу Matrix3f.
     */
    public Matrix3f(Matrix3f matrix) {
        this.values = matrix.values;
    }

    /**
     * Сложение матриц.
     * Возвращает матрицу.
     */
    public Matrix3f plus(Matrix3f matrix) {
        return new Matrix3f(MatrixOperations.plus(this.values, matrix.values));
    }

    /**
     * Сложение матриц.
     * Сложение остается в матрице, от которой вызывается.
     */
    public void plusToThis(Matrix3f matrix) {
        setMatrix(new Matrix3f(MatrixOperations.plus(this.values, matrix.values)));
    }

    /**
     * Вычитание матриц.
     * Возвращает матрицу.
     */
    public Matrix3f minus(Matrix3f matrix) {
        return new Matrix3f(MatrixOperations.minus(this.values, matrix.values));
    }

    /**
     * Вычитание матриц.
     * Вычитание остается в матрице, от которой вызывается.
     */
    public void minusFromThis(Matrix3f matrix) {
        setMatrix(new Matrix3f(MatrixOperations.minus(this.values, matrix.values)));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Matrix3f matrix3f = (Matrix3f) o;
        return Arrays.equals(values, matrix3f.values);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(values);
    }

    /**
     * Умножение матрицы на вектор.
     * Возвращает вектор.
     */
    public Vector3f multiply(Vector3f vector) {
        float[] returnVector = MatrixOperations.multiply(this.values, new float[]{vector.getX(), vector.getY(), vector.getZ()});
        return new Vector3f(returnVector[0], returnVector[1], returnVector[2]);
    }

    /**
     * Умножение матриц.
     * Возвращает матрицу.
     */
    public Matrix3f multiply(Matrix3f matrix) {
        return new Matrix3f(MatrixOperations.multiply(this.values, matrix.values));
    }

    /**
     * Умножение матриц.
     * Умножение остается в матрице, от которой вызывается.
     */
    public void multiplyThis(Matrix3f matrix) {
        setMatrix(new Matrix3f(MatrixOperations.multiply(this.values, matrix.values)));
    }

    /**
     * Создание единичной матрицы.
     * Возвращает матрицу.
     */
    public static Matrix3f createUnitMatrix() {
        return new Matrix3f(MatrixOperations.createUnitMatrix(size));
    }

    /**
     * Создание нулевой матрицы.
     * Возвращает матрицу.
     */
    public static Matrix3f createNullMatrix() {
        return new Matrix3f(MatrixOperations.createNullMatrix(size));
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
    public Matrix3f inverse() {
        return new Matrix3f(MatrixOperations.inverse(this.values));
    }

    /**
     * Создание обратной матрицы.
     * Замещает матрицу, от которой вызывается.
     */
    public void inverseThis() {
        setMatrix(new Matrix3f(MatrixOperations.inverse(this.values)));
    }

    /**
     * Транспонирование матрицы.
     * Возвращает матрицу.
     */
    public Matrix3f transpose() {
        return new Matrix3f(MatrixOperations.transpose(this.values));
    }

    /**
     * Транспонирование матрицы.
     * Замещает матрицу, от которой вызывается.
     */
    public void transposeThis() {
        setMatrix(new Matrix3f(MatrixOperations.transpose(this.values)));
    }

    /**
     * Замещает матрицу, от которой вызывается, на переданный двумерный массив размерности 3.
     */
    public void setMatrix(float[][] matrix) {
        this.values = matrix;
    }

    /**
     * Замещает матрицу, от которой вызывается, на переданную матрицу Matrix3f.
     */
    public void setMatrix(Matrix3f matrix) {
        this.values = matrix.values;
    }

    /**
     * Возвращает элементы матрицы.
     */
    public float[][] getMatrix() {
        return values;
    }
}
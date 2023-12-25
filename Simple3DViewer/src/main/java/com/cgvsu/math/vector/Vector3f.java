package com.cgvsu.math.vector;

public class Vector3f implements IVector<Vector3f>{
    public double x;
    public double y;
    public double z;

    public Vector3f(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector3f(double[] arr) {
        if (arr.length != 3) {
            throw new ArithmeticException("Wrong array length to create vector");
        }
        this.x = arr[0];
        this.y = arr[1];
        this.z = arr[2];
    }

    /*
     * Получение вектора в виде массива столбца
     */
    @Override
    public double[][] getVector() {
        return new double[][]{{x}, {y}, {z}};
    }

    /*
     * Получение значения "X"
     */
    public double getX() {
        return x;
    }

    /*
     * Получение значения "Y"
     */
    public double getY() {
        return y;
    }

    /*
     * Получение значения "Z"
     */

    public double getZ() {
        return z;
    }

    /*
     * Сложение векторов
     * Исходный вектор не изменяется
     * Возвращается новый вектор
     */
    @Override
    public Vector3f add(Vector3f v) {
        return new Vector3f(this.x + v.x, this.y + v.y, this.z + v.z);
    }

    /*
     * Сложение векторов
     * Исходный вектор не изменяется
     * Возвращается новый вектор
     */
    public Vector3f add(double x, double y, double z) {
        return new Vector3f(this.x + x, this.y + y, this.z + z);
    }

    /*
     * Разница векторов
     * Исходный вектор не изменяется
     * Возвращается новый вектор
     */
    @Override
    public Vector3f sub(Vector3f v) {
        return new Vector3f(this.x - v.x, this.y - v.y, this.z - v.z);
    }

    /*
     * Разница векторов
     * Исходный вектор не изменяется
     * Возвращается новый вектор
     */
    public Vector3f sub(double x, double y, double z) {
        return new Vector3f(this.x - x, this.y - y, this.z - z);
    }

    /*
     * Произведение вектора на число
     * Исходный вектор не изменяется
     * Возвращается новый вектор
     */
    @Override
    public Vector3f mul(double scalar) {
        double x = this.x * scalar;
        double y = this.y * scalar;
        double z = this.z * scalar;
        return new Vector3f(x, y, z);
    }

    /*
     * Деление вектора на число
     * Исходный вектор не изменяется
     * Возвращается новый вектор
     */
    @Override
    public Vector3f div(double scalar) {
        if (Math.abs(scalar) < 1e-14) {
            throw new ArithmeticException("You cant divide on 0");
        }
        double x = this.x / scalar;
        double y = this.y / scalar;
        double z = this.z / scalar;
        return new Vector3f(x, y, z);
    }

    /*
     * Получение длины вектора
     */
    @Override
    public double length() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    /*
     * Нормализация вектора
     */
    @Override
    public Vector3f normalization() {
        double len = this.length();
        if (Math.abs(len) < 1e-14) {
            throw new ArithmeticException("This vector cannot be normalized because its length is zero");
        }
        return this.div(len);
    }

    /*
     * Скалярное произведение векторов
     */
    @Override
    public double dotProduct(Vector3f v) {
        return this.x * v.x + this.y * v.y + this.z * v.z;
    }

    /*
     * Векторное произведение
     */
    public Vector3f vectorProduct(Vector3f v) {
        double x = this.y * v.z - this.z * v.y;
        double y = this.z * v.x - this.x * v.z;
        double z = this.x * v.y - this.y * v.x;
        return new Vector3f(x, y, z);
    }

    /*
     * Сравнение векторов
     */
    @Override
    public boolean equals(Vector3f v) {
        return Math.abs(this.x - v.x) < 1e-14 && Math.abs(this.y - v.y) < 1e-14 &&
                Math.abs(this.z - v.z) < 1e-14;
    }

    @Override
    public String toString() {
        return "Vector3f{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }
}
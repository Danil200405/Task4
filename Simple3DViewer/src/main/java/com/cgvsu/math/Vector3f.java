package com.cgvsu.math;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Класс вектора размерности 3.
 *
 * @version 1.3
 */
public class Vector3f {
    /**
     * Поле х.
     */
    private float x;
    /**
     * Поле y.
     */
    private float y;
    /**
     * Поле z.
     */
    private float z;
    /**
     * Поле длинна.
     */
    private float length;

    /**
     * Конструктор вектора по значениям х, y и z.
     *
     * @param x Первый элемент
     * @param y Второй элемент
     * @param z Третий элемент
     */
    public Vector3f(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.length = (float) Math.sqrt((x * x) + (y * y) + (z * z));
    }

    /**
     * Конструктор вектора из другого вектора.
     *
     * @param vector3f Вектор, который нужно продублировать
     */
    public Vector3f(Vector3f vector3f) {
        this.x = vector3f.x;
        this.y = vector3f.y;
        this.z = vector3f.z;
        this.length = vector3f.getLength();
    }

    /**
     * Конструктор вектора по значениям массива float.
     *
     * @param floats Массив длинны не менее 3, берет первые три элемента для создания вектора
     */
    public Vector3f(float[] floats) {
        if (floats.length < 3) {
            throw new NullPointerException("Exception: massive don't have 3 elements!");
        } else {
            this.x = floats[0];
            this.y = floats[1];
            this.z = floats[2];
            this.length = (float) Math.sqrt((floats[0] * floats[0]) + (floats[1] * floats[1]) + (floats[2] * floats[2]));
        }
    }

    /**
     * Конструктор вектора по значениям листа float.
     *
     * @param floats Лист длинны не менее 3, берет первые три элемента для создания вектора
     */
    public Vector3f(ArrayList<Float> floats) {
        if (floats.size() < 3) {
            throw new NullPointerException("Exception: list don't have 3 elements!");
        } else {
            this.x = floats.get(0);
            this.y = floats.get(1);
            this.z = floats.get(2);
            this.length = (float) Math.sqrt((floats.get(0) * floats.get(0)) + (floats.get(1) * floats.get(1)) + (floats.get(2) * floats.get(2)));
        }
    }

    /**
     * Сложение двух векторов.
     *
     * @param vector3f Вектор который нужно прибавить
     * @return Новый вектор.
     */
    public Vector3f plus(Vector3f vector3f) {
        return new Vector3f(this.x + vector3f.getX(), this.y + vector3f.getY(), this.z + vector3f.getZ());
    }

    /**
     * Сложение двух векторов.
     * Сложение остается в векторе, от которого вызывается.
     *
     * @param vector3f Вектор который нужно прибавить
     */
    public void plusToThis(Vector3f vector3f) {
        this.x += vector3f.getX();
        this.y += vector3f.getY();
        this.z += vector3f.getZ();
        this.length = (float) Math.sqrt((x * x) + (y * y) + (z * z));
    }

    /**
     * Вычитание двух векторов.
     *
     * @param vector3f Вектор который нужно отнять
     * @return Новый вектор.
     */
    public Vector3f minus(Vector3f vector3f) {
        return new Vector3f(this.x - vector3f.getX(), this.y - vector3f.getY(), this.z - vector3f.getZ());
    }

    /**
     * Вычитание двух векторов.
     * Вычитание остается в векторе, от которого вызывается.
     *
     * @param vector3f Вектор который нужно отнять
     */
    public void minusFromThis(Vector3f vector3f) {
        this.x -= vector3f.getX();
        this.y -= vector3f.getY();
        this.z -= vector3f.getZ();
        this.length = (float) Math.sqrt((x * x) + (y * y) + (z * z));
    }

    /**
     * Умножение вектора на скаляр.
     *
     * @param scalar Скаляр, на который нужно умножить
     * @return Новый вектор.
     */
    public Vector3f multiply(float scalar) {
        return new Vector3f(this.x * scalar, this.y * scalar, this.z * scalar);
    }

    /**
     * Умножение вектора на скаляр.
     * Умножение остается в векторе, от которого вызывается.
     *
     * @param scalar Скаляр, на который нужно умножить
     */
    public void multiplyThis(float scalar) {
        this.x *= scalar;
        this.y *= scalar;
        this.z *= scalar;
        this.length = (float) Math.sqrt((x * x) + (y * y) + (z * z));
    }

    /**
     * Деление вектора на скаляр.
     *
     * @param scalar Скаляр, на который нужно поделить
     * @return Новый вектор.
     */
    public Vector3f divide(float scalar) {
        if (scalar == 0) {
            throw new NullPointerException("Exception: scalar is null!");
        } else {
            return new Vector3f(this.x / scalar, this.y / scalar, this.z / scalar);
        }
    }

    /**
     * Деление вектора на скаляр.
     * Деление остается в векторе, от которого вызывается.
     *
     * @param scalar Скаляр, на который нужно поделить
     */
    public void divideThis(float scalar) {
        if (scalar == 0) {
            throw new NullPointerException("Exception: scalar is null!");
        } else {
            this.x /= scalar;
            this.y /= scalar;
            this.z /= scalar;
            this.length = (float) Math.sqrt((x * x) + (y * y) + (z * z));
        }
    }

    /**
     * Нормализация вектора.
     *
     * @return Новый вектор.
     */
    public Vector3f normalize() {
        return this.divide(length);
    }

    /**
     * Нормализация вектора.
     * Нормализация остается в векторе, от которого вызывается.
     */
    public void normalizeThis() {
        divideThis(length);
    }

    /**
     * Скалярное умножение векторов.
     *
     * @param vector Вектор, на который нужно умножить
     * @return Результат умножения
     */
    public float multiplyScalar(Vector3f vector) {
        return this.x * vector.getX() + this.y * vector.getY() + this.z * vector.getZ();
    }

    /**
     * Векторное произведение векторов.
     *
     * @param vector Вектор, на который надо умножить
     * @return Новый вектор, результат произведения.
     */
    public Vector3f multiplyVector(Vector3f vector) {

        return new Vector3f(this.y * vector.getZ() - this.z * vector.getY(), this.z * vector.getX() - this.x * vector.getZ(), this.x * vector.getY() - this.y * vector.getX());
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector3f vector3f = (Vector3f) o;
        return Float.compare(vector3f.x, x) == 0 && Float.compare(vector3f.y, y) == 0 && Float.compare(vector3f.z, z) == 0 && Float.compare(vector3f.length, length) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z, length);
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
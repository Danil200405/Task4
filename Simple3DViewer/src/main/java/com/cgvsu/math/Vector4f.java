package com.cgvsu.math;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Класс вектора размерности 4.
 *
 * @version 1.3
 */
public class Vector4f {
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
     * Поле w.
     */
    private float w;
    /**
     * Поле длинна.
     */
    private float length;

    /**
     * Конструктор вектора по значениям х, y, z и w.
     *
     * @param x Первый элемент
     * @param y Второй элемент
     * @param z Третий элемент
     * @param w Четвертый элемент
     */
    public Vector4f(float x, float y, float z, float w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
        this.length = (float) Math.sqrt((x * x) + (y * y) + (z * z) + (w * w));
    }

    /**
     * Конструктор вектора из другого вектора.
     *
     * @param vector4f Вектор, который нужно продублировать
     */
    public Vector4f(Vector4f vector4f) {
        this.x = vector4f.x;
        this.y = vector4f.y;
        this.z = vector4f.z;
        this.w = vector4f.w;
        this.length = vector4f.getLength();
    }

    /**
     * Конструктор вектора по значениям массива float.
     *
     * @param floats Массив длинны не менее 4, берет первые четыре элемента для создания вектора
     */
    public Vector4f(float[] floats) {
        if (floats.length < 4) {
            throw new NullPointerException("Exception: massive don't have 4 elements!");
        } else {
            this.x = floats[0];
            this.y = floats[1];
            this.z = floats[2];
            this.w = floats[3];
            this.length = (float) Math.sqrt((floats[0] * floats[0]) + (floats[1] * floats[1]) + (floats[2] * floats[2]) + (floats[3] * floats[3]));
        }
    }

    /**
     * Конструктор вектора по значениям листа float.
     *
     * @param floats Лист длинны не менее 4, берет первые четыре элемента для создания вектора
     */
    public Vector4f(ArrayList<Float> floats) {
        if (floats.size() < 4) {
            throw new NullPointerException("Exception: list don't have 3 elements!");
        } else {
            this.x = floats.get(0);
            this.y = floats.get(1);
            this.z = floats.get(2);
            this.w = floats.get(3);
            this.length = (float) Math.sqrt((floats.get(0) * floats.get(0)) + (floats.get(1) * floats.get(1)) + (floats.get(2) * floats.get(2)) + (floats.get(3) * floats.get(3)));
        }
    }

    /**
     * Сложение двух векторов.
     *
     * @param vector4f Вектор который нужно прибавить
     * @return Новый вектор.
     */
    public Vector4f plus(Vector4f vector4f) {
        return new Vector4f(this.x + vector4f.getX(), this.y + vector4f.getY(), this.z + vector4f.getZ(), this.w + vector4f.getW());
    }

    /**
     * Сложение двух векторов.
     * Сложение остается в векторе, от которого вызывается.
     *
     * @param vector4f Вектор который нужно прибавить
     */
    public void plusToThis(Vector4f vector4f) {
        this.x += vector4f.getX();
        this.y += vector4f.getY();
        this.z += vector4f.getZ();
        this.w += vector4f.getW();
        this.length = (float) Math.sqrt((x * x) + (y * y) + (z * z) + (w * w));
    }

    /**
     * Вычитание двух векторов.
     *
     * @param vector4f Вектор который нужно отнять
     * @return Новый вектор.
     */
    public Vector4f minus(Vector4f vector4f) {
        return new Vector4f(this.x - vector4f.getX(), this.y - vector4f.getY(), this.z - vector4f.getZ(), this.w - vector4f.getW());
    }

    /**
     * Вычитание двух векторов.
     * Вычитание остается в векторе, от которого вызывается.
     *
     * @param vector4f Вектор который нужно отнять
     */
    public void minusFromThis(Vector4f vector4f) {
        this.x -= vector4f.getX();
        this.y -= vector4f.getY();
        this.z -= vector4f.getZ();
        this.w -= vector4f.getW();
        this.length = (float) Math.sqrt((x * x) + (y * y) + (z * z) + (w * w));
    }

    /**
     * Умножение вектора на скаляр.
     *
     * @param scalar Скаляр, на который нужно умножить
     * @return Новый вектор.
     */
    public Vector4f multiply(float scalar) {
        return new Vector4f(this.x * scalar, this.y * scalar, this.z * scalar, this.w * scalar);
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
        this.w *= scalar;
        this.length = (float) Math.sqrt((x * x) + (y * y) + (z * z) + (w * w));
    }

    /**
     * Деление вектора на скаляр.
     *
     * @param scalar Скаляр, на который нужно поделить
     * @return Новый вектор.
     */
    public Vector4f divide(float scalar) {
        if (scalar == 0) {
            throw new NullPointerException("Exception: scalar is null!");
        } else {
            return new Vector4f(this.x / scalar, this.y / scalar, this.z / scalar, this.w / scalar);
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
            this.w /= scalar;
            this.length = (float) Math.sqrt((x * x) + (y * y) + (z * z) + (w * w));
        }
    }

    /**
     * Нормализация вектора.
     *
     * @return Новый вектор.
     */
    public Vector4f normalize() {
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
    public float multiplyScalar(Vector4f vector) {
        return this.x * vector.getX() + this.y * vector.getY() + this.z * vector.getZ() + this.w * vector.getW();
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

    public float getW() {
        return w;
    }

    public void setW(float w) {
        this.w = w;
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
        Vector4f vector4f = (Vector4f) o;
        return Float.compare(vector4f.x, x) == 0 && Float.compare(vector4f.y, y) == 0 && Float.compare(vector4f.z, z) == 0 && Float.compare(vector4f.w, w) == 0 && Float.compare(vector4f.length, length) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z, w, length);
    }

    @Override
    public String toString() {
        return "Vector4f{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                ", w=" + w +
                '}';
    }
}
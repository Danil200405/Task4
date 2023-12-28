package com.cgvsu.math;

/**
 * Класс операций над матрицей.
 *
 * @version 1.2
 */
public class MatrixOperations {
    /**
     * Получение определителя.
     *
     * @param matrix Матрица, определитель которой нужно найти
     * @return Определитель.
     */
    protected static float getDeterminant(float[][] matrix) {
        if (matrix.length != matrix[0].length) {
            throw new ArithmeticException("The number of matrix columns is not equal to the number of rows");
        } else {
            float result = 0;

            if (matrix.length == 1) {
                return matrix[0][0];
            }

            for (int i = 0; i < matrix[0].length; i++) {
                result += (float) (Math.pow(-1, i) * matrix[0][i] * getDeterminant(reduceMatrix(matrix, 0, i)));
            }

            return result;
        }
    }

    /**
     * Уменьшение матрицы до указанных индексов.
     *
     * @param matrix      Матрица, которую нужно уменьшить
     * @param lineIndex   Индекс строки, до какой нужно уменьшить
     * @param columnIndex Индекс столбца, до которого нужно уменьшить
     * @return Уменьшенную матрицу
     */
    private static float[][] reduceMatrix(float[][] matrix, int lineIndex, int columnIndex) {
        return reduceMatrixColumns(reduceMatrixLines(matrix, lineIndex), columnIndex);
    }

    /**
     * Уменьшение матрицы до указанной строки.
     *
     * @param matrix    Матрица, которую нужно уменьшить
     * @param lineIndex Индекс строки, до какой нужно уменьшить
     * @return Уменьшенную матрицу
     */
    private static float[][] reduceMatrixLines(float[][] matrix, int lineIndex) {
        float[][] newMatrix = new float[matrix.length - 1][matrix[0].length];

        for (int i = 0; i < lineIndex; i++) {
            System.arraycopy(matrix[i], 0, newMatrix[i], 0, newMatrix[i].length);
        }
        for (int i = lineIndex; i < newMatrix.length; i++) {
            System.arraycopy(matrix[i + 1], 0, newMatrix[i], 0, newMatrix[i].length);
        }

        return newMatrix;
    }

    /**
     * Уменьшение матрицы до указанного столбца.
     *
     * @param matrix      Матрица, которую нужно уменьшить
     * @param columnIndex Индекс столбца, до которого нужно уменьшить
     * @return Уменьшенную матрицу
     */
    private static float[][] reduceMatrixColumns(float[][] matrix, int columnIndex) {
        float[][] newMatrix = new float[matrix.length][matrix[0].length - 1];

        for (int i = 0; i < newMatrix.length; i++) {
            if (columnIndex >= 0) {
                System.arraycopy(matrix[i], 0, newMatrix[i], 0, columnIndex);
            }
            if (newMatrix[i].length - columnIndex >= 0) {
                System.arraycopy(matrix[i], columnIndex + 1, newMatrix[i], columnIndex, newMatrix[i].length - columnIndex);
            }
        }

        return newMatrix;
    }

    /**
     * Сложение матриц.
     *
     * @param matrixFirst  Матрица, к которой надо прибавить
     * @param matrixSecond Матрица, которая прибавляется
     * @return Результат сложения
     */
    protected static float[][] plus(float[][] matrixFirst, float[][] matrixSecond) {
        if (matrixFirst.length != matrixFirst[0].length && matrixSecond.length != matrixSecond[0].length && matrixFirst.length != matrixSecond.length && matrixFirst[0].length != matrixSecond[0].length) {
            throw new ArithmeticException("The number of columns of one of the matrices is not equal to the number of rows");
        } else {
            float[][] result = new float[matrixFirst.length][matrixFirst.length];
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result.length; j++) {
                    result[i][j] = matrixFirst[i][j] + matrixSecond[i][j];
                }
            }

            return result;
        }
    }

    /**
     * Вычитание матриц.
     *
     * @param matrixFirst  Матрица, от которой вычитается
     * @param matrixSecond Матрица, которая вычитается
     * @return Результат вычитания
     */
    protected static float[][] minus(float[][] matrixFirst, float[][] matrixSecond) {
        if (matrixFirst.length != matrixFirst[0].length && matrixSecond.length != matrixSecond[0].length && matrixFirst.length != matrixSecond.length && matrixFirst[0].length != matrixSecond[0].length) {
            throw new ArithmeticException("The number of columns of one of the matrices is not equal to the number of rows");
        } else {
            float[][] result = new float[matrixFirst.length][matrixFirst.length];
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result.length; j++) {
                    result[i][j] = matrixFirst[i][j] - matrixSecond[i][j];
                }
            }

            return result;
        }
    }

    /**
     * Умножение матрицы на вектор.
     *
     * @param matrixFirst Матрица, которую нужно умножить
     * @param vector      Вектор, на который надо умножить
     * @return Результат умножения в виде вектора
     */
    protected static float[] multiply(float[][] matrixFirst, float[] vector) {
        if (matrixFirst.length != matrixFirst[0].length && matrixFirst[0].length != vector.length) {
            throw new ArithmeticException("The number of columns matrix is not equal to the number of rows or number matrix columns is not equal to the size of vector");
        } else {
            float[] result = new float[matrixFirst.length];
            for (int i = 0; i < result.length; i++) {
                float element = 0;
                for (int j = 0; j < matrixFirst.length; j++) {
                    element += matrixFirst[i][j] * vector[j];
                }
                result[i] = element;
            }

            return result;
        }
    }

    /**
     * Перемножение матриц.
     *
     * @param matrixFirst  Матрица умножаемая
     * @param matrixSecond Матрица на которую умножается
     * @return Результат в виде матрицы
     */
    protected static float[][] multiply(float[][] matrixFirst, float[][] matrixSecond) {
        if (matrixFirst.length != matrixFirst[0].length && matrixSecond.length != matrixSecond[0].length && matrixFirst.length != matrixSecond.length && matrixFirst[0].length != matrixSecond[0].length) {
            throw new ArithmeticException("The number of columns of one of the matrices is not equal to the number of rows");
        } else {

            float[][] result = new float[matrixFirst.length][matrixFirst.length];

            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result.length; j++) {
                    float element = 0;
                    for (int k = 0; k < result.length; k++) {
                        element += matrixFirst[i][k] * matrixSecond[k][j];
                    }

                    result[i][j] = element;
                }
            }

            return result;
        }
    }

    /**
     * Умножение матрицы на скаляр.
     *
     * @param matrixFirst Матрица умножаемая
     * @param scalar      Скаляр на который умножается
     * @return Результат в виде матрицы
     */
    protected static float[][] multiplyScalar(float[][] matrixFirst, float scalar) {
        if (matrixFirst.length != matrixFirst[0].length) {
            throw new ArithmeticException("The number of matrix columns is not equal to the number of rows");
        } else {
            float[][] result = new float[matrixFirst.length][matrixFirst.length];

            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result.length; j++) {
                    result[i][j] = matrixFirst[i][j] * scalar;
                }
            }

            return result;
        }
    }

    /**
     * Создание нулевой матрицы.
     *
     * @param size Размер матрицы
     * @return Нулевая матрица
     */
    protected static float[][] createNullMatrix(int size) {
        float[][] matrix = new float[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = 0;
            }
        }

        return matrix;
    }

    /**
     * Создание единичной матрицы.
     *
     * @param size Размер матрицы
     * @return Единичная матрица
     */
    protected static float[][] createUnitMatrix(int size) {
        float[][] matrix = new float[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = (i == j) ? 1 : 0;
            }
        }

        return matrix;
    }

    /**
     * Делает из матрицы обратную матрицу.
     *
     * @param matrix Матрица, из которой нужно сделать обратную
     * @return Возвращает обратную матрицу
     */
    protected static float[][] inverse(float[][] matrix) {
        float determinant = getDeterminant(matrix);
        if (determinant == 0) {
            throw new ArithmeticException("Matrix is not invertible");
        } else {

            float[][] returnMatrix = new float[matrix.length][matrix.length];

            for (int i = 0; i < returnMatrix.length; i++) {
                for (int j = 0; j < returnMatrix.length; j++) {
                    float adj = (float) Math.pow(-1, i + j) * getDeterminant(reduceMatrix(matrix, i, j));
                    if (Math.abs(adj) == 0) {
                        returnMatrix[i][j] = 0;
                    } else {
                        returnMatrix[i][j] = adj;
                    }
                }
            }

            return transpose(multiplyScalar(returnMatrix, 1 / determinant));
        }
    }

    /**
     * Транспонирование матрицы.
     *
     * @param matrix Матрица, которую нужно транспонировать
     * @return Транспонированная матрица
     */
    protected static float[][] transpose(float[][] matrix) {
        if (matrix.length != matrix[0].length) {
            throw new ArithmeticException("The number of matrix columns is not equal to the number of rows");
        } else {
            float[][] returnMatrix = new float[matrix.length][matrix.length];

            for (int i = 0; i < returnMatrix.length; i++) {
                for (int j = 0; j < returnMatrix.length; j++) {
                    returnMatrix[j][i] = matrix[i][j];
                }
            }

            return returnMatrix;
        }
    }
}
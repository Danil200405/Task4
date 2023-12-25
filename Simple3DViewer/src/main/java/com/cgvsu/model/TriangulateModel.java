package com.cgvsu.model;



import com.cgvsu.math.vector.Vector2f;
import com.cgvsu.math.vector.Vector3f;

import java.util.ArrayList;

public class TriangulateModel extends Model {
    private ArrayList<Vector3f> vertices = new ArrayList<Vector3f>();
    private ArrayList<Vector2f> textureVertices = new ArrayList<Vector2f>();
    private ArrayList<Vector3f> normals = new ArrayList<Vector3f>();
    private ArrayList<Polygon> polygons = new ArrayList<Polygon>();

    @Override
    public void setModel(Model model) {
        super.setModel(model);
    }

    // Геттеры для vertices
    public ArrayList<Vector3f> getVertices() {
        return vertices;
    }

    // Сеттер для vertices
    public void setVertices(ArrayList<Vector3f> vertices) {
        this.vertices = vertices;
    }

    // Геттеры для textureVertices
    public ArrayList<Vector2f> getTextureVertices() {
        return textureVertices;
    }

    // Сеттер для textureVertices
    public void setTextureVertices(ArrayList<Vector2f> textureVertices) {
        this.textureVertices = textureVertices;
    }

    // Геттеры для normals
    public ArrayList<Vector3f> getNormals() {
        return normals;
    }

    // Сеттер для normals
    public void setNormals(ArrayList<Vector3f> normals) {
        this.normals = normals;
    }

    // Геттеры для polygons
    public ArrayList<Polygon> getPolygons() {
        return polygons;
    }

    // Модифицированный сеттер для polygons
    public void setPolygons(ArrayList<Polygon> polygons) {
        // Проверка, что все полигоны являются треугольниками
        for (Polygon polygon : polygons) {
            if (polygon.getVertexIndices().size() != 3) {
                throw new IllegalArgumentException("All polygons must be triangles.");
            }
        }

        // Если проверка прошла успешно, устанавливаем полигоны
        this.polygons = polygons;
    }
}

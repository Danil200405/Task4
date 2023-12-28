package com.cgvsu;
import com.cgvsu.math.Vector2f;
import com.cgvsu.math.Vector3f;
import com.cgvsu.model.Model;
import com.cgvsu.model.Polygon;




public class ObjWriter {
    public static String modelToString(Model model) {
        StringBuilder stringBuilder = new StringBuilder();
        for(Vector3f v: model.vertices) {
            stringBuilder.append("v " + v.getX() + " " + v.getY() + " " + v.getZ() + "\n");
        }
        for (Vector2f v: model.textureVertices) {
            stringBuilder.append("t " + v.getX() + " " + v.getY() + "\n");
        }
        for (Vector3f v: model.normals) {
            stringBuilder.append("vn " + v.getX() + " " + v.getY() + " " + v.getZ() + "\n");
        }
        for (Polygon p: model.polygons) {
            int size =  p.getVertexIndices().size();
            stringBuilder.append("f");
            for (int i = 0; i < size; i++) {
                stringBuilder.append(" " + (p.getVertexIndices().get(i) + 1) +"/"+ p.getTextureVertexIndices().get(i));
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}

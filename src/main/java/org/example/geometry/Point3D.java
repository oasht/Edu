package org.example.geometry;

import java.util.Objects;

public class Point3D extends Point{
    int z;

    public Point3D(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }
    public double distanceTo(Point3D other) {
        double dx = this.x - other.x;
        double dy = this.y - other.y;
        double dz = this.z - other.z;
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false;

        Point3D point3D = (Point3D) obj;
        return this.z == point3D.z;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), z);
    }
    @Override
    public String toString() {
        return "{"+x+";"+y+";"+z+"}";
    }
}

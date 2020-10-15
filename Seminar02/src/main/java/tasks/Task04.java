package tasks;

/**
 * Реализовать трехмерный вектор.
 * Условие: https://habr.com/ru/post/440436/#20
 * Там есть решение. Сначала попробуйте самостоятельно.
 */
class Vector {
    double x;
    double y;
    double z;

    Vector(double _x, double _y, double _z) {
        x = _x;
        y = _y;
        z = _z;
    }

    public double vector_length() {
        return Math.sqrt(x*x + y*y + z*z);
    }

    public double scalar_product(Vector other) {
        return this.x*other.x + this.y*other.y + this.z*other.z;
    }

    public Vector vector_product(Vector other) {
        return new Vector(this.y*other.z - this.z*other.y,
                          this.z*other.x - this.x*other.z,
                          this.x*other.y - this.y*other.x);
    }

    public double angle(Vector other) {
        return this.scalar_product(other) / (this.vector_length() * other.vector_length());
    }

    public Vector add(Vector other) {
        return new Vector(this.x + other.x,
                          this.y + other.y,
                          this.z + other.z);

    }

    public Vector sub(Vector other) {
        return new Vector(this.x - other.x,
                          this.y - other.y,
                          this.z - other.z);

    }

    public static Vector[] rand_vec(int N) {
        Vector[] result = new Vector[N];
        for (int i = 0; i < N; i++) {
            result[i] = new Vector(Math.random(), Math.random(), Math.random());
        }
        return result;
    }
}

public class Task04 {

}

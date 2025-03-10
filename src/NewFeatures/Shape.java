package NewFeatures;

import java.util.List;

public sealed class Shape {
    public static final class Circle extends Shape {
        int radius;

        public Circle(int i) {
            radius = i;
        }

        public int getRadius() {
            return radius;
        }

        @Override
        public String toString() {
            return "Circle{" +
                    "radius=" + radius +
                    '}';
        }

        public void setRadius(int radius) {
            this.radius = radius;
        }
    }

    public sealed static class Quadrilateral extends Shape {
        public final static class Rectangle extends Quadrilateral {
            int x,y;

            public int getX() {
                return x;
            }

            public Rectangle(int x, int y) {
                this.x = x;
                this.y = y;
            }

            @Override
            public String toString() {
                return "Rectangle{" +
                        "x=" + x +
                        ", y=" + y +
                        '}';
            }

            public void setX(int x) {
                this.x = x;
            }
        }
        public final static class Parallelogram extends Quadrilateral {
            int x,y,angle;

            @Override
            public String toString() {
                return "Parallelogram{" +
                        "x=" + x +
                        ", y=" + y +
                        ", angle=" + angle +
                        '}';
            }

            public Parallelogram(int x, int y, int angle) {
                this.x = x;
                this.y = y;
                this.angle = angle;
            }

            public int getX() {
                return x;
            }

            public void setX(int x) {
                this.x = x;
            }

            public int getY() {
                return y;
            }

            public void setY(int y) {
                this.y = y;
            }

            public int getAngle() {
                return angle;
            }

            public void setAngle(int angle) {
                this.angle = angle;
            }
        }
    }

    public non-sealed static class WeirdShape extends Shape {
        public static record vector (int length, int angle){}

        public WeirdShape(List<vector> vectors) {
            this.vectors = vectors;
        }

        public List<vector> getVectors() {
            return vectors;
        }

        public void setVectors(List<vector> vectors) {
            this.vectors = vectors;
        }

        @Override
        public String toString() {
            return "WeirdShape{" +
                    "vectors=" + vectors +
                    '}';
        }

        List<vector> vectors;
    }
}
public class Model {

    public Model() {
        // Constructor can be used for initialization if needed
    }

    public double calculateSphereSurfaceArea(double radius) {
        return 4 * Math.PI * Math.pow(radius, 2);
    }

    public double calculateSphereCircumference(double radius) {
        return 2 * Math.PI * radius;
    }

    public double calculateSphereVolume(double radius) {
        return (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
    }

    public double calculateCylinderSurfaceArea(double radius, double height) {
        return 2 * Math.PI * radius * height + 2 * Math.PI * Math.pow(radius, 2);
    }

    public double calculateCylinderSideSurface(double radius, double height) {
        return 2 * Math.PI * radius * height;
    }

    public double calculateCylinderVolume(double radius, double height) {
        return Math.PI * Math.pow(radius, 2) * height;
    }
}
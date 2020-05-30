import java.util.Scanner;

class circle{
    double radius;
    String color = "default";
    circle(){}
    circle(int radius){
        this.radius = radius;
    }
    circle(int radius, String color){
        this.radius = radius;
        this.color = color;
    }
    public double getRadius() {
        return radius;
    }

    public double getArea() {
        return 3.1415*radius*radius;
    }

    public String getColor() {
        return color;
    }
}

class cylinder extends  circle{
    private double height;
    cylinder(){
        super();
        this.height = 1.0;
    }
    cylinder(double height, double radius){
        this.height = height;
        this.radius = radius;
    }
    cylinder(double height, double radius, String color){
        this.height = height;
        this.radius = radius;
        this.color = color;
    }
    public double getHeight() {
        return height;
    }

    public double getArea(){
        return 2*3.1415*radius*height;
    }
    public double getVolume(){
        return 3.1415*radius*radius*height;
    }
    @Override
    public String getColor() {
        return super.getColor();
    }
}
public class prgm3 {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        String cont = "yes";
        while(!cont.toLowerCase().equals("no") && !cont.equals("n")) {
            double radius1 = in.nextDouble();
            double height1 = in.nextDouble();
            double radius2 = in.nextDouble();
            double height2 = in.nextDouble();
            cylinder c1 = new cylinder(height1, radius1);
            cylinder c2 = new cylinder(height2, radius2);
            
            System.out.println("Do you want to add colors to your cylinders??");
            String colorch = in.next();
            if (!colorch.toLowerCase().equals("no") && !colorch.toLowerCase().equals("n")) {
                String color1 = in.next();
                String color2 = in.next();
                c1 = new cylinder(height1, radius1, color1);
                c2 = new cylinder(height2, radius2, color2);
            }
            if (c1.getColor().equals(c2.getColor()) && c1.getHeight() == c2.getHeight() &&
                    c1.getRadius() == c2.getRadius()) {
                System.out.println("The Cylinders are exactly the same!");
            } else {
                System.out.println("The Cylinders are different!");
            }
            System.out.println("Continue? ");
            cont = in.next();
        }
    }
}

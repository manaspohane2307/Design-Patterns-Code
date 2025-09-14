public class PrototypePattern{
    public static void main(String[] args) {
        Shape circlePrototype = new Circle("red");//first create concrete prototype
        ShapeClient client = new ShapeClient(circlePrototype);//second- create client of that concrete prototype
        Shape redCircle = client.creatShape();//call createShape method which in turn calls clone method
        redCircle.draw();
    }
}

interface Shape{//Prototype interface
    Shape clone();
    void draw();
}

class Circle implements Shape{//Concrete Prototype
    private String color;

    public Circle(String color){
        this.color = color;
    }

    public Shape clone(){
        return new Circle(this.color);
    }

    public void draw(){
        System.out.println("Drawing a " + color + " circle");
    }
}

class ShapeClient{
    private Shape shapePrototype;

    public ShapeClient(Shape shapePrototype){
        this.shapePrototype = shapePrototype;
    }

    public Shape creatShape(){
        return shapePrototype.clone();
    }
}
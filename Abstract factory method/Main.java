interface CarFactory{
    Car createCar();
    CarSpecification createSpecification();
}

class NorthAmericaCarFactory implements CarFactory{
    public Car createCar(){
        return new Sedan();
    }
    public CarSpecification createSpecification(){
        return new NorthAmericaSpecification();
    }
}

class EuropeancarFactory implements CarFactory{
    public Car createCar(){
        return new Hatchback();
    }
    public CarSpecification createSpecification(){
        return new EuropeSpecification();
    }
}

interface Car{
    void assemble();
}

interface CarSpecification{
    void display();
}

class Sedan implements Car{
    public void assemble(){
        System.out.println("Assembling sedan car");
    }
}

class Hatchback implements Car{
    public void assemble(){
        System.out.println("Assembling hatchback car");
    }
}

class NorthAmericaSpecification implements CarSpecification{
    public void display(){
        System.out.println("North america car specification");
    }
}

class EuropeSpecification implements CarSpecification{
    public void display(){
        System.out.println("Europe car specification");
    }
}

public class Main{
    public static void main(String[] args) {
        CarFactory naf = new NorthAmericaCarFactory();
        Car nac = naf.createCar();
        CarSpecification nas = naf.createSpecification();
        nac.assemble();
        nas.display();
    }
}
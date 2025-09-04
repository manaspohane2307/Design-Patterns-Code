abstract class Vehicle{//Product interface
    public abstract void printVehicle();
}

class TwoWheeler extends Vehicle{//Concrete Product
    public void printVehicle(){
        System.out.println("I am two wheeler");
    }
}

class FourWheeler extends Vehicle{//Concrete product
    public void printVehicle(){
        System.out.println("I am four wheeler");
    }
}

interface VehicleFactory{//Creater Interface
    Vehicle createVehicle();//method to create objects/vehicles
}

class TwoWheelerFactory implements VehicleFactory{//Concrete creator
    public Vehicle createVehicle(){
        return new TwoWheeler();
    }
}

class FourWheelerFactory implements VehicleFactory{//concrete creator
    public Vehicle createVehicle(){
        return new FourWheeler();
    }
}

class Client{//Client
    private Vehicle pvehicle;

    public Client(VehicleFactory factory){
        pvehicle = factory.createVehicle();
    }

    public Vehicle getVehicle(){
        return pvehicle;
    }
}


public class Main{
    public static void main(String[] args) {
        VehicleFactory twf = new TwoWheelerFactory();
        Client twc = new Client(twf);
        Vehicle tw = twc.getVehicle();
        tw.printVehicle();
    }
}


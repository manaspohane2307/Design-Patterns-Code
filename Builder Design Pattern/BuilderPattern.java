//Client
public class BuilderPattern{
    public static void main(String[] args) {
        GamingComputerBuilder gamingBuilder = new GamingComputerBuilder();
        ComputerDirector director = new ComputerDirector();
        director.construct(gamingBuilder);
        Computer gamingComputer = gamingBuilder.getResult();
        gamingComputer.displayInfo();
    }
}

//Product
class Computer{
    private String cpu;
    private String ram;
    private String storage;

    public void setCPU(String cpu){
        this.cpu = cpu;
    }

    public void setRAM(String ram){
        this.ram = ram;
    }

    public void setStorage(String storage){
        this.storage = storage;
    }

    public void displayInfo(){
        System.out.println("Computer Configuration:");
        System.out.println("CPU: " + cpu);
        System.out.println("RAM: " + ram);
        System.out.println("Storage: " + storage);
    }
}

//Builder Interface
interface Builder{
    void buildCPU();
    void buildRAM();
    void buildStorage();
    Computer getResult();
}

//Concrete Builder
class GamingComputerBuilder implements Builder{
    private Computer computer = new Computer();

    public void buildCPU(){
        computer.setCPU("Gaming CPU");
    }
    public void buildRAM(){
        computer.setRAM("16GB RAM");
    }
    public void buildStorage(){
        computer.setStorage("1TB SSD");
    }
    public Computer getResult(){
        return computer;
    }
}

//Director
class ComputerDirector{
    public void construct(Builder builder){//construct method
        builder.buildCPU();
        builder.buildRAM();
        builder.buildStorage();
    }
}

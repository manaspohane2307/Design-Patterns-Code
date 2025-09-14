//colleague interface
interface Airplane{//declare methods that airplane can do
    void requestTakeoff();
    void requestLanding();
    void notifyAirTrafficControl(String message);
}

//concrete collegue
class CommercialAirplane implements Airplane{//contains mediator reference and override methods of colleague
    private AirTrafficControlTower mediator;

    public CommercialAirplane(AirTrafficControlTower mediator){
        this.mediator = mediator;
    }

    public void requestTakeoff(){
        mediator.requestTakeoff(this);
    }

    public void requestLanding() {
        mediator.requestLanding(this);
    }

    public void notifyAirTrafficControl(String message){
        System.out.println("Commercial airplane "+ message);
    }
}

//Mediator interface
interface AirTrafficControlTower{
    void requestTakeoff(Airplane airplane);
    void requestLanding(Airplane airplane);
}

//concrete mediator
class AirportControlTower implements AirTrafficControlTower{
    public void requestTakeoff(Airplane airplane){
        airplane.notifyAirTrafficControl("Requesting takeoff clearance");
    }

    public void requestLanding(Airplane airplane){
        airplane.notifyAirTrafficControl("Requesting landing clearance");
    }
}

public class MediatorPattern {
    public static void main(String[] args) {
        //create concrete mediator object
        AirTrafficControlTower controlTower = new AirportControlTower();
        //create concrete colleagues and pass concrete mediator
        Airplane airplane1 = new CommercialAirplane(controlTower);
        Airplane airplane2 = new CommercialAirplane(controlTower);
        //request through msg
        airplane1.requestTakeoff();
        airplane2.requestLanding();
    }
}

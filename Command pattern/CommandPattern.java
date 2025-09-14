//command interface
interface Command {
    void execute();//contains execute method
}

//Concrete commands

// TurnOnCommand
class TurnOnCommand implements Command {
    private Runnable deviceAction;

    public TurnOnCommand(Runnable deviceAction) {
        this.deviceAction = deviceAction;
    }

    @Override
    public void execute() {
        deviceAction.run();
    }
}

// TurnOffCommand
class TurnOffCommand implements Command {
    private Runnable deviceAction;

    public TurnOffCommand(Runnable deviceAction) {
        this.deviceAction = deviceAction;
    }

    @Override
    public void execute() {
        deviceAction.run();
    }
}

class AdjustVolumeCommand implements Command {
    private Runnable stereoAction;

    public AdjustVolumeCommand(Runnable stereoAction) {
        this.stereoAction = stereoAction;
    }

    @Override
    public void execute() {
        stereoAction.run();
    }
}

class ChangeChannelCommand implements Command {
    private Runnable tvAction;

    public ChangeChannelCommand(Runnable tvAction) {
        this.tvAction = tvAction;
    }

    @Override
    public void execute() {
        tvAction.run();
    }
}

//Receiver interface
interface Device {
    void turnOn();
    void turnOff();
}

//concrete receiver for TV
class TV implements Device {
    @Override
    public void turnOn() {
        System.out.println("TV is now on");
    }

    @Override
    public void turnOff() {
        System.out.println("TV is now off");
    }

    public void changeChannel() {
        System.out.println("Channel changed");
    }
}

// Concrete receiver for a stereo
class Stereo implements Device {
    @Override
    public void turnOn() {
        System.out.println("Stereo is now on");
    }

    @Override
    public void turnOff() {
        System.out.println("Stereo is now off");
    }

    public void adjustVolume() {
        System.out.println("Volume adjusted");
    }
}

// Invoker
class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        if (command != null) {
            command.execute();
        }
    }
}

public class CommandPattern {
    public static void main(String[] args) {
        // Create devices
        TV tv = new TV();
        Stereo stereo = new Stereo();

        // Create command objects
        Command turnOnTvCommand = new TurnOnCommand(tv::turnOn);
        Command turnOffTvCommand = new TurnOffCommand(tv::turnOff);
        Command adjustVolumeStereoCommand = new AdjustVolumeCommand(stereo::adjustVolume);
        Command changeChannelTvCommand = new ChangeChannelCommand(tv::changeChannel);

        // Create remote control
        RemoteControl remote = new RemoteControl();

        // Set and execute commands
        remote.setCommand(turnOnTvCommand);
        remote.pressButton(); // Outputs: TV is now on

        remote.setCommand(adjustVolumeStereoCommand);
        remote.pressButton(); // Outputs: Volume adjusted

        remote.setCommand(changeChannelTvCommand);
        remote.pressButton(); // Outputs: Channel changed

        remote.setCommand(turnOffTvCommand);
        remote.pressButton(); // Outputs: TV is now off
    }
}
package org.firstinspires.ftc.teamcode.Call_Upon_Classes;
import com.qualcomm.hardware.rev.Rev2mDistanceSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
public class Distance_Sensor {


    //the sensors
    private Rev2mDistanceSensor ds = null;
    //variable for if it sees it
    public boolean yes = false;
    //Max Distance to see it
    private double md = 8.5;
    //Distance it is seeing right now
    private double dis = 0;
    //How far we need to move
    private double dm = 0;

    private Telemetry telemetry = null;

    public void initDistance(HardwareMap hardwareMap, Telemetry telemetry) {
        ds = hardwareMap.get(Rev2mDistanceSensor.class,"ds1");
        this.telemetry = telemetry;
    }

    public boolean checkSeesSomething() {
        getTelemetry();

        if(ds.getDistance(DistanceUnit.INCH) < md) {
            return true;
        } return false;
    }

    public void runDistance() {
        dis = ds.getDistance(DistanceUnit.INCH);
        if(dis<md) {
            dm = md-dis;
        }
    }

    public double dm() {return(dm);}

    public void getTelemetry() {
        telemetry.addData("Distance", ds.getDistance(DistanceUnit.INCH));
//                telemetry.addData("Position",pos);
//                telemetry.addData("Sees it", yes);
    }
}
package org.firstinspires.ftc.teamcode.Call_Upon_Classes;
import com.qualcomm.hardware.rev.Rev2mDistanceSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
public class Distance_Sensor {


    //the sensors
    private Rev2mDistanceSensor ds = null;
    public double distance = 0;
    public boolean found = false;

    public void initDistance(HardwareMap hardwareMap, String name) {
        ds = hardwareMap.get(Rev2mDistanceSensor.class,"ds");
    }

    public double getDistance(Telemetry telemetry){
        distance = ds.getDistance(DistanceUnit.INCH);
        if (distance > 0) {
            found = true;
        }
        getTelemetry(telemetry);
        return distance;
    }



    public void getTelemetry (Telemetry telemetry) {
        telemetry.addData("Distance", ds.getDistance(DistanceUnit.INCH));
    }

    public boolean found() {
        return found;
    }
    public double ds() {
        return distance;
    }
}
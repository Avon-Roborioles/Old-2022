package org.firstinspires.ftc.teamcode.Call_Upon_Classes;
import com.qualcomm.hardware.rev.Rev2mDistanceSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
public class Distance_Sensor {


    //the sensors
    private Rev2mDistanceSensor ds = null;
    public double distance = 0;

    public void initDistance(HardwareMap hardwareMap, String name) {
        ds = hardwareMap.get(Rev2mDistanceSensor.class,"ds");
    }

    public void getDistance(Telemetry telemetry){
       distance = ds.getDistance(DistanceUnit.INCH);
       getTelemetry(telemetry);
    }


    public void getTelemetry (Telemetry telemetry) {
        telemetry.addData("Distance", ds.getDistance(DistanceUnit.INCH));
    }
}
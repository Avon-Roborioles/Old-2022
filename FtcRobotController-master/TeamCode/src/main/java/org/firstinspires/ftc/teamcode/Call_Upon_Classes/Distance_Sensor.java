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
    public double idealdistance = 6;
    public boolean allignedTOp = false;


    public void initDistance(HardwareMap hardwareMap, String name) {
        ds = hardwareMap.get(Rev2mDistanceSensor.class,"ds");
    }
    public void rundistanceTeleop(Telemetry telemetry){
        if(ds.getDistance(DistanceUnit.INCH) <= idealdistance){
            allignedTOp = true;
        }else{
            allignedTOp = false;
        }
        get_Telemetry(telemetry);
    }
    public double getDistance(Telemetry telemetry){
        distance = ds.getDistance(DistanceUnit.INCH);
        if (distance > 0) {
            found = true;
        }
        get_Telemetry(telemetry);
        return distance;
    }



    public void get_Telemetry (Telemetry telemetry) {
        telemetry.addData("Distance", ds.getDistance(DistanceUnit.INCH));
        telemetry.addData("alligned with pole", allignedTOp);
    }

    public boolean found() {
        return found;
    }
    public double ds() {
        return distance;
    }
}
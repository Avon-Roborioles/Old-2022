package org.firstinspires.ftc.teamcode.Call_Upon_Classes;

import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.robotcore.external.Telemetry;


public class Color_Sensor{
    private ColorSensor cs;
    private double threshold = 2;
    boolean correctColor;

    public void initColor(HardwareMap hardwareMap) {
        cs = hardwareMap.colorSensor.get("color");
    }
    public double getred(Telemetry telemetry){
        return cs.red();
    }
    public double getblue(Telemetry telemetry){
        return cs.blue();
    }
    public double getgreen(Telemetry telemetry){
        return cs.green();
    }
    public double getalpha(Telemetry telemetry){
        return cs.alpha();
    }

    public boolean Red(){
        return cs.red() > threshold;
    }
    public boolean blue(){
        return cs.blue() > threshold;
    }

    public void getTelemetry(Telemetry telemetry) {
        telemetry.addData("Red",cs.red());
        telemetry.addData("Green",cs.green());
        telemetry.addData("Blue",cs.blue());
        telemetry.addData("alpha",cs.alpha());
        telemetry.addData("argb",cs.argb());
    }
}

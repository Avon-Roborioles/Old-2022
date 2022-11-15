package org.firstinspires.ftc.teamcode.Call_Upon_Classes;

import com.qualcomm.robotcore.hardware.*;

import org.firstinspires.ftc.robotcore.external.Telemetry;


public class Turntable_21945 {
    //CHANGE TO NON CONTINUOUS
    // Turntable power
    private double tp = 0;
    // Turntable servo
    private CRServo ts = null;

    // joystick right
    private double rj = 0;
    private boolean rb = false;
    private boolean lb = false;


    public void init_turntable_21945(HardwareMap hardwareMap, String name){
        // Mapping the turntable
        ts = hardwareMap.get(CRServo.class, name);
    }
    public void run_turntable_21945(Gamepad gamepad, Telemetry telemetry){
        // Buttons

        rj = gamepad.right_stick_x;
        rb = gamepad.right_bumper;
        lb = gamepad.left_bumper;

        // Turntable power set
        // (We might have to reverse this)
        if(rj > 0.2){
            tp = rj * 0.2;
        }
        else if(rj < -0.2){
            tp = rj * 0.2;
        }
        else {
            tp = 0;
        }
        if(rb){
            tp = 0.05;
        }
        else if(lb){
            tp = -0.05;
        }
        else {
            tp = 0;
        }
        // Set servo power to turntable power "tp" var (turntable)
        ts.setPower(tp);

        Get_telemetry(telemetry);
    }
    public void Get_telemetry( Telemetry telemetry){
        telemetry.addData(" turntable power", ts.getPower());
    }
}

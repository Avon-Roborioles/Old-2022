package org.firstinspires.ftc.teamcode.Call_Upon_Classes;

import com.qualcomm.robotcore.hardware.*;

import org.firstinspires.ftc.robotcore.external.Telemetry;


public class Turntable_21945 {
    //CHANGE TO NON CONTINUOUS
    // Turntable power
    private double tp = 0;
    // Turntable servo
    private CRServo ts = null;

    // joystick left
    private double rj = 0;

    public void init_turntable_21945(HardwareMap hardwareMap, String name){
        // Mapping the turntable
        ts = hardwareMap.get(CRServo.class, name);
    }
    public void run_turntable_21945(Gamepad gamepad, Telemetry telemetry){
        // Buttons

        rj = gamepad.right_stick_x;

        // Turntable power set
        // (We might have to reverse this)
        if(rj > 0.5){
            tp = 0.4;
        }
        else if(rj < -0.5){
            tp = -0.4;
        }
        else {
            tp = 0;
        }
        // Set servo power to turntable power "tp" var (turntable)
        ts.setPower(tp);

        Get_telemetry(telemetry);
    }
    public void Get_telemetry( Telemetry telemetry){
        telemetry.addData("power", ts.getPower());
    }
}

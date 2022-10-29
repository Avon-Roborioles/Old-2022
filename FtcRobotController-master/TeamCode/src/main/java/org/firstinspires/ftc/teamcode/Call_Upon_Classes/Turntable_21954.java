package org.firstinspires.ftc.teamcode.Call_Upon_Classes;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Turntable_21954 {
    //turntable power
    private double tp = 0;
    //turntable servo
    private CRServo ts = null;
    //D pad buttons
    //right
    private boolean dr = false;
    //left
    private boolean dl = false;

    public void init_turntable_21954(HardwareMap hardwareMap, String name){
        ts = hardwareMap.get(CRServo.class, "ts");
    }
    public void run_turntable_21954(Gamepad gamepad, Telemetry telemetry){
        //buttons
        dr = gamepad.dpad_right;
        dl = gamepad.dpad_left;

        // We might have to reverse this

        if(dr){
            tp = 0.4;
        }
        else if(dl){
            tp = -0.4;
        }
        else {
            tp = 0;
        }
        //set servo power to turntable power "tp" var
        ts.setPower(tp);
    }
}

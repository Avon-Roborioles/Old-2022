package org.firstinspires.ftc.teamcode.Call_Upon_Classes;

import com.qualcomm.robotcore.hardware.*;

import org.firstinspires.ftc.robotcore.external.Telemetry;


public class Turntable_21945 {
    private Servo turntableServo = null;
    private double turntablePos = 0.5;
    private double rightJoystick = 0;
    private double rightTrigger = 0;
    private boolean aButton = false;

    public void init_turntable_21945(HardwareMap hardwareMap, String name){
        turntableServo = hardwareMap.get(Servo.class, "ts");
    }
    public void run_turntable_21945( Gamepad gamepad, Telemetry telemetry){
        aButton = gamepad.a;
        rightTrigger = gamepad.right_trigger;
        rightJoystick = gamepad.right_stick_x;

        if(rightJoystick > 0.2){
            turntablePos = turntablePos + 0.001;
        }
        else if(rightJoystick < -0.2){
            turntablePos = turntablePos - 0.001;
        }
        else if(rightTrigger > 0.5){
            turntablePos =0.5;
        }
        else if(aButton){
            turntablePos = 0.5;
        }

        if(turntablePos > 0.5935){
            turntablePos = 0.5634;
        }
        else if(turntablePos < 0.0){
            turntablePos = 0;
        }
        turntableServo.setPosition(turntablePos);
        Get_telemetry(telemetry);
    }

    public void run_turntable_21945_auto(Telemetry telemetry, double tp){
        turntableServo.setPosition(tp);
    }
    public void Get_telemetry( Telemetry telemetry){
        telemetry.addData("Turntable Position", turntableServo.getPosition());
    }
}

package org.firstinspires.ftc.teamcode.Call_Upon_Classes;

import com.qualcomm.robotcore.hardware.*;

import org.firstinspires.ftc.robotcore.external.Telemetry;


public class Turntable_21945 {
    // Turntable power

    private Servo turntableServo = null;
    // joystick right
    private double rightJoystick = 0;
    private boolean rightBumper = false;

    private double turntablePos = 0.5;

    private boolean aButton = false;



    public void init_turntable_21945(HardwareMap hardwareMap, String name){
        // Mapping the turntable
        //ts = hardwareMap.get(CRServo.class, name);
        turntableServo = hardwareMap.get(Servo.class, "ts");
    }
    public void run_turntable_21945( Gamepad gamepad, Telemetry telemetry){
        // Buttons
        aButton = gamepad.a;
        rightBumper = gamepad.right_bumper;
        rightJoystick = gamepad.right_stick_x;


        // Turntable power set
        //right limit is 5635


        if(rightJoystick > 0.2){
            //joystick control
            turntablePos = turntablePos + 0.001;
        }
        else if(rightJoystick < -0.2){
            //joystick control
            turntablePos = turntablePos - 0.001;
        }
        else if(rightBumper){
            //middle pos
            turntablePos =0.5;
        }
        else if(aButton){
            //drive pos
            turntablePos = 0.5;
        }

        if(turntablePos > 0.5935){
            turntablePos = 0.5635;
        }
        else if(turntablePos < 0.0){
            turntablePos = 0;
        }
        turntableServo.setPosition(turntablePos);
        Get_telemetry(telemetry);
    }

    public void run_turntable_21945_auto(Telemetry telemetry, double tp){
    //tp = target pos
        turntableServo.setPosition(tp);

    }
    public void Get_telemetry( Telemetry telemetry){
        telemetry.addData("Turntable Position", turntableServo.getPosition());
    }


}

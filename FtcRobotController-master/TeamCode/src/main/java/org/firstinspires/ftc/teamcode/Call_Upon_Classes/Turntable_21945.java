package org.firstinspires.ftc.teamcode.Call_Upon_Classes;

import com.qualcomm.robotcore.hardware.*;

import org.firstinspires.ftc.robotcore.external.Telemetry;


public class Turntable_21945 {
    // Turntable power
    //private double tp = 0;
    // Turntable servo
    //private CRServo ts = null;
    private Servo ts = null;
    // joystick right
    private double rj = 0;
    private boolean rb = false;
    private boolean lb = false;
    private double tp = 0.5;
    private boolean a = false;



    public void init_turntable_21945(HardwareMap hardwareMap, String name){
        // Mapping the turntable
        //ts = hardwareMap.get(CRServo.class, name);
        ts = hardwareMap.get(Servo.class, name);
    }
    public void run_turntable_21945( Gamepad gamepad, Telemetry telemetry){
        // Buttons
        a = gamepad.a;
        rb = gamepad.right_bumper;
        rj = gamepad.right_stick_x;
        lb = gamepad.left_bumper;

        // Turntable power set
        // (We might have to reverse this)
//        if(rj > 0.2){
//            tp = rj * 0.3;
//        }
//        else if(rj < -0.2){
//            tp = rj * 0.3;
//        }
//        else if(rb){
//            tp = 0.1;
//        }
//        else if(lb){
//            tp = -0.1;
//        }
//        else {
//            tp = 0;
//        }
//        // Set servo power to turntable power "tp" var (turntable)
//        ts.setPower(tp);
        if(rj > 0.2){
            //joystick control
            tp = tp + 0.0005;
        }
        else if(rj < -0.2){
            //joystick control
            tp = tp - 0.0005;
        }
        else if(rb){
            //middle pos
            tp =0.5;
        }
        else if(a){
            //drive pos
            tp = 0.5;
        }

        if(tp > 0.5935){
            tp = 0.5635;
        }
        else if(tp < 0.0){
            tp = 0;
        }
        ts.setPosition(tp);
        Get_telemetry(telemetry);
    }

    public void turntable_21945_auto(Telemetry telemetry, double tp, double ttaP){
    //tp = turntable pos ttaP = turntable target pos

    }
    public void Get_telemetry( Telemetry telemetry){
        telemetry.addData("Turntable Position", ts.getPosition());
    }
}

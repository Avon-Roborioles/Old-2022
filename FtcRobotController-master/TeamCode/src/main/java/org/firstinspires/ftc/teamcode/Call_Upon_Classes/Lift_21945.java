package org.firstinspires.ftc.teamcode.Call_Upon_Classes;

import com.qualcomm.robotcore.hardware.*;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Lift_21945 {
    // Lift power linear
    private double lp = 0;
    // Lift motor linear
    private DcMotor lm = null;
    // Right joystick y linear
    private double rj = 0;
    // Lift power 4 bar
    private double lp4 = 0;
    // Lift servo 4 bar left
    //private CRServo ls4l = null;
    private Servo ls4l = null;
    //private CRServo ls4r = null;
    // Left joystick y 4 bar
    private double lj = 0;
    private boolean a = false;
    private boolean lb = false;
    private boolean b = false;
    private boolean x = false;
    private boolean y = false;
    private boolean a1 = false;

    public void init_lift_motor_21945(HardwareMap hardwareMap, String name) {
        // Lift motor linear mapping
        lm = hardwareMap.get(DcMotor.class, "lm");

        // Lift servos 4 bar mapping
        //ls4l = hardwareMap.get(CRServo.class, "ls4l");
        ls4l = hardwareMap.get(Servo.class, "ls4l");
        //ls4r = hardwareMap.get(CRServo.class, "ls4r");

        // Power behavior (if 0 then stop)
        lm.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        //auto
        //lm.setTargetPosition(0);

    }
    public void run_lift_motor_21945(Gamepad gamepad1, Gamepad gamepad2, Telemetry telemetry) {
        // Linear lift button controls
        lj = gamepad2.left_stick_y;
        // 4 bar lift button controls
        rj = gamepad2.right_stick_y;
        a = gamepad2.a;
        lb = gamepad2.left_bumper;
        b = gamepad2.b;
        x = gamepad2.x;
        y = gamepad2.y;
        a1 = gamepad1.a;

        // linear lift power set (move)
        if(rj > 0.1) {
            lp = -1 * Math.abs(rj);
        }
        else if(rj < -0.1) {
            lp = 0.5 * rj;
        }
        else {
            lp = 0;
        }        // Set motor power to lift power "lp" var (Lift power)
        lm.setPower(lp);

        // 4 bar lift power set (move)
        //Continuous
//        if(lj > 0.2) {
//            lp4 = 0.5 * lj;
//        }
//        else if(lj < -0.2){
//            lp4 = 0.5 * lj;
//        }
//        else {
//            lp4 = 0;
//        }
        //normal servo
        if(lj > 0.2){
            lp4 = lp4 + 0.005;
        }
        else if(lj < 0.2){
            lp4 = lp4 - 0.005;
        }
        else if(lb){
            //all the way down to flip cone up
            lp4 = 0;
        }
        else if(a){
            //drive pos
            lp4 = 0.1;
        }
        else if(x){
            //down enough to pickup cone
            lp4 = 0;
        }
        else if(y){
            //just above cone
            lp4 = 0.2;
        }
        else if(b){
            //top for low junction
            lp4 = 0.9;
        }
        else if(a1){
            //driver 1 pos
            lp4 = 0.1;
        }

        if(lp4 > 1){
            lp4 = 1;
        }
        else if(lp4 < 0){
            lp4 = 0;
        }

        // Set servo powers to 4 bar lift power "lp4" var (4 bar power)
        //ls4l.setPower(lp4);
        //ls4r.setPower(lp4 * -1);
        ls4l.setPosition(lp4);
        get_telemetry(telemetry);
    }
    public void run_lift_21945_auto(Telemetry telemetry){

    }
    public void get_telemetry (Telemetry telemetry){
        telemetry.addData("4-Bar Position", ls4l.getPosition());
    }
}

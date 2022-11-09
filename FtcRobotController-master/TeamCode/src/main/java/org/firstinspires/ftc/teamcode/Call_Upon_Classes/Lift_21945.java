package org.firstinspires.ftc.teamcode.Call_Upon_Classes;

import com.qualcomm.robotcore.hardware.*;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Lift_21945 {
    // Lift power linear
    private double lp = 0;
    // Lift motor linear
    private DcMotor lm = null;
    // Right joystick linear
    private double rj = 0;


    // Lift power 4 bar
    private double lp4 = 0;
    // Lift servo 4 bar left
    private CRServo ls4l = null;
    //private CRServo ls4r = null;
    // Left joystick 4 bar
    private double lj = 0;





    public void init_lift_motor_21945(HardwareMap hardwareMap, String name) {
        // Lift motor linear mapping
        lm = hardwareMap.get(DcMotor.class, "lm");

        // Lift servos 4 bar mapping
        ls4l = hardwareMap.get(CRServo.class, "ls4l");
        //ls4r = hardwareMap.get(CRServo.class, "ls4r");

        // Power behavior (if 0 then stop)
        lm.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }
    public void run_lift_motor_21945(Gamepad gamepad, Telemetry telemetry) {
        // Linear lift button controls
        lj = gamepad.left_stick_y;
        // 4 bar lift button controls
        rj = gamepad.right_stick_y;

        // linear lift power set (move)
        if(rj > 0.2) {
            lp = -0.4;
        }
        else if(rj < -0.2) {
            lp = 0.4;
        }
        else {
            lp = 0;
        }
        // Set motor power to lift power "lp" var (Lift power)
        lm.setPower(lp);

        // 4 bar lift power set (move)
        if(lj > 0.2) {
            lp4 = 0.4;
        }
        else if(lj < -0.2){
            lp4 = -0.4;
        }
        else {
            lp4 = 0;
        }
        // Set servo powers to 4 bar lift power "lp4" var (4 bar power)
        ls4l.setPower(lp4);
        //ls4r.setPower(lp4 * -1);




    }

}

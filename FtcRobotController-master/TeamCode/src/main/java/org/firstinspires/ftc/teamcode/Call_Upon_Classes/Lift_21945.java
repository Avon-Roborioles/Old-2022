package org.firstinspires.ftc.teamcode.Call_Upon_Classes;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Lift_21945 {
    // Lift power linear
    private double linLiftPos = 0;
    // Lift motor linear
    private DcMotor linLiftMotor = null;
    // Right joystick y linear
    private double rightJoystick = 0;
    // Lift power 4 bar
    private double liftPos4Bar = 0;
    // Lift servo 4 bar left
    private Servo liftServo4Bar = null;
    //private CRServo ls4r = null;
    // Left joystick y 4 bar
    private double leftJoystick = 0;
    private boolean aButton = false;
    private double leftTrigger;
    private boolean bButton = false;
    private boolean xButton = false;
    private boolean yButton = false;
    //if we need to reverse the direction of the linear  change this from 1 to -1 or vice versa
    private double linLiftDirection = 1;


    public void init_lift_motor_21945(HardwareMap hardwareMap, String name) {
        // Lift motor linear mapping
        linLiftMotor = hardwareMap.get(DcMotor.class, "lm");

        // Lift servos 4 bar mapping
        liftServo4Bar = hardwareMap.get(Servo.class, "ls4");


        // Power behavior (if 0 then stop)
        linLiftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        //auto
        linLiftMotor.setTargetPosition(0);

    }

    public void run_lift_motor_21945(Gamepad gamepad, Telemetry telemetry) {
        // Linear lift button controls
        leftJoystick = gamepad.left_stick_y;
        // 4 bar lift button controls
        rightJoystick = gamepad.right_stick_y;
        aButton = gamepad.a;
        leftTrigger = gamepad.left_trigger;
        bButton = gamepad.b;
        xButton = gamepad.x;
        yButton = gamepad.y;

        // linear lift power set (move)
//        if (linLiftDirection == 1){
//            if (rightJoystick < -0.1) {
//                linLiftPower = 0.5 * Math.abs(rightJoystick);
//            } else if (rightJoystick > 0.1) {
//                linLiftPower = -0.5 * Math.abs(rightJoystick);
//            } else {
//                linLiftPower = 0;
//            }
//        }
//        if (linLiftDirection == -1) {
//            if (rightJoystick < -0.1) {
//                linLiftPower = -1 * Math.abs(rightJoystick);
//            } else if (rightJoystick > 0.1) {
//                linLiftPower = 1 * Math.abs(rightJoystick);
//            } else {
//                linLiftPower = 0;
//            }
//        }
        if (linLiftDirection == 1){
            if (rightJoystick < -0.1) {
                linLiftPos += 1;
            } else if (rightJoystick > 0.1) {
                linLiftPos += 1;
            }
            if (linLiftPos > 1995){
                linLiftPos = 1994;
            }
        }
        if (linLiftDirection == -1) {
            if (rightJoystick < -0.1) {
                linLiftPos += 0.005;
            } else if (rightJoystick > 0.1) {
                linLiftPos += 0.005;
            } else {
                linLiftPos = 0;
            }
        }
        // Set motor power to lift power "lp" var (Lift power)
        linLiftMotor.setPower(linLiftPos);

        //normal servo
        if (leftJoystick > 0.2) {
            liftPos4Bar = liftPos4Bar - 0.0005;
        } else if (leftJoystick < -0.2) {
            liftPos4Bar = liftPos4Bar + 0.0005;
        } else if (leftTrigger > 0.5) {
            //all the way down to flip cone up
            liftPos4Bar = 0;
        } else if (aButton) {
            //drive pos
            liftPos4Bar = 0;
        } else if (yButton) {
            //down enough to pickup cone
            liftPos4Bar = 0.01;
        } else if (bButton) {
            //just above cone
            liftPos4Bar = 0.2;
        } else if (xButton) {
            //top for low junction
            liftPos4Bar = 1;
        }

        if (liftPos4Bar > 0.375) {
            liftPos4Bar = 0.375;
        } else if (liftPos4Bar < 0) {
            liftPos4Bar = 0;
        }
//top stop 0.375
        // Set servo powers to 4 bar lift power
        liftServo4Bar.setPosition(liftPos4Bar);

        get_telemetry(telemetry);
    }

    public void run_lift_21945_auto(Telemetry telemetry, double l4h) {
        liftServo4Bar.setPosition(l4h * 0.375);


    }





    public void get_telemetry (Telemetry telemetry){
        telemetry.addData("4-Bar Position", liftServo4Bar.getPosition());
        telemetry.addData("Linear lift Position", linLiftMotor.getCurrentPosition());
    }
}

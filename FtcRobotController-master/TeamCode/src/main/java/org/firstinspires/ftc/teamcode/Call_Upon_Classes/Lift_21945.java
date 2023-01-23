package org.firstinspires.ftc.teamcode.Call_Upon_Classes;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Lift_21945 {
    private DcMotor linLiftMotor = null;
    private Servo liftServo4Bar = null;
    private double rightJoystick = 0;
    private double leftJoystick = 0;
    private boolean dPadRight = false;
    private boolean dPadLeft = false;
    private boolean dPaddown = false;
    private boolean dPadUp = false;
    private boolean aButton = false;
    private boolean bButton = false;
    private boolean xButton = false;
    private boolean yButton = false;
    private double leftTrigger;
    private double linLiftDirection = 1;
    private double linLiftPos = 0;
    private double liftPos4Bar = 0;
    private double maxLinLiftPos = 1995;
    private double minLinLiftPos = 0;
    private double mediumLin = 1994;
    private double medium4Bar = 1;
    private double lowLin = 0;
    private double low4Bar = 1;
    private double groundLin = 0;
    private double ground4Bar = 0.1;

    public void init_lift_motor_21945(HardwareMap hardwareMap, String name) {
        linLiftMotor = hardwareMap.get(DcMotor.class, "lm");
        liftServo4Bar = hardwareMap.get(Servo.class, "ls4");
        linLiftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        linLiftMotor.setTargetPosition(0);

    }

    public void run_lift_motor_21945(Gamepad gamepad, Telemetry telemetry) {
        rightJoystick = gamepad.right_stick_y;
        leftJoystick = gamepad.left_stick_y;
        leftTrigger = gamepad.left_trigger;
        aButton = gamepad.a;
        bButton = gamepad.b;
        xButton = gamepad.x;
        yButton = gamepad.y;
        dPadUp = gamepad.dpad_up;
        dPaddown = gamepad.dpad_down;
        dPadLeft = gamepad.dpad_left;
        dPadRight = gamepad.dpad_right;
        if (linLiftDirection == 1){
            if (rightJoystick < -0.1) {
                linLiftPos += 15;
            } else if (rightJoystick > 0.1) {
                linLiftPos -= 15;
            }
            if (linLiftPos > maxLinLiftPos){
                linLiftPos = maxLinLiftPos;
            }
            else if (linLiftPos < minLinLiftPos){
                linLiftPos = minLinLiftPos;
            }
        }

        if (linLiftDirection == -1) {
            if (rightJoystick < -0.1) {
                linLiftPos -= 1;
            } else if (rightJoystick > 0.1) {
                linLiftPos += 1;
            }
            if (linLiftPos < (maxLinLiftPos * -1)){
                linLiftPos = maxLinLiftPos * -1;
            }
            else if (linLiftPos > minLinLiftPos ){
                linLiftPos = minLinLiftPos;
            }
        }
        if (leftJoystick > 0.2) {
            if (bButton) {
                liftPos4Bar -= 0.0125;
            }else {
                liftPos4Bar -= 0.125;
            }
            if (!bButton){
                liftPos4Bar -= 0.125;
            }
        } else if (leftJoystick < -0.2) {
            if (bButton) {
                //just above cone
                liftPos4Bar += 0.0075;
            }else {
                liftPos4Bar += 0.0075;
            }
        }
        //else if (leftTrigger > 0.5) {
         //   liftPos4Bar = 0;

        //}
        if (aButton) {
            //drive pos
            liftPos4Bar = 0;
        } else if (yButton) {
            //down enough to pickup cone
            liftPos4Bar = 0.1;
        }
        else if (xButton) {
            //top for low junction
            liftPos4Bar = 1;
        }
        //set points
        if (dPaddown){
            linLiftPos = 0;
            liftPos4Bar = 0;
        }else if (dPadUp) {
            linLiftPos = mediumLin;
            liftPos4Bar = medium4Bar;
        }else if (dPadLeft){
            linLiftPos = lowLin;
            liftPos4Bar = low4Bar;
        }else if (dPadRight){
            linLiftPos = groundLin;
            liftPos4Bar = ground4Bar;
        }
        //limits
        // 4 bar top stop 0.375
        if (liftPos4Bar >1){
            liftPos4Bar = 1;
        }
        if (liftPos4Bar < 0) {
            liftPos4Bar = 0;
        }



        linLiftMotor.setTargetPosition((int) linLiftPos);
        linLiftMotor.setPower(.75);
        linLiftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        liftServo4Bar.setPosition(liftPos4Bar * 0.375);
        get_telemetry(telemetry);
    }

    public void run_lift_21945_auto(Telemetry telemetry, double lift4height, int linLiftHeight) {
        liftServo4Bar.setPosition(lift4height * 0.375);
        linLiftMotor.setTargetPosition(linLiftHeight);
        linLiftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        linLiftMotor.setPower(0.5);

    }

    public void get_telemetry (Telemetry telemetry){
        telemetry.addData("4-Bar  Position", liftServo4Bar.getPosition()/0.375);
        telemetry.addData("4-Bar Servo Position", liftServo4Bar.getPosition());
        telemetry.addData("Linear lift Current Position", linLiftMotor.getCurrentPosition());
        telemetry.addData("Linear lift Target Position", linLiftMotor.getTargetPosition());
    }
}

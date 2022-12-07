package org.firstinspires.ftc.teamcode.Call_Upon_Classes;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Intake_21945 {
    private CRServo intakeServo = null;
    private boolean rightBumper = false;
    private boolean leftBumper = false;
    private double intakePower = 0;

    public void init_intake_motor_21945(HardwareMap hardwareMap, String name) {
        intakeServo = hardwareMap.get(CRServo.class, "is");
    }
    public void run_intake_motor_21945(Gamepad gamepad, Telemetry telemetry){
        rightBumper = gamepad.right_bumper;
        leftBumper = gamepad.left_bumper;

        if(rightBumper){
            intakePower =1;
        }
        else if(leftBumper){
            intakePower =-1;
        }
        else  {
            intakePower = 0;
        }
        intakeServo.setPower(intakePower);
    }
    public void run_intake_21945_auto(Telemetry telemetry, double direction ){
        intakeServo.setPower(direction * 0.5);
        telemetry.update();
   }
    public void get_telemetry (Telemetry telemetry){
        telemetry.addData("Intake power", intakePower);
    }
}

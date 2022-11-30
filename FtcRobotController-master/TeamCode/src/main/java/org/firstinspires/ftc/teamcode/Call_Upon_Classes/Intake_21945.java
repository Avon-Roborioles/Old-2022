package org.firstinspires.ftc.teamcode.Call_Upon_Classes;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Intake_21945 {
    // Intake power
    private double intakePower = 0;
    // Intake servo
    private CRServo intakeServo = null;

    private double rightTrigger = 0;
    private double leftTrigger = 0;

    // Init
    public void init_intake_motor_21945(HardwareMap hardwareMap, String name) {
        intakeServo = hardwareMap.get(CRServo.class, "is");
    }
    // Run
    // Method
    public void run_intake_motor_21945(Gamepad gamepad, Telemetry telemetry){
        // Assign button "a"
        rightTrigger = gamepad.right_trigger;
        leftTrigger = gamepad.left_trigger;


        if(rightTrigger > 0.1){
            intakePower =1;
        }
        else if(leftTrigger > 0.1){
            intakePower =-1;
        }
        else  {
            intakePower = 0;
        }



        // Set servo power to intake power "ip" var
        intakeServo.setPower(intakePower);
    }
    public void run_intake_21945_auto(Telemetry telemetry, double direction ){
        intakeServo.setPower(direction * 0.5);




    }


}

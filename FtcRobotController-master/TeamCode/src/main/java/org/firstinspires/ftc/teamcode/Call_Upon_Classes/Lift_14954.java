package org.firstinspires.ftc.teamcode.Call_Upon_Classes;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Lift_14954 {
    private double speed = 0;

    private DcMotor lift = null;

    private double le = 0;
    private double min = 0;
    private double max = 3325;
    public void init_lift (HardwareMap map, String name) {
        lift  = map.get(DcMotor.class, name);
        lift.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        lift.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//        lift.setTargetPosition(0);
//        lift.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        lift.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        int pos = lift.getCurrentPosition();
    }

    //simple arm program to move arm up will work on position holding soon
    public void runlift(Gamepad gp, Telemetry telemetry) {
        double ltrigger = gp.left_trigger;
        double rtrigger = gp.right_trigger;
        if (le > min && le < max) {
            if (ltrigger > 0) {
                speed = .6;
            } else if (rtrigger > 0) {
                speed = -.3;
            }
            else {
                speed = 0;
            }
        }
        else if (le < min){
            lift.setTargetPosition(2);
            lift.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        }
        else if (le > max) {
            lift.setTargetPosition(3323);
            lift.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        }
        else {
            lift.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            speed = 0;
        }

        lift.setPower(speed);
        le = lift.getCurrentPosition();
        telemetry.addData("Lift Encoder: ", le);
    }

    //attempt for main lift program that hold position
    public void runlift2(Gamepad gp, Telemetry telemetry) {

    }


}

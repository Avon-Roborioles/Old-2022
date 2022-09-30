package org.firstinspires.ftc.teamcode.Call_Upon_Classes;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Lift_14954 {
    private double speed = 0;

    private DcMotor lift = null;

    public void init_lift (HardwareMap map, String name) {
        lift  = map.get(DcMotor.class, name);
        lift.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    //simple arm program to move arm up will work on position holding soon
    public void runlift(Gamepad gp, Telemetry telemetry) {
        double ltrigger = gp.left_trigger;
        double rtrigger = gp.right_trigger;

        if (ltrigger > 0) {
            speed = .6;
        } else if (rtrigger > 0 ) {
            speed = -.6;
        } else {
            speed = 0;
        }

        lift.setPower(speed);
    }

    //attempt for main lift program that hold position
    public void runlift2(Gamepad gp, Telemetry telemetry) {

    }


}

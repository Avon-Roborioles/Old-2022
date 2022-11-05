package org.firstinspires.ftc.teamcode.Call_Upon_Classes;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Lift_14954 {
    private double speed = 0;

    private DcMotor lift = null;
    private int max = 4300;
    private int top = 4100;
    private int mid = 2980;
    private int low = 1850;
    int currentTarget = 0;
    private boolean a = false;
    private boolean x = false;
    private boolean y = false;
    private boolean b = false;
    double ltrigger;
    double rtrigger;


    public void init_lift (HardwareMap map, String name) {
        lift  = map.get(DcMotor.class, name);
        lift.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        lift.setTargetPosition(0);
    }

    //old method to use any time
    public void runlift(Gamepad gp, Telemetry telemetry) {
        int pos = lift.getCurrentPosition();

        double ltrigger = gp.left_trigger;
        double rtrigger = gp.right_trigger;

        if (ltrigger > 0) {
            speed = .6;
        } else if (rtrigger > 0 ) {
            speed = -.1;
        } else if (pos == 0 || pos == max ){
            speed = 0;
        } else {
            speed = 0;
        }

        lift.setPower(speed);
        telemetry.addData("encoder: ", pos);
    }

    public void runlift2 (Gamepad gp, Telemetry telemetry) {
        a = gp.a;
        x = gp.x;
        y = gp.y;
        b = gp.b;
          ltrigger = gp.left_trigger;
          rtrigger = gp.right_trigger;
        double pos = lift.getCurrentPosition();

        //buttons for auto control
        if (a) {
            lift.setTargetPosition(0);
            currentTarget = 0;
        } else if (x) {
            lift.setTargetPosition(low);
            currentTarget = low;
        } else if (y) {
            lift.setTargetPosition(mid);
            currentTarget = mid;
        } else if (b) {
            lift.setTargetPosition(top);
            currentTarget = top;
        }

//        //triggers for manual control
//        while (ltrigger > 0 && rtrigger == 0) {
//            lift.setMode(Ru);
//            lift.setTargetPosition((int) (pos + 5));
//        }
//
//        while (rtrigger > 0 && ltrigger == 0) {
//            lift.setTargetPosition((int) (pos - 5));
//        }
        //manual control
        if (rtrigger > 0) {
            currentTarget = currentTarget + 10;
            lift.setTargetPosition(currentTarget);

        } else if (ltrigger > 0) {
            currentTarget = currentTarget - 10;
            lift.setTargetPosition(currentTarget);
        }


        //limits for lift height; both cei
        if (currentTarget > max) {
            lift.setTargetPosition(top);
            currentTarget = top;
        } else if (currentTarget < 0) {
            lift.setTargetPosition(0);
            currentTarget = 0;
        }


        lift.setPower(.5);
        lift.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        get_telemetry(telemetry);
    }

    //main lift function for autonomous
    public void runlift_auto(Telemetry telemetry) {
        lift.setTargetPosition(top);
        lift.setPower(.5);
        lift.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//        lift.setPower(0);
//        lift.setTargetPosition(mid);
//        lift.setPower(.5);
//        lift.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//        lift.setPower(0);
//        lift.setTargetPosition(low);
//        lift.setPower(.5);
//        lift.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

    public void get_telemetry (Telemetry telemetry) {
        telemetry.addData("Lift Position: ", lift.getCurrentPosition());
        telemetry.addData("Current Target: ", currentTarget);
        telemetry.addData("Left Trigger: ", ltrigger);
        telemetry.addData("Right Trigger: ", rtrigger);
    }
}

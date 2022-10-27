package org.firstinspires.ftc.teamcode.Call_Upon_Classes;

import com.qualcomm.robotcore.hardware.*;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Lift_21954 {
    //lift power linear
    private double lp = 0;
    //lift motor linear
    private DcMotor lm = null;
    //Right bumper linear
    private boolean rb = false;
    //left bumper linear
    private boolean lb = false;
    //lift power 4 bar
    
    private void init_lift_motor_21954(HardwareMap hardwareMap) {
        lm = hardwareMap.get(DcMotor.class, "lm");
    }
    private void run_lift_motor_21954(Gamepad gamepad, Telemetry telemetry) {
        //linear lift
        rb = gamepad.right_bumper;
        lb = gamepad.left_bumper;
        if(rb) {
            lp = .4;
        }
        else if(lb) {
            lp = -.4;
        }
        else {
            lp = 0;
        }

        lm.setPower(lp);
        //4 bar lift


    }

}

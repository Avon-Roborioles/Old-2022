package org.firstinspires.ftc.teamcode.Call_Upon_Classes;

import com.qualcomm.robotcore.hardware.*;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Lift_21954 {
    //lift power
    private double lp = 0;
    //lift motor
    private DcMotor lm = null;
    //button a
    private boolean a = false;
    private void init_lift_motor_21954(HardwareMap hardwareMap) {
        lm = hardwareMap.get(DcMotor.class, "lm");
    }
    private void run_lift_motor_21954(Gamepad gamepad, Telemetry telemetry) {
        a = gamepad.a;
        if(a) {
            lp = .4;
        }
        else {
            lp = 0;
        }
        lm.setPower(lp);

    }

}

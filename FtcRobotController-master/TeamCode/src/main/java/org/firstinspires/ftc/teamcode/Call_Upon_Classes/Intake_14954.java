package org.firstinspires.ftc.teamcode.Call_Upon_Classes;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Intake_14954 {

    private Servo intake = null;

    private Telemetry telemetry = null;

    public void init_intake (HardwareMap map, String name) {
        intake = map.get(Servo.class, name);
    }


    public void run_intake (Gamepad gp, Telemetry telemetry) {
        double sp = 0;
        boolean lb = gp.left_bumper;
        boolean rb = gp.right_bumper;

        if (lb) {
            //intake.setPosition(.01); //need to check
            intake.setPosition(0);
        } else if (rb ) {
            intake.setPosition(1); //need to check
            //sp = -0.4;
        }
        get_telemetry(telemetry);
        //intake.setPower(sp);
    }
    public void get_telemetry (Telemetry telemetry) {
        //telemetry.addData("Position",intake.getPosition());
    }
}

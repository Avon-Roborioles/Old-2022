package org.firstinspires.ftc.teamcode.Call_Upon_Classes;

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

        boolean open = gp.x;
        boolean close = gp.b;

        if (open) {
            intake.setPosition(.01); //need to check
        } else if (close) {
            intake.setPosition(0.4); //need to check
        }
        get_telemetry(telemetry);
    }
    public void get_telemetry (Telemetry telemetry) {
        telemetry.addData("Position",intake.getPosition());
    }
}

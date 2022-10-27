package org.firstinspires.ftc.teamcode.Call_Upon_Classes;

import com.qualcomm.robotcore.hardware.*;
import org.firstinspires.ftc.robotcore.external.Telemetry;

public class arm_15455 {

    private Servo arm = null;
    private Telemetry telemetry = null;


    public void init_arm (HardwareMap map, String name) {
        arm = map.get(Servo.class, name);
    }


    public void run_arm(Gamepad gp, Telemetry telemetry) {
        boolean open = gp.x;
        boolean close = gp.b;

        if (open) {
            arm.setPosition(.01); //need to check
        } else if (close) {
            arm.setPosition(0.4); //need to check
        }
        get_telemetry(telemetry);


    }

    public void get_telemetry (Telemetry telemetry) {
        telemetry.addData("Position",arm.getPosition());
    }




}
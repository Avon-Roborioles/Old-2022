package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;


public class Intake_15455{
    private DcMotor intake = null;
    private double speed;




    public void init_intake(HardwareMap map, String name) { intake  = map.get(DcMotor.class, name); }

    public void run_intake(Gamepad gamepad1, Telemetry telemetry) {

        boolean in = gamepad1.a;
        boolean out = gamepad1.b;

        if (in) {
            speed = -1;
        } else if (out) {
            speed = .6;
        } else {
            speed = 0;
        }

        intake.setPower(speed);

        get_telemetry(telemetry);
    }

    public void autoEject() throws InterruptedException {
        intake.setPower(.6);
        Thread.sleep(1000);
        intake.setPower(0);
        Thread.sleep(250);
    }


    public void get_telemetry (Telemetry telemetry) {
        telemetry.addData("Intake Speed", speed);
    }
}

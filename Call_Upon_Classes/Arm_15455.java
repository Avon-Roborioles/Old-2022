package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.LED;

import org.firstinspires.ftc.robotcore.external.Telemetry;

import java.util.Base64;


public class Arm_15455{
    private DcMotor arm = null;
    private LED led1 = null;
    private LED led2 = null;
    private double speed;

    public void init_arm(HardwareMap map, String name) {
        arm  = map.get(DcMotor.class, name);
    }
    public void init_led(HardwareMap map, String name1, String name2){
        led1 = map.get(LED.class, name1);
        led2 = map.get(LED.class, name2);
    }

    public void run_arm(Gamepad gamepad1, Telemetry telemetry) {
        double pos = arm.getCurrentPosition()/22.7%360;
        boolean dpad_up = gamepad1.dpad_up;
        boolean dpad_down = gamepad1.dpad_down;


        if (dpad_up && (pos<=87.5 || gamepad1.back)) {
            speed = 1;
        } else if (dpad_down&& (pos>=0 || gamepad1.back)) {
            speed = -1;
        } else {
            speed = 0;
        }



        arm.setPower(speed);

        get_telemetry(telemetry);
    }

    public void get_telemetry (Telemetry telemetry) {
        telemetry.addData("arm encoder", arm.getCurrentPosition());
        telemetry.addData("Arm Speed", speed);
    }

    public void autoArmUp(int pos){
        if (pos==0) {arm.setTargetPosition(45);}
        if (pos==1) {arm.setTargetPosition((int) (40*22.7));}
        if (pos==2) {arm.setTargetPosition((int) (60*22.7));}
        if (pos>=3) {arm.setTargetPosition((int) (87.5*22.7));}
        arm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        arm.setPower(.75);
        while (arm.isBusy()){}
        arm.setPower(0);

    }

    public void autoArmDown() {
        arm.setTargetPosition(50);
        arm.setPower(-1);
        while (arm.getCurrentPosition()>40){
//            double previousPosition = arm.getCurrentPosition();

            if (arm.getCurrentPosition()>88*22.7) // || arm.getCurrentPosition() > previousPosition)
                break;
        }
        arm.setPower(0);

    }
    public void leds() {
        led1.enableLight(true);



    }







}

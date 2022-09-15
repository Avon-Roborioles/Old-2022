package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;


public class Arm_14954 {

    private DcMotor armlift1 = null;
    private DcMotor armlift2 = null;
    private double speed = .6;



    public void init_armlift (HardwareMap map, String name1, String name2) {
        armlift1  = map.get(DcMotor.class, name1);
        armlift2  = map.get(DcMotor.class, name2);
        armlift1.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        armlift2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        //armlift1.setDirection(DcMotorSimple.Direction.REVERSE);
        //armlift2.setDirection(DcMotorSimple.Direction.REVERSE);

    }

    public void run_arm(Gamepad gp, Telemetry telemetry) {

        double ltrigger = gp.left_trigger;
        double rtrigger = gp.right_trigger;
        
        if (ltrigger > 0) {
            speed = .6;
        } else if (rtrigger > 0 ) {
            speed = -.6;
        } else {
            speed = 0;
        }

        armlift1.setPower(speed);
        armlift2.setPower(speed);

        get_telemetry(telemetry);
    }
    
    public void run_armv2 (Gamepad gp, Telemetry telemetry) throws InterruptedException {
        double up = gp.right_trigger;
        double down = gp.left_trigger;
        boolean dpadispressed = gp.dpad_down;

        //normal arm movement
        if (up > 0) {
            speed = .6;
        } else if (down > 0 ) {
            speed = -.6;
        } else {
            speed = 0;
        }

        armlift1.setPower(speed);
        armlift2.setPower(speed);


        get_telemetry(telemetry);

    }

    public void arm_auto (int position) {
        if (position == 1) {
            armlift1.setTargetPosition(-200);
            armlift2.setTargetPosition(-200);
        }

        if (position == 2) {
            armlift1.setTargetPosition(-300);
            armlift2.setTargetPosition(-300);
        }

        if (position == 3) {
            armlift1.setTargetPosition(-400);
            armlift2.setTargetPosition(-400);
        }

        armlift1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        armlift2.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        armlift1.setPower(0.75);
        armlift2.setPower(0.75);
//        while (armlift1.isBusy() && armlift2.isBusy()) {}
//        armlift1.setPower(0);
//        armlift2.setPower(0);
    }

    public void arm_stop_stay () {
        armlift1.setPower(.1);
        armlift2.setPower(.1);
    }


    public boolean isBusy() {
        return armlift1.isBusy() && armlift2.isBusy();
    }

    public void get_telemetry (Telemetry telemetry) {
        telemetry.addData("Armlift Speed", speed);
        telemetry.addData("Armlift Position", armlift1.getCurrentPosition());
    }

}

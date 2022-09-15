package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous
@Disabled
public class PID_Encoder_Servo extends LinearOpMode {
    private DcMotor encoder = null;
    private CRServo servo_motor = null;

    private double position;


    @Override
    public void runOpMode() throws InterruptedException {
        encoder = hardwareMap.dcMotor.get("fr");
        position = encoder.getCurrentPosition();

        servo_motor = hardwareMap.crservo.get("motor");

        waitForStart();

        move_to_position(360);
    }

    public void move_to_position(int position) throws InterruptedException {
        servo_motor.setPower(1);

        Thread.sleep(5000);

        position = encoder.getCurrentPosition();
        telemetry.addData("Position", position);
        telemetry.addData("encoder read", (position/22.7)%360);
        telemetry.update();
        if (Math.abs((position/22.7)%360) >= 180 && Math.abs((position/22.7)%360) <= 185) {
            servo_motor.setPower(0);
            Thread.sleep(5000);
        }
    }
}

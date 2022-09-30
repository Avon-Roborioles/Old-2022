package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.teamcode.Call_Upon_Classes.Mecanum_Methods_TeleOp;


@TeleOp
public class TeleOp_14954 extends LinearOpMode {
//objects for each function of the robot
private final org.firstinspires.ftc.teamcode.Call_Upon_Classes.Mecanum_Methods_TeleOp drivingMotors = new Mecanum_Methods_TeleOp(false);


public void runOpMode() throws InterruptedException {
    //Initialize objects
    drivingMotors.init_drive_motors(hardwareMap);


    waitForStart();

    while (opModeIsActive()) {
        //Driver 1 Functions
        drivingMotors.run_drive_motors(gamepad1, telemetry); //driving


        //Driver 2 Functions

        telemetry.update();
        }
    }
}

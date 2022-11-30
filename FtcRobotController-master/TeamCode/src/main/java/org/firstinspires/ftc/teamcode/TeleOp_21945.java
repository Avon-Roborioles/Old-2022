package org.firstinspires.ftc.teamcode;

//import classes for objects;
import com.qualcomm.robotcore.eventloop.opmode.*;
import org.firstinspires.ftc.teamcode.Call_Upon_Classes.*;

@TeleOp

/*
*
* - 3 servos:3 done and tested
* - 5 DC motors: 5 done and tested
* - 1 camera: done and tested
*
*
* */

public class TeleOp_21945 extends LinearOpMode {
    // Objects for each function of the robot
    // Chassis drive motors
    private final org.firstinspires.ftc.teamcode.Call_Upon_Classes.Mecanum_Methods_TeleOp drivingMotors = new Mecanum_Methods_TeleOp(false);
    // Lift (the lift + the arm with it)
    private final org.firstinspires.ftc.teamcode.Call_Upon_Classes.Lift_21945 lift = new Lift_21945();
    // Intake (getting the cone)
    private final org.firstinspires.ftc.teamcode.Call_Upon_Classes.Intake_21945 intake = new Intake_21945();
    // Turntable (the plate to turn the table)
    private final Turntable_21945 turntable = new Turntable_21945();

    public void runOpMode() throws InterruptedException {
        // Initialize objects to run
        drivingMotors.init_drive_motors(hardwareMap);
        lift.init_lift_motor_21945(hardwareMap, "lift");
        intake.init_intake_motor_21945(hardwareMap, "intake");
        turntable.init_turntable_21945(hardwareMap, "turntable");

        waitForStart();

        while (opModeIsActive()) {
            // Driver 1 Functions


            drivingMotors.run_drive_motors(gamepad1, telemetry); // driving

            // Driver 2 Functions
            lift.run_lift_motor_21945(gamepad2, telemetry);
            intake.run_intake_motor_21945(gamepad2, telemetry);
            turntable.run_turntable_21945(gamepad2, telemetry);

            telemetry.update();
        }

    }
}

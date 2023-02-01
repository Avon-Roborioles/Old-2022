package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.*;
import org.firstinspires.ftc.teamcode.Call_Upon_Classes.*;

@TeleOp
public class TeleOp_21945 extends LinearOpMode {
    private final org.firstinspires.ftc.teamcode.Call_Upon_Classes.Mecanum_Methods_TeleOp drivingMotors = new Mecanum_Methods_TeleOp(false);
    private final org.firstinspires.ftc.teamcode.Call_Upon_Classes.Lift_21945 lift = new Lift_21945();
    private final org.firstinspires.ftc.teamcode.Call_Upon_Classes.Intake_21945 intake = new Intake_21945();
    private final org.firstinspires.ftc.teamcode.Call_Upon_Classes.Distance_Sensor distance = new Distance_Sensor();
    private int liftDriveLimit = 1;

    public void runOpMode() throws InterruptedException {
        drivingMotors.init_drive_motors(hardwareMap);
        lift.init_lift_motor_21945(hardwareMap, "lift");
        intake.init_intake_motor_21945(hardwareMap, "intake");
        distance.initDistance(hardwareMap, "distance");
        waitForStart();

        while (opModeIsActive()) {

            drivingMotors.run_drive_motors(gamepad1, telemetry); // driving
            lift.run_lift_motor_21945(gamepad2, telemetry);
            intake.run_intake_motor_21945(gamepad2, telemetry);
            distance.rundistanceTeleop(telemetry);
            telemetry.update();
        }
    }
}

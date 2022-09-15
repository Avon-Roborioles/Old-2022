package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;


@TeleOp
//@Disabled
public class Teleop_14954 extends LinearOpMode {

    //objects for each function of the robot
    private final org.firstinspires.ftc.teamcode.Mecanum_Methods_TeleOp drivingMotors = new org.firstinspires.ftc.teamcode.Mecanum_Methods_TeleOp(false);
    private final org.firstinspires.ftc.teamcode.Carousel_Call carousel = new org.firstinspires.ftc.teamcode.Carousel_Call();
    private final org.firstinspires.ftc.teamcode.Arm_14954 armlifts = new org.firstinspires.ftc.teamcode.Arm_14954();
    private final org.firstinspires.ftc.teamcode.Intake_14954 intake = new org.firstinspires.ftc.teamcode.Intake_14954();
    private final org.firstinspires.ftc.teamcode.Gate_14954 gate = new org.firstinspires.ftc.teamcode.Gate_14954();



    @Override
    public void runOpMode() throws InterruptedException {
        drivingMotors.init_drive_motors(hardwareMap);
        carousel.init_carousel(hardwareMap, "carousel", true);
        armlifts.init_armlift(hardwareMap, "armlift1", "armlift2");
        intake.init_intake(hardwareMap, "intake");
        gate.init_gate(hardwareMap, "gate");
        telemetry.addData(">>", "Start when ready!");


        waitForStart();

        while (opModeIsActive()) {
            //Driver 1 Functions
            drivingMotors.run_drive_motors(gamepad1, telemetry); //driving
            carousel.run_carousel_loop(gamepad1, telemetry); //carousel
            
            //Driver 2 Functions
            armlifts.run_armv2(gamepad2, telemetry); //arm
            intake.run_intake(gamepad2, telemetry); //intake
            gate.control_gate(gamepad2, telemetry); //intake gate

            telemetry.update();
        }
    }
}

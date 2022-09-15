package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.AnalogInput;
import com.qualcomm.robotcore.hardware.DigitalChannel;


@TeleOp

public class Teleop_15455 extends LinearOpMode {

    private org.firstinspires.ftc.teamcode.Mecanum_Methods_TeleOp drive_motors = new org.firstinspires.ftc.teamcode.Mecanum_Methods_TeleOp(false);//set false for left strafe
    private org.firstinspires.ftc.teamcode.Carousel_Call carousel = new org.firstinspires.ftc.teamcode.Carousel_Call();
    private org.firstinspires.ftc.teamcode.Turntable_15455 turntable = new org.firstinspires.ftc.teamcode.Turntable_15455();
    private org.firstinspires.ftc.teamcode.Arm_15455 arm = new org.firstinspires.ftc.teamcode.Arm_15455();
    private org.firstinspires.ftc.teamcode.Intake_15455 intake = new org.firstinspires.ftc.teamcode.Intake_15455();
    private org.firstinspires.ftc.teamcode.Impaler_15455 impaler = new org.firstinspires.ftc.teamcode.Impaler_15455();

    @Override
    public void runOpMode() throws InterruptedException {
        drive_motors.init_drive_motors(hardwareMap);
        carousel.init_carousel(hardwareMap, "carousel", true);
        turntable.init_turntable(hardwareMap, telemetry, "turntable");
        intake.init_intake(hardwareMap, "intake");
        arm.init_arm(hardwareMap, "arm");
        impaler.init_impaler(hardwareMap,telemetry);



        waitForStart();
        //turntable.turntable_test();
        while (opModeIsActive()) {
            drive_motors.run_drive_motors(gamepad1, telemetry);
            carousel.run_carousel_loop(gamepad2, telemetry);
            turntable.run_turntable(gamepad2, telemetry);
            intake.run_intake(gamepad2, telemetry);
            arm.run_arm(gamepad2, telemetry);
            impaler.control_impaler(gamepad1);


            telemetry.update();
        }
    }

}

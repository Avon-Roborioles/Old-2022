package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.teamcode.Call_Upon_Classes.*;

public abstract class Auto_Base_14 extends LinearOpMode {
    protected org.firstinspires.ftc.teamcode.Call_Upon_Classes.Mecanum_Methods_Autonomus auto_motors = new Mecanum_Methods_Autonomus();
    protected org.firstinspires.ftc.teamcode.Call_Upon_Classes.Lift_14954 lift = new Lift_14954();
    protected org.firstinspires.ftc.teamcode.Call_Upon_Classes.Intake_15455 intake = new Intake_15455();
    protected org.firstinspires.ftc.teamcode.Call_Upon_Classes.Mecanum_IMU imu_drive = new Mecanum_IMU();
    protected org.firstinspires.ftc.teamcode.Call_Upon_Classes.Camera_14954 camera = new Camera_14954();

    @Override
    public void runOpMode()
    {
        camera.runOpMode();
    }
    
    public void init_classes(boolean red_alliance) {
        auto_motors.init_auto_drive_motors(hardwareMap, telemetry);
        lift.init_lift(hardwareMap, "lift");
        intake.init_intake(hardwareMap, "intake");
        imu_drive.init_drive_motors(hardwareMap, telemetry, false);
        camera.runOpMode();
    }
}
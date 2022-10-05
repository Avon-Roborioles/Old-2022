package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Mecanum_IMU;
import org.firstinspires.ftc.teamcode.Mecanum_Methods_Autonomus;
import org.firstinspires.ftc.teamcode.Call_Upon_Classes.Intake_14954;
import org.firstinspires.ftc.teamcode.Call_Upon_Classes.Lift_14954;
import org.firstinspires.ftc.teamcode.Call_Upon_Classes.Camera;

public abstract class Auto_Base_14 extends LinearOpMode {
    protected org.firstinspires.ftc.teamcode.Mecanum_Methods_Autonomus auto_motors = new Mecanum_Methods_Autonomus();
    protected org.firstinspires.ftc.teamcode.Call_Upon_Classes.Lift_14954 lift = new Lift_14954();
    protected org.firstinspires.ftc.teamcode.Call_Upon_Classes.Intake_14954 intake = new Intake_14954();
    protected org.firstinspires.ftc.teamcode.Mecanum_IMU imu_drive = new Mecanum_IMU();
    protected org.firstinspires.ftc.teamcode.Call_Upon_Classes.Camera camera = new Camera();

    protected int inchToTicks = 91;
    protected int scorePosition;

    public void init_classes(boolean red_alliance) {
        auto_motors.init_auto_drive_motors(hardwareMap, telemetry);
        lift.init_lift(hardwareMap, "lift");
        intake.init_intake(hardwareMap, "intake");
        imu_drive.init_drive_motors(hardwareMap, telemetry,false);
        camera.
    }

    public void sense_cone (){
        //use camera to scan cone images
    }
}

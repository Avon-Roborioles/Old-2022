package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.Call_Upon_Classes.Camera_21945;
import org.firstinspires.ftc.teamcode.Call_Upon_Classes.Intake_21945;
import org.firstinspires.ftc.teamcode.Call_Upon_Classes.Lift_21945;
import org.firstinspires.ftc.teamcode.Call_Upon_Classes.Mecanum_IMU;
import org.firstinspires.ftc.teamcode.Call_Upon_Classes.Mecanum_Methods_Autonomus;
import org.firstinspires.ftc.teamcode.Call_Upon_Classes.Turntable_21945;

public abstract class Auto_Base_21 extends LinearOpMode {
    //objects for each function of the robot
    //Chassis drive motors
    protected org.firstinspires.ftc.teamcode.Call_Upon_Classes.Mecanum_Methods_Autonomus auto_motors = new Mecanum_Methods_Autonomus();
    //Lift
    protected org.firstinspires.ftc.teamcode.Call_Upon_Classes.Lift_21945 lift = new Lift_21945();
    //Intake
    protected org.firstinspires.ftc.teamcode.Call_Upon_Classes.Intake_21945 intake = new Intake_21945();
    //Movement tracking
    protected org.firstinspires.ftc.teamcode.Call_Upon_Classes.Mecanum_IMU imu_drive = new Mecanum_IMU();
    //Camera
    protected org.firstinspires.ftc.teamcode.Call_Upon_Classes.Camera_21945 camera = new Camera_21945();
    //Turntable
    protected Turntable_21945 turntable = new Turntable_21945();


    protected int inchToTicks = 91;
    protected int scorePosition;
    int zone = 1;

    public void init_classes(boolean red_alliance) {
        //init
        auto_motors.init_auto_drive_motors(hardwareMap, telemetry);
        lift.init_lift_motor_21945(hardwareMap, "lift");
        intake.init_intake_motor_21945(hardwareMap, "intake");
        imu_drive.init_drive_motors(hardwareMap, telemetry, false);
        turntable.init_turntable_21945(hardwareMap, "turntable");
    }





}

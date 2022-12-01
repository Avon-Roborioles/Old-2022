package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Call_Upon_Classes.Camera_21945;
import org.firstinspires.ftc.teamcode.Call_Upon_Classes.Intake_21945;
import org.firstinspires.ftc.teamcode.Call_Upon_Classes.Lift_21945;
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
    //Camera
    protected org.firstinspires.ftc.teamcode.Call_Upon_Classes.Camera_21945 camera = new Camera_21945();
    //Turntable
    protected Turntable_21945 turntable = new Turntable_21945();


    //protected int inchToTicks = 45;
    int zone = 2;
    boolean placeCone = false;

    public void init_classes(boolean red_alliance) {
        //init
        auto_motors.init_auto_drive_motors(hardwareMap, telemetry);
        lift.init_lift_motor_21945(hardwareMap, "lift");
        intake.init_intake_motor_21945(hardwareMap, "intake");

        turntable.init_turntable_21945(hardwareMap, "turntable");
    }
    public void simpleWait(int TimeMiliS ){
        double currTime = getRuntime();
        double waitUntil = currTime + (double)(TimeMiliS / 1000);
        while (getRuntime() < waitUntil){

        }


    }





}

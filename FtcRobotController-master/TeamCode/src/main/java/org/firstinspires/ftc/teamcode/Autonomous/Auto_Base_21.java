package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.Call_Upon_Classes.Camera_21945;
import org.firstinspires.ftc.teamcode.Call_Upon_Classes.Color_Sensor;
import org.firstinspires.ftc.teamcode.Call_Upon_Classes.Distance_Sensor;
import org.firstinspires.ftc.teamcode.Call_Upon_Classes.Intake_21945;
import org.firstinspires.ftc.teamcode.Call_Upon_Classes.Lift_21945;
import org.firstinspires.ftc.teamcode.Call_Upon_Classes.Mecanum_Methods_Autonomus;

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
    protected org.firstinspires.ftc.teamcode.Call_Upon_Classes.Distance_Sensor distance = new Distance_Sensor();
    protected org.firstinspires.ftc.teamcode.Call_Upon_Classes.Color_Sensor color = new Color_Sensor();
    // distance ds
    // color cs
    //protected int inchToTicks = 45;
    int zone = 2;
    boolean found = false;
    double ds = 0;
    public void init_classes(boolean red_alliance) {
        //init
        auto_motors.init_auto_drive_motors(hardwareMap, telemetry);
        lift.init_lift_motor_21945(hardwareMap, "lift");
        intake.init_intake_motor_21945(hardwareMap, "intake");
        distance.initDistance(hardwareMap, "Distance Sensor");
        color.initColor(hardwareMap);
    }
    public void simpleWait(int TimeMiliS ){
        double currTime = getRuntime();
        double waitUntil = currTime + (double)(TimeMiliS / 1000);
        while (getRuntime() < waitUntil){

        }
    }
    public void parking21(){
        zone = camera.zone();
        switch (zone){
            case(1):
                auto_motors.strafeLeft(0.5, 24);
                break;
            case(2):
                break;
            case(3):
                auto_motors.strafeRight(0.5, 24);
                break;
        }

    }
    public void alignWithPole(){
        org.firstinspires.ftc.teamcode.Call_Upon_Classes.Distance_Sensor distance = new Distance_Sensor();
        distance.initDistance(hardwareMap, "Distance Sensor");
        double allignmenttries = 10;
        boolean alligned = false;
        boolean direction = true;
        double tries = 0;
        while (!alligned) {
            int distanceToPole = (int) distance.getDistance(telemetry);
            if(distanceToPole == 6){
                //alligned
                alligned = true;
            }else if(distanceToPole >10 && distanceToPole < 15){
                //drive to allign front and back
            }else if(distanceToPole > 15){
                //turn left and right to fing pole.
                if (direction){
                    if(tries < allignmenttries){
                        //panning left
                        auto_motors.turnByDegree(0.5, 1);
                        tries += 1;
                    }else{
                        //reset to pan right
                        direction = false;
                        tries = 0;
                    }
                }else{
                    if(tries > 0) {
                        auto_motors.turnByDegree(0.5, -1);
                        tries += -0.5;
                    }

                }
            }


        }


    }
    public void alignWithTapeDot(){
        org.firstinspires.ftc.teamcode.Call_Upon_Classes.Color_Sensor color = new Color_Sensor();
        color.initColor(hardwareMap);

    }
    public void alignWithTapeLine(){
        org.firstinspires.ftc.teamcode.Call_Upon_Classes.Color_Sensor color = new Color_Sensor();
        color.initColor(hardwareMap);

    }
}

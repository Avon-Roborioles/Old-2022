package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous
public class Blue_Left_21 extends  org.firstinspires.ftc.teamcode.Autonomous.Auto_Base_21 {

    public void runOpMode() throws InterruptedException {
        init_classes(false);
        waitForStart();
        //one tile is 24 in

        //START

        //Scan cone
        lift.run_lift_21945_auto(telemetry, 0.5);
        camera.init_camera(hardwareMap, "webcam", telemetry);
        zone = camera.zone();


        //Move forward
        auto_motors.goToSpot(15, 0.5);
        while (auto_motors.isBusy()){

        }
        if (placeCone) {

            //Lift 4-Bar up over chassis
            lift.run_lift_21945_auto(telemetry, 0.15);
            simpleWait(1000);
            //turntable left 90 degrees
            turntable.run_turntable_21945_auto(telemetry, 0.);
            simpleWait(1000);
            //4-bar down to put cone in junction
            lift.run_lift_21945_auto(telemetry, 0.05);
            simpleWait(1000);
            //intake out
            intake.run_intake_21945_auto(telemetry,  1);
            simpleWait(1000);
            intake.run_intake_21945_auto(telemetry,  0);
            //4-Bar up
            lift.run_lift_21945_auto(telemetry, 0.15);
            simpleWait(1000);
            //turntable right 90 degrees
            turntable.run_turntable_21945_auto(telemetry, 0.5);
            simpleWait(1000);
            //4-Bar down
            lift.run_lift_21945_auto(telemetry, 0);
            simpleWait(1000);
        }
        //lift.run_lift_21945_auto(telemetry, 0);
        //simpleWait(1000);
        //drive forward to middle
        auto_motors.goToSpot(10, 0.5);
        while (auto_motors.isBusy()){

        }



        //SPLIT TO PARK

        //LEFT (1)
        if (zone == 1) {
            //turn bot left 90 degrees
            auto_motors.turn90left(0.4);
            while (auto_motors.isBusy()) {

            }
            //drive forward to middle of
            auto_motors.goToSpot(24, 0.5);
            while (auto_motors.isBusy()) {

            }
            //turn bot right 90 degrees
            auto_motors.turn90right(0.6);
            while (auto_motors.isBusy()) {

            }
            //stop

        }
        //Middle (2)
        else if (zone == 2) {
            //stop

        }
        //Right
        else if (zone == 3) {
            //Turn right 90 degrees
            auto_motors.turn90right(0.4);
            while (auto_motors.isBusy()) {

            }

            //forward to
            auto_motors.goToSpot(24, 0.5);
            while (auto_motors.isBusy()) {

            }
            //left 90 degrees
            auto_motors.turn90left(0.6);
            while (auto_motors.isBusy()) {

            }
            //stop

        }

    }

}

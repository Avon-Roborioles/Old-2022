package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous
public class Red_Right_21 extends  org.firstinspires.ftc.teamcode.Autonomous.Auto_Base_21 {

    public void runOpMode() throws InterruptedException {
        init_classes(true);
        waitForStart();

        //one tile is 24 in

        //Start

        //scan cone
        lift.run_lift_21945_auto(telemetry,  0.5);
        simpleWait(1000);
        camera.init_camera(hardwareMap, "webcam", telemetry);
        zone = camera.zone();

        //move forward  line under center of bot
        auto_motors.goToSpot(15/2, 0.5);
        while (auto_motors.isBusy()) {

        }
        if (placeCone) {
            //4- bar to top
            lift.run_lift_21945_auto(telemetry, 1);
            simpleWait(1000);
            //turntable 90 degrees to the left
            turntable.run_turntable_21945_auto(telemetry, 0);
            simpleWait(1000);
            //intake drop cone
            intake.run_intake_21945_auto(telemetry, 1);
            simpleWait(1000);
            intake.run_intake_21945_auto(telemetry, 0);
            //turntable right 90 degrees
            turntable.run_turntable_21945_auto(telemetry, 0.5);
            simpleWait(1000);
            //4-bar down
            lift.run_lift_21945_auto(telemetry, 0);
            simpleWait(1000);
        }
        lift.run_lift_21945_auto(telemetry,  0);
        simpleWait(100);
        //drive forward to middle
        auto_motors.goToSpot(6, 0.5);
        while (auto_motors.isBusy()) {

        }

        //SPLIT TO PARK

        //LEFT (1)
        if (zone == 1) {
            //turn bot left 90 degrees
            auto_motors.turn45left(0.5);
            while (auto_motors.isBusy()) {

            }
            //drive forward to middle of
            auto_motors.goToSpot(12, 0.5);
            while (auto_motors.isBusy()) {

            }
            //turn bot right 90 degrees
            auto_motors.turn45right(0.5);
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
            auto_motors.turn45right(0.5);
            while (auto_motors.isBusy()) {

            }

            //forward to
            auto_motors.goToSpot(12, 0.5);
            while (auto_motors.isBusy()) {

            }
            //left 90 degrees
            auto_motors.turn45left(0.5);
            while (auto_motors.isBusy()) {

            }
            //stop

        }

    }
}
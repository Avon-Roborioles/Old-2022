package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous
public class Red_Right_21 extends  org.firstinspires.ftc.teamcode.Autonomous.Auto_Base_21 {

    public void runOpMode() throws InterruptedException {
        init_classes(true);
        double parkingSpot = 0;
        waitForStart();
        //one tile is 24 in

        //Start

        //scan cone
        lift.run_lift_21945_auto(telemetry, 0, 0.376);
        camera.init_camera(hardwareMap, "webcam", telemetry);
        zone = camera.zone();

        //move forward  line under center of bot
        auto_motors.goToSpot(15, 0.5);
        while (auto_motors.isBusy()) {

        }
        //4- bar to top
        lift.run_lift_21945_auto(telemetry, 0, 0.376);
        //turntable 90 degrees to the left
        turntable.run_turntable_21945_auto(telemetry, 0);
        //intake drop cone
        intake.run_intake_21945_auto(telemetry, 1, -1);
        //turntable right 90 degrees
        turntable.run_turntable_21945_auto(telemetry, 0.5);
        //4-bar down
        lift.run_lift_21945_auto(telemetry, 0, 0);
        //drive forward to middle
        auto_motors.goToSpot(12, 0.5);
        while (auto_motors.isBusy()) {

        }

        //SPLIT TO PARK

        //LEFT (1)
        if (parkingSpot == 1) {
            //turn bot left 90 degrees
            auto_motors.turn90left(0.5);
            while (auto_motors.isBusy()) {

            }
            //drive forward to middle of
            auto_motors.goToSpot(24, 0.5);
            while (auto_motors.isBusy()) {

            }
            //turn bot right 90 degrees
            auto_motors.turn90right(0.5);
            while (auto_motors.isBusy()) {

            }
            //stop
            stop();
        }
        //Middle (2)
        else if (parkingSpot == 2) {
            //stop
            stop();
        }
        //Right
        else if (parkingSpot == 3) {
            //Turn right 90 degrees
            auto_motors.turn90right(0.5);
            while (auto_motors.isBusy()) {

            }
            //forward to
            auto_motors.goToSpot(24, 0.5);
            while (auto_motors.isBusy()) {

            }
            //left 90 degrees
            auto_motors.turn90left(0.5);
            while (auto_motors.isBusy()) {

            }
            //stop
            stop();
        } else stop();
    }
}
package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous
public class Distance_color_test extends  Auto_Base_21 {

    @Override
    public void runOpMode() throws InterruptedException {
        init_classes(false);
        waitForStart();
        while (true) {
            distance.getDistance(telemetry);
            double red = color.getred(telemetry);
            double green = color.getgreen(telemetry);
            double blue = color.getblue(telemetry);
            double alpha = color.getred(telemetry);
            double power = 0;
            found = distance.found();
            ds = distance.ds();
            if(distance.ds() > 24 ){
                auto_motors.goToSpot(1,0.5);
                simpleWait(100);
                telemetry.addData("Distance: ", ds);

                telemetry.addData("Red",red);
                telemetry.addData("Green",green);
                telemetry.addData("Blue",blue);
                telemetry.addData("alpha",alpha);
                telemetry.addData("Is Found: ", found);
                telemetry.update();
            }else if(distance.ds( ) < 18){
                auto_motors.goToSpot(-1,0.5);
                simpleWait(100);
            }else if(distance.ds( ) > 18 && distance.ds( ) < 24){
                auto_motors.goToSpot(0, 0);
            }

            lift.run_lift_21945_auto(telemetry, 1, 0);

            telemetry.addData("Distance: ", ds);

            telemetry.addData("Red",red);
            telemetry.addData("Green",green);
            telemetry.addData("Blue",blue);
            telemetry.addData("alpha",alpha);
            telemetry.addData("Is Found: ", found);
            telemetry.update();
        }
    }
}

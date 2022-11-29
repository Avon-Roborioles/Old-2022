package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous
public class Blue_Left_21 extends  org.firstinspires.ftc.teamcode.Autonomous.Auto_Base_21 {

    public void runOpMode() throws InterruptedException {
        auto_motors.init_auto_drive_motors(hardwareMap, telemetry);
        lift.init_lift_motor_21945(hardwareMap, "lift");
        intake.init_intake_motor_21945(hardwareMap, "intake");
        imu_drive.init_drive_motors(hardwareMap, telemetry, false);
        turntable.init_turntable_21945(hardwareMap, "turntable");
        waitForStart();
        //one tile is 24 in

        //Start

        //scan cone
        //move forward to A5 B5 line under center of bot
        //4- bar to top
        //turntable 90 degrees to the right
        //intake drop cone
        //turntable left 90 degrees
        //4-bar down
        //drive forward to middle of B5

        //SPLIT TO PARK

        //LEFT (1)
        //turn bot left 90 degrees
        //drive forward to middle of B6
        //turn bot right 90 degrees
        //stop

        //Middle (2)
        //stop

        //Right
        //Turn right 90 degrees
        //forward to B4
        //left 90 degrees
        //stop

    }

}

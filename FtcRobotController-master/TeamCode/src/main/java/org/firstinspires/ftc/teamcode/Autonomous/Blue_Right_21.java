package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
/
@Autonomous
public class Blue_Right_21 extends  org.firstinspires.ftc.teamcode.Autonomous.Auto_Base_21 {

    public void runOpMode() throws InterruptedException {
        auto_motors.init_auto_drive_motors(hardwareMap, telemetry);
        lift.init_lift_motor_21945(hardwareMap, "lift");
        intake.init_intake_motor_21945(hardwareMap, "intake");
        imu_drive.init_drive_motors(hardwareMap, telemetry, false);
        turntable.init_turntable_21945(hardwareMap, "turntable");
        waitForStart();

        //START

        //Scan cone
        //Move forward
        //Lift 4-Bar up over chassis
        //turntable right 90 degrees
        //4-bar down to put cone in junction
        //intake out
        //4-Bar up
        //turntable left 90 degrees
        //4-Bar down
        //drive forward to middle of B2

        //SPLIT TO PARK

        //Left (1)
        //bot left 90 degrees
        //bot forward to middle of B3
        //turn right 90 degrees
        //Stop

        //Middle (2)
        //stop

        //Right
        //bot right 90 degrees
        //bot forward to middle of B1
        //turn left 90 degrees
        //Stop










    }

}

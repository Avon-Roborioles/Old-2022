package org.firstinspires.ftc.teamcode.Call_Upon_Classes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Intake_21954 {
    //intake power
    private double ip = 0;
    //intake servo
    private CRServo is = null;
    //button a
    private boolean a = false;
    //init
    public void init_intake_motor_21954(HardwareMap hardwareMap, String name) {
        is = hardwareMap.get(CRServo.class, "is");
    }
    //run
    //method
    public void run_intake_motor_21954(Gamepad gamepad, Telemetry telemetry){
        //Assign button "A"
        a = gamepad.a;

        if(a){
            ip=0.4;
        }
        else {
            ip = 0;
        }
        //Set servo power to intake power "ip" var
        is.setPower(ip);
    }


}

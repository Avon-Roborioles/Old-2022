package org.firstinspires.ftc.teamcode.Call_Upon_Classes;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Intake_21945 {
    // Intake power
    private double ip = 0;
    // Intake servo
    private CRServo is = null;
    // Button a
    private boolean rb = false;
    // Button b
    private boolean lb = false;
    private double rt = 0;
    private double lt = 0;
    private boolean a = false;
    // Init
    public void init_intake_motor_21945(HardwareMap hardwareMap, String name) {
        is = hardwareMap.get(CRServo.class, "is");
    }
    // Run
    // Method
    public void run_intake_motor_21945(Gamepad gamepad, Telemetry telemetry){
        // Assign button "a"
        rb = gamepad.right_bumper;
        lb = gamepad.left_bumper;
        rt = gamepad.right_trigger;
        lt = gamepad.left_trigger;
        a = gamepad.a;

        if(rb){
            ip=1;
        }
        else if(lb){
            ip=-1;
        }
        else if(rt > 0.3){
            ip=1;
        }
        else if(lt > 1){
            ip = -1;
        }
        else if(a){
            ip = 0;
        }
        else  {
            ip = 0;
        }



        // Set servo power to intake power "ip" var
        is.setPower(ip);
    }


}

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
    private boolean a = false;
    // Button b
    private boolean b = false;
    // Init
    public void init_intake_motor_21945(HardwareMap hardwareMap, String name) {
        is = hardwareMap.get(CRServo.class, "is");
    }
    // Run
    // Method
    public void run_intake_motor_21945(Gamepad gamepad, Telemetry telemetry){
        // Assign button "a"
        a = gamepad.a;
        b = gamepad.b;

        if(a){
            ip=1;
        }
        else if(b){
            ip=-1;
        }
        else {
            ip = 0;
        }
        // Set servo power to intake power "ip" var
        is.setPower(ip);
    }


}

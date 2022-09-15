package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

  public class Gate_14954 {
  
    private Servo gate = null;
    private Telemetry telemetry = null;
    
    
    
    public void init_gate (HardwareMap map, String name) {
        gate = map.get(Servo.class, name);
    }

 
    public void control_gate (Gamepad gp, Telemetry telemetry) {

        boolean open = gp.x;
        boolean close = gp.b;
        
        if (open) {
          gate.setPosition(.01); //need to check
        } else if (close) {
          gate.setPosition(0.4); //need to check
        }
        get_telemetry(telemetry);
    }
    public void get_telemetry (Telemetry telemetry) {
        telemetry.addData("Position",gate.getPosition());
      }
 
}

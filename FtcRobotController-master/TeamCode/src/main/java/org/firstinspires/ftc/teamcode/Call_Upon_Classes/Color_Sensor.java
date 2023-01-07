package org.firstinspires.ftc.teamcode.Call_Upon_Classes;

import com.qualcomm.hardware.rev.RevColorSensorV3;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.robotcore.external.Telemetry;


public class Color_Sensor {
    private RevColorSensorV3 cs = null;

    public void init(HardwareMap hardwareMap) {
       cs =hardwareMap.get(RevColorSensorV3.class, "cs");
    }

    public void getColor(Telemetry telemetry){
        cs.getNormalizedColors();
        getTelemetry(telemetry);
    }

    public void getTelemetry(Telemetry telemetry) {
        telemetry.addData("Colors",cs.getNormalizedColors());
    }
}

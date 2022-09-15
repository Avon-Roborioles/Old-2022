package org.firstinspires.ftc.teamcode;


import com.qualcomm.hardware.rev.Rev2mDistanceSensor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
public class Distance_Sensor {


        //the sensors
        private Rev2mDistanceSensor ds = null;
        //variable for if it sees it
        public boolean yes = false;
        //Max Distance to see it
        private double md = 2.8*12;
        //Distance it is seeing right now
        private double dis = 0;
        //Where the position of the duck is
        private int pos = 1;

        private Telemetry telemetry = null;

        public void initDistance(HardwareMap hardwareMap, Telemetry telemetry, boolean redAlliance) {
                if(redAlliance) {
                        ds = hardwareMap.get(Rev2mDistanceSensor.class,"ds2"); //left side sensor
                } else {
                        ds = hardwareMap.get(Rev2mDistanceSensor.class,"ds1"); //right side sensor
                }

                this.telemetry = telemetry;
        }

        public boolean checkSeesSomething() {
                getTelemetry();

                if(ds.getDistance(DistanceUnit.INCH) < md) {
                        return true;
                } return false;
        }

//        public void runDistance() {
//                if(dis<md&&pos!=2) {
//                        yes = true;
//                }
//                else if(pos==1&&!yes) {
//                        pos = 0;
//                }
//                else if(pos==0&&!yes) {
//                        pos = 2;
//                        yes = true;
//                }
//        }

        public void getTelemetry() {
                telemetry.addData("Distance", ds.getDistance(DistanceUnit.INCH));
//                telemetry.addData("Position",pos);
//                telemetry.addData("Sees it", yes);
        }
}
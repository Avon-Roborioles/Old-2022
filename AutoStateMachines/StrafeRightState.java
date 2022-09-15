package org.firstinspires.ftc.teamcode;

public class StrafeRightState extends org.firstinspires.ftc.teamcode.StrafeLeftState {
    private double inches;
    private double power;
    private org.firstinspires.ftc.teamcode.Mecanum_IMU_States imu;

    public StrafeRightState(double inches, double power, org.firstinspires.ftc.teamcode.Mecanum_IMU_States imu) {
        super(inches, power, imu);
    }

    @Override
    public void start() {
        imu.strafeRight(power, inches);
    }

    @Override
    public void doWhileNotDone() {
        imu.makeCorrectionsStrafeRight();
    }

}
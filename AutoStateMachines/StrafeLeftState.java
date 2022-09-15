package org.firstinspires.ftc.teamcode;

public class StrafeLeftState implements org.firstinspires.ftc.teamcode.State {
    protected double inches;
    protected double power;
    protected org.firstinspires.ftc.teamcode.Mecanum_IMU_States imu;

    public StrafeLeftState(double inches, double power, org.firstinspires.ftc.teamcode.Mecanum_IMU_States imu) {
        this.inches = inches;
        this.power = power;
        this.imu = imu;
    }

    @Override
    public void start() {
        imu.strafeLeft(power, inches);
    }

    @Override
    public void doWhileNotDone() {
        imu.makeCorrectionsStrafeLeft();
    }

    @Override
    public boolean checkDone() {
        return imu.isBusy();
    }

    @Override
    public void stop() {
        imu.stopDriving();
    }

}
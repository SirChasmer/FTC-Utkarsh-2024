package org.firstinspires.ftc.teamcode;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad1;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

//Gyroscope
public class Flywheel extends SubsystemBase {
    //Flywheel is a dcMotor
    private DcMotorEx flyWheel;

    public static double kP = 10.2;
    public static double kI = 10.2;
    public static double kD = 10.2;

    //hmap connection
    public Flywheel(HardwareMap hmap) {
        flyWheel = hmap.get(DcMotorEx.class, "fWheel");
//Brake, stop when you want it to
        flyWheel.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }
//Spins for gyroscopic effect
    public void spin() {
        if (gamepad1.cross) {
            flyWheel.setPower(1);
        }
    }
}
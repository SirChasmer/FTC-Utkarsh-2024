package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.controller.PIDController;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Arm extends SubsystemBase {
    final private DcMotorEx armMotor;
    //PID declaration
    private PIDController pid = new PIDController(Flywheel.kP, Flywheel.kI, Flywheel.kD);
    //Declaring the motors
    public Arm(HardwareMap hmap){
        armMotor = hmap.get(DcMotorEx.class, "fl");
        //Brake for all motors
        armMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
}

package org.firstinspires.ftc.teamcode;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad1;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Intake extends SubsystemBase {
    //IntakeMotor is a dcMotor
    private DcMotorEx intakeMotor;
//hmap connection
    public Intake(HardwareMap hmap){
        intakeMotor = hmap.get(DcMotorEx.class, "iMotor");
//Brake, stop when you want it to
        intakeMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    } //takes in the pieces(0 to 1)
    public void suck() {
        intakeMotor.setPower(gamepad1.right_trigger);
//Spits out the pieces (- is for reverse of 0 - 1 power)
    }
    public void spit() {
        intakeMotor.setPower(-gamepad1.left_trigger);
    }
}
package org.firstinspires.ftc.teamcode;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad1;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Launcher extends SubsystemBase{
    //Launcher is a motor
    private DcMotorEx launcher;
//Connects to hmap
    public Launcher(HardwareMap hmap){
        //Gives device name and gets class from hmap
        launcher = hmap.get(DcMotorEx.class, "launcher");
//Brake ability to launcher, stops it
        launcher.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }
    //Launch setup, power and boolean
    public void launch(boolean toLaunch) {
        if (toLaunch) {
            launcher.setPower(1);
        } else {
            launcher.setPower(0);
        }
    }
}

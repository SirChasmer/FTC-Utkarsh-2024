package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Servo;

public class Auto extends LinearOpMode {

    Drivetrain dtrain = new Drivetrain(hardwareMap);
    Intake iMotor = new Intake(hardwareMap);
    Launcher launcher = new Launcher(hardwareMap);
    Claw claw = new Claw(hardwareMap);



    @Override
    public void runOpMode() throws InterruptedException {

        dtrain.drive();
        dtrain.undrive();
        iMotor.suck();
        iMotor.spit();
        launcher.launch(false);
        claw.open();
        claw.close();

        waitForStart();

        while(opModeIsActive()){

            if(telemetry.update());
                //drives to the middle of the field
            dtrain.drive();
            Thread.sleep(4000);
                //Turns right (Don't know actual time values Trial and Error)
            dtrain.turnRight();
            Thread.sleep(500);
                //Claw closes around pixel and takes it to backstage
            claw.close();
            Thread.sleep(250);
                //Moves to backstage in Centerstage (Parking auto)
            dtrain.drive();
            Thread.sleep(4000);
        }
    }
}

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

public class RobotRun extends LinearOpMode {
    //Declares classes
    Claw claw;
    Drivetrain drivetrain;
    Intake intakeMotor;
    Launcher launcher;
    Arm armMotor;
    @Override
    public void runOpMode() throws InterruptedException {
        //Connects to hardware map
        claw = new Claw(hardwareMap);
    drivetrain = new Drivetrain(hardwareMap);
    intakeMotor = new Intake(hardwareMap);
    launcher = new Launcher(hardwareMap);
    armMotor = new Arm(hardwareMap);

    //Self-explanatory
    waitForStart();
        //if stop requested, return it to DS
        if (isStopRequested()) return;

        while (opModeIsActive()) {
            // Gamepad controls for claw, drivetrain, and more
            if (gamepad1.a) {
                claw.open();
            } else {
                claw.close();
            }
            //Gamepad controls for boolean(dpad)
            launcher.launch(gamepad1.dpad_down);

            if (gamepad1.left_stick_y > 0) {
                drivetrain.drive();
            } else {
                drivetrain.undrive();
            }
        }

    }
}


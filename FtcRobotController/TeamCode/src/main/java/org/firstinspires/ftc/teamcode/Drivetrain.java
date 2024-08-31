package org.firstinspires.ftc.teamcode;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad1;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.controller.PIDController;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

    public class Drivetrain extends SubsystemBase {
            //Naming the motors
        final private DcMotorEx frontL, frontR, backL, backR;
            //PID declaration
        private PIDController pid = new PIDController(Flywheel.kP, Flywheel.kI, Flywheel.kD);
            //Declaring the motors
        public Drivetrain(HardwareMap hmap){
            frontL = hmap.get(DcMotorEx.class, "fl");
            frontR = hmap.get(DcMotorEx.class, "fr");
            backL = hmap.get(DcMotorEx.class, "bl");
            backR = hmap.get(DcMotorEx.class, "br");
                //Brake for all motors
            frontL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            frontR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            backL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            backR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        }
            //Gamepad controls and power
        public void drive() {
            frontR.setPower(gamepad1.left_stick_y);
            backL.setPower(-gamepad1.left_stick_y);
            frontL.setPower(-gamepad1.left_stick_y);
            backR.setPower(gamepad1.left_stick_y);
    }
        public void undrive() {
            frontR.setPower(-gamepad1.left_stick_y);
            backL.setPower(gamepad1.left_stick_y);
            frontL.setPower(gamepad1.left_stick_y);
            backR.setPower(-gamepad1.left_stick_y);
        }

        public void turnRight() {
            frontR.setPower(0);
            backL.setPower(0);
            frontL.setPower(gamepad1.left_stick_y);
            backR.setPower(gamepad1.left_stick_y);
        }
        double y = -gamepad1.left_stick_y;
        double x = gamepad1.left_stick_x;
        double rx = gamepad1.right_stick_x;

        public void drive(double y, double x, double rx){
            x *= 1.1;
            double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1.0);

            frontR.setPower((y - x - rx) / denominator);
            frontL.setPower((y + x + rx) / denominator);
            backR.setPower((y + x - rx) / denominator);
            backL.setPower((y - x + rx) / denominator);
        }

        public void forwardBackward(double y) {drive(y, 0 ,0 );} //positive = forward, negative = backward
        public void stop() {drive(0,0,0);}
        public void strafeLorR(double x) {drive(0,x,0);}; //positive value if right, negative if left

        public void rotate(double rx) {drive(0,0,rx);} //positive = clockwise, negative = counterclockwise

    }

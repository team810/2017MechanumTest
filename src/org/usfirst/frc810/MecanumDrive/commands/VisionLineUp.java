// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc810.MecanumDrive.commands;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import vision.VisionListener;

import org.usfirst.frc810.MecanumDrive.Robot;
import org.usfirst.frc810.MecanumDrive.RobotMap;

/**
 *
 */
public class VisionLineUp extends Command {
	private final double optimalDistance1 = 16;

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
 
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
    public VisionLineUp() {

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.driveTrain);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.driveTrain.resetG();
    	counter = 0;
    	VisionListener.newResult = false;
    }

    private int counter = 0;
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double distance = RobotMap.cameraUltrasonicsensor.getAverageVoltage()*108.515;
    	double forward =0;
    	if (distance>optimalDistance1){
    		forward =.4;
    	}
    	if(VisionListener.newResult){
    		VisionListener.VisionResult result = VisionListener.getResult();
    		if(result.found){
	    		SmartDashboard.putNumber("Visionx", result.x);
	    		double strafe = 2*(result.x-.5) + SmartDashboard.getNumber("Camera Offset", 0);
	    		double dist = RobotMap.cameraUltrasonicsensor.getAverageVoltage() * 108.515;
	    		//SmartDashboard.putNumber("Distance (in. avg)", dist);
	    		if(Math.abs(strafe)<.1){
	    			strafe = 0;
	    			counter++;
	    		} else{
	    			counter = 0;
	    		}
	    		if(Math.abs(strafe)>=.05&&Math.abs(strafe)<=.2){
	    			strafe = .25 * Math.signum(strafe);
	    		}
	    		
	    		
	    		Robot.driveTrain.mecanum(strafe, -forward, 0);
    		}
    	} else{
    		//Robot.driveTrain.mecanum(0, 0, 0);
    	}
    }
    //keeps going until hits sonar hot spot which is as close as can be without hitting point of no return
    //First move forward

    private void finalAutoForward(){
    	
    }
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return counter>10;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}

package drive;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.IterativeRobot;

public class AutonomousDrive extends IterativeRobot{
	private TalonSRX topLeft, botLeft, topRight, botRight;
	private int speed = 100;
	private int time = 0; //placeholder for actual time variable (in seconds)
	public void autonomousInit() {
		topLeft = new TalonSRX(13);
		botLeft = new TalonSRX(12);
		topRight = new TalonSRX(10);
		botRight = new TalonSRX(11);
		
		botLeft.follow(topLeft);
		botRight.follow(topRight);
	}
	public void brake(TalonSRX t) {
		t.setNeutralMode(com.ctre.phoenix.motorcontrol.NeutralMode.Brake);
	}
	public void start(TalonSRX t) {
		t.set(ControlMode.PercentOutput, speed);
	}
	public void reverse(TalonSRX t) {
		t.setInverted(true);
		t.set(ControlMode.PercentOutput, speed);
	}
	public void shoot(TalonSRX t, int s) {
		t.set(ControlMode.PercentOutput, s);
	}
	public void turn(TalonSRX left, TalonSRX right, String s) {
		if(s.equals("left")) {
			reverse(left);
			start(right);
		}else if(s.equals("right")) {
			reverse(right);
			start(left);
		}
	}
	
	public void autonomousPeriodic() {
		if(time <= 3) {
			start(topLeft);
			start(topRight);
		}
	}

}

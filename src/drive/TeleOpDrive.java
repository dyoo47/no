package drive;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.IterativeRobot;

public class TeleOpDrive extends IterativeRobot{
	private TalonSRX talonSlave;
	private TalonSRX talon;
	//private String qotd = "pramit is gay";
	private int speed;

	public void robotInit() {
		talonSlave = new TalonSRX(1);
		talon = new TalonSRX(2);
		System.out.println(talon.getSelectedSensorPosition(0));
		System.out.println(talonSlave.getSelectedSensorPosition(0));
		//talonSlave is a slave to talon
		talonSlave.follow(talon);
		//talon is now inverted
		//talon.setInverted(true);
		//talon set to coast (motors still moving), has a brake mode (NeutralMode.brake)
		//talon.setNeutralMode(com.ctre.phoenix.motorcontrol.NeutralMode.Coast);
		speed = 100;
		
	}
	//switches main talon to NeutralMode.Brake (motors resist movement).
	public void brake(TalonSRX t) {
		t.setNeutralMode(com.ctre.phoenix.motorcontrol.NeutralMode.Brake);
	}
	public void start(TalonSRX t) {
		t.set(ControlMode.PercentOutput, speed);
	}
	public void shoot(TalonSRX t, int s) {
		t.set(ControlMode.PercentOutput, s);
	}
	//called at the start of autonomous period
	public void autonomousInit() {
		//brake();
	}
	//called every tick of autonomous period
	public void autonomousPeriodic() {
		
	}
	//called at the start of teleop period
	public void teleopInit() {
		
	}
	//called every tick of teleop period
	public void teleopPeriodic() {
		
	}
}

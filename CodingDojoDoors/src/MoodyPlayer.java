import java.util.Date;
import java.util.Random;

public class MoodyPlayer implements Player {

	static Date d = new Date();
	static Random r = new Random(d.getTime());

	@Override
	public int selectDoor() {
		return random(3);
	}

	@Override
	public boolean switchDoor() {
		return random(2) == 0 ? true : false;
	}
	
	@Override
	public String getName() {
		return this.getClass().getName();
	}

	private static int random(int i) {
		return r.nextInt(i);
	}

}

import java.io.Serializable;

public class EntranceRoom extends Room implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 814137883283334386L;

	public EntranceRoom() {
		super(0, 1, 1, 0);
	}
	
	@Override
	public String roomMid(String Object){
		return "* I |";
	}

}

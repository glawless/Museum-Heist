import java.io.Serializable;

public class ExitRoom extends Room implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4910687375322766880L;

	public ExitRoom() {
		super(1, 1, 0, 0);
		this.getContents().clear();
		
	}
	
	@Override
	public String roomMid(String Object){
		return "| O *";
	}

}

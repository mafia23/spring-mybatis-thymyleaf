package fun.model;

public class User {
	private int id;
	private String name;
	private String psd;
	
	public User(){
		
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the psd
	 */
	public String getPsd() {
		return psd;
	}

	/**
	 * @param psd the psd to set
	 */
	public void setPsd(String psd) {
		this.psd = psd;
	}

	
}

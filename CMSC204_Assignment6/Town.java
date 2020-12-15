/**
 * A town
 * @author Elizabeth Perez
 *
 */
public class Town implements Comparable<Town> {
	private String townName;
	
	/**
	 * Constructor
	 * @param name - town name
	 */
	public Town(String name) {
		townName = name;
	}
	
	/**
	 * Constructor
	 * @param templateTown - a town
	 */
	public Town(Town templateTown) {
		townName = templateTown.getName();
	}
	
	/**
	 * Compares the town to another town
	 * @param o - another town
	 */
	@Override
	public int compareTo(Town o) {
		if(o.getName().equalsIgnoreCase(townName)) {
			return 0;
		} else {
			return 1;
		}
	}
	
	/**
	 * Compares the town to another town
	 * @param obj - another town
	 * @return true if the towns are the same and false if not
	 */
	@Override
	public boolean equals(Object obj) {
		if(((Town) obj).getName().equalsIgnoreCase(townName)) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Returns the town's name
	 * @return townName
	 */
	public String getName() {
		return townName;
	}
	
	/**
	 * Returns the town's name's hash code
	 */
	public int hashCode() {
		String name = townName.toLowerCase();
		int code = Math.abs(name.hashCode());
		return code;
	}
	
	/**
	 * Returns town's information as a string
	 */
	public String toString() {
		return this.getName();
	}
}

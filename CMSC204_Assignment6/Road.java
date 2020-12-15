/**
 * A directional road that connects two towns
 * @author Elizabeth Perez
 *
 */
public class Road implements Comparable<Road> {
	private String roadName;
	private Town roadSource, roadDestination;
	private int weight; // road distance in miles
	
	/**
	 * Road Constructor
	 * @param source - road's source
	 * @param destination - road's destination
	 * @param degrees - road's weight
	 * @param name - road's name
	 */
	public Road(Town source, Town destination, int degrees, String name) {
		roadName = name;
		roadSource = source;
		roadDestination = destination;
		weight = degrees;
	}
	
	/**
	 * Road Constructor
	 * @param source - road's source
	 * @param destination - road's destination
	 * @param name - road's name
	 */
	public Road(Town source, Town destination, String name) {
		roadName = name;
		roadSource = source;
		roadDestination = destination;
		weight = 1;
	}
	
	/**
	 * Confirms that a town is connected to the road 
	 * @param town
	 * @return true if the town is the road's source or destination and false if not
	 */
	public boolean contains(Town town) {
		if(roadSource.equals(town)) {
			return true;
		}
		if(roadDestination.equals(town)) {
			return true;
		}
		return false;
	}
	
	/**
	 * Compares this road to another road
	 * @param o - another road
	 */
	@Override
	public int compareTo(Road o) {
		if(o.getName().equalsIgnoreCase(roadName)) {
			return 0;
		} else {
			return 1;
		}
	}
	
	/**
	 * Compares this road to another road
	 * @param r - another road
	 * @return true if the roads are the same and false if not
	 */
	@Override
	public boolean equals(Object r) {
		if(((Road) r).getSource().equals(roadSource) && ((Road) r).getDestination().equals(roadDestination)) {
			return true;
		} else if(((Road) r).getSource().equals(roadDestination) && ((Road) r).getDestination().equals(roadSource)) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Returns the road's name
	 * @return roadName
	 */
	public String getName() {
		return roadName;
	}
	
	/**
	 * Returns the road's destination
	 * @return roadDestination
	 */
	public Town getDestination() {
		return roadDestination;
	}
	
	/**
	 * Returns the road's source
	 * @return
	 */
	public Town getSource() {
		return roadSource;
	}
	
	/**
	 * Returns the road's weight
	 * @return weight
	 */
	public int getWeight() {
		return weight;
	}
	
	/**
	 * Returns road's information as a string
	 */
	public String toString() {
		String s = roadName + "," + roadSource.toString() + "," + roadDestination.toString() + "," + weight;
		return s;
	}

}

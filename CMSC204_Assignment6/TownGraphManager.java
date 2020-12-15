import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
/**
 * Town Map Manager
 * @author Elizabeth Perez
 *
 */
public class TownGraphManager implements TownGraphManagerInterface {
	private Graph map;
	
	public TownGraphManager() {
		map = new Graph();
	}
	
	@Override
	public boolean addRoad(String town1, String town2, int weight, String roadName) {
		Town source = new Town(town1);
		Town destination = new Town(town2);
		
		try {
			if(map.addEdge(source, destination, weight, roadName) != null) {
				return true;
			}
		} catch(Exception e) {
			e.getMessage();
		}
		
		return false;
	}

	@Override
	public String getRoad(String town1, String town2) {
		Town source = new Town(town1);
		Town destination = new Town(town2);
		
		Road road = map.getEdge(source, destination);
		if(road != null) {
			return road.getName();
		} else {
			return null;
		}
	}

	@Override
	public boolean addTown(String v) {
		Town town = new Town(v);
		
		try {
			if(map.addVertex(town)) {
				return true;
			}
		} catch(Exception e) {
			e.getMessage();
		}
		
		return false;
	}

	@Override
	public Town getTown(String name) {
		if(containsTown(name)) {
			return new Town(name);
		} else {
			return null;
		}
	}

	@Override
	public boolean containsTown(String v) {
		Town town = new Town(v);
		return map.containsVertex(town);
	}

	@Override
	public boolean containsRoadConnection(String town1, String town2) {
		Town source = new Town(town1);
		Town destination = new Town(town2);
		
		if(map.containsEdge(source, destination)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public ArrayList<String> allRoads() {
		Set<Road> roads = map.edgeSet();
		ArrayList<String> list = new ArrayList<String>();
		
		for(Road road : roads) {
			list.add(road.getName());
		}
		
		Collections.sort(list);
		return list;
	}

	@Override
	public boolean deleteRoadConnection(String town1, String town2, String road) {
		Town source = new Town(town1);
		Town destination = new Town(town2);
		Road removed = map.removeEdge(source, destination, 1, road);
		
		if(removed == null) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public boolean deleteTown(String v) {
		Town town = new Town(v);
		return map.removeVertex(town);
	}

	@Override
	public ArrayList<String> allTowns() {
		Set<Town> towns = map.vertexSet();
		ArrayList<String> list = new ArrayList<String>();
		
		for(Town town : towns) {
			list.add(town.getName());
		}
		
		Collections.sort(list);
		return list;
	}

	@Override
	public ArrayList<String> getPath(String town1, String town2) {
		Town source = new Town(town1);
		Town destination = new Town(town2);
		ArrayList<String> path = map.shortestPath(source, destination);
		return path;
	}

}

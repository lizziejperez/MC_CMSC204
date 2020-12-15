import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
//import java.util.LinkedList;
import java.util.Set;
/**
 * A map graph with towns and roads
 * @author Elizabeth Perez
 *
 */
public class Graph implements GraphInterface<Town, Road> {
	private ArrayList<Road>[] adjList;
	private Town[] vertices;
	private static int LIST_SIZE = 20;
	
	private Town[] previousVertex;
	private Town[] indexReferance;
	private int[] distance;
	
	@SuppressWarnings("unchecked")
	public Graph() {
		adjList = new ArrayList[LIST_SIZE];
		for(int i = 0; i < LIST_SIZE; i++) {
			adjList[i] = new ArrayList<Road>();
		}
		
		vertices = new Town[LIST_SIZE];
	}
	
	private int getIndex(Town v) {
		for(int i = 0; i < vertices.length; i++) {
			if(vertices[i] !=  null) {
				if(vertices[i].equals(v)) {
					return i;
				}
			}
		}
		return -1;
	}
	
	@Override
	public Road getEdge(Town sourceVertex, Town destinationVertex) {
		if(sourceVertex == null || destinationVertex == null) {
			return null;
		}
		
		int index = getIndex(sourceVertex);
		for(int i = 0; i < adjList[index].size(); i++) {
			if(adjList[index].get(i).getDestination().equals(destinationVertex)) {
				return adjList[index].get(i);
			}
		}
		
		return null;
	}

	@Override
	public Road addEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
		if(sourceVertex == null || destinationVertex == null) {
			throw new NullPointerException();
		}
		
		if(!containsVertex(sourceVertex) || !containsVertex(destinationVertex)) {
			throw new IllegalArgumentException();
		}
		
		Road edge = new Road(sourceVertex, destinationVertex, weight, description);
		
		int index = getIndex(sourceVertex);
		for(int i = 0; i < adjList[index].size(); i++) {
			if(adjList[index].get(i).equals(edge)) {
				return null;
			}
		}
		
		adjList[index].add(edge);

		return edge;
	}

	@Override
	public boolean addVertex(Town v) {
		if(v == null) {
			throw new NullPointerException();
		}
		
		if(containsVertex(v)) {
			return false;
		} else {
			int index = v.hashCode()%adjList.length;
			while(vertices[index] != null) {
				index = (index+3)%adjList.length;
			}
			vertices[index] = v;
			
			return true;
		}
	}

	@Override
	public boolean containsEdge(Town sourceVertex, Town destinationVertex) {
		if(sourceVertex == null || destinationVertex == null) {
			return false;
		}

		if(!containsVertex(sourceVertex) || !containsVertex(destinationVertex)) {
			return false;
		}
		
		int index = getIndex(sourceVertex);
		for(int i = 0; i < adjList[index].size(); i++) {
			if(adjList[index].get(i).getDestination().equals(destinationVertex)) {
				return true;
			}
		}
		
		return false;
	}

	@Override
	public boolean containsVertex(Town v) {
		if(v == null) {
			return false;
		}
		
		if(getIndex(v) >= 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Set<Road> edgeSet() {
		Set<Road> roads = new HashSet<Road>();
		for(int i = 0; i < adjList.length; i++) {
			for(int j = 0; j < adjList[i].size(); j++) {
				roads.add(adjList[i].get(j));
			}
		}
		return roads;	
	}

	@Override
	public Set<Road> edgesOf(Town vertex) {
		if(vertex == null) {
			throw new NullPointerException();
		}
		
		if(!containsVertex(vertex)) {
			throw new IllegalArgumentException();
		}
		
		Set<Road> roads = new HashSet<Road>();
		for(int i = 0; i < adjList.length; i++) {
			for(int j = 0; j < adjList[i].size(); j++) {
				if(adjList[i].get(j).contains(vertex)) {
					roads.add(adjList[i].get(j));
				}
			}
		}
		return roads;
	}

	@Override
	public Road removeEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
		Road edge = new Road(sourceVertex, destinationVertex, weight, description);
		
		if(containsEdge(sourceVertex, destinationVertex)) {
			int index = getIndex(sourceVertex);
			for(int i = 0; i < adjList[index].size(); i++) {
				if(adjList[index].get(i).equals(edge)) {
					adjList[index].remove(i);
					return edge;
				}
			}
		}
		return null;
	}

	@Override
	public boolean removeVertex(Town v) {
		if(v == null) {
			return false;
		}
		
		if(containsVertex(v)) {
			for(int i = 0; i < adjList.length; i++) {
				for(int j = 0; j < adjList[i].size(); j++) {
					if(adjList[i].get(j).contains(v)) {
						adjList[i].remove(j);
					}
				}
			}
			
			int index = getIndex(v);
			vertices[index] = null;
			
			return true;
		}
		return false;
	}

	@Override
	public Set<Town> vertexSet() {
		Set<Town> towns = new HashSet<Town>();
		for(int i = 0; i < vertices.length; i++) {
			if(vertices[i] != null) {
				towns.add(vertices[i]);
			}
		}
		return towns;
	}

	@Override
	public ArrayList<String> shortestPath(Town sourceVertex, Town destinationVertex) {
		dijkstraShortestPath(sourceVertex);
		System.out.println("starting shortest path from " + sourceVertex.getName() + " to " + destinationVertex.getName());
		
		ArrayList<String> path = new ArrayList<String>();
		
		for(int i = 0; i < indexReferance.length; i++) {
			System.out.println("Town: " + indexReferance[i].getName() + " Previous: " + previousVertex[i] + " Weight: " + distance[i]);
		}
		
		boolean done = false;
		Town t = destinationVertex;
		Town next = destinationVertex;
		System.out.println("looking for " + t.getName());
		String s;
		while(!done) {
			for(int i = 0; i < indexReferance.length; i++) {
				if(indexReferance[i].equals(t)) {
					System.out.println("found " + indexReferance[i].getName());
					System.out.println("looking for road from " + previousVertex[i].getName());
					Road r = getEdge(previousVertex[i], t);
					if(r == null) {
						r = getEdge(t, previousVertex[i]);
					}
					System.out.println("got the road");
					s = previousVertex[i].getName() + " via " + r.getName() + " to " + t.getName() + " " + distance[i] + " mi";
					path.add(s);
					System.out.println("added to path: " + s);
					next = previousVertex[i];
				}
			}
			
			t = next;
			
			if(t.equals(sourceVertex)) {
				done = true;
				System.out.println("traversed path");
			} else {
				System.out.println("looking for " + t.getName());
			}
		}
		
		System.out.println("Shortest Path:");
		ArrayList<String> shortestPath = new ArrayList<String>();
		for(int i = path.size()-1; i >= 0; i--) {
			shortestPath.add(path.get(i));
			System.out.println(path.get(i));
		}
		
		
		return shortestPath;
	}

	@Override
	public void dijkstraShortestPath(Town sourceVertex) {
		System.out.println("starting dsp");
		
		Town current = sourceVertex;
		Set<Town> towns = vertexSet();
		Set<Road> edges = edgesOf(sourceVertex);
		int size = towns.size();
		int visitedCounter = 0;
		Town[] visited = new Town[size];
		previousVertex = new Town[size]; // important
		
		indexReferance = new Town[size]; // important
		distance = new int[size]; // important
		int i = 0;
		for(Town town : towns) {
			indexReferance[i] = town;
			System.out.println("Added town: " + town.getName() + " to indexReferance");
			if(town.equals(sourceVertex)) {
				distance[i] = 0;
				System.out.println("found source and set source distance to " + distance[i]);
			} else {
				distance[i] = 100;
				System.out.println("set non-source distance to " + distance[i]);
			}
			
			i++;
		}
		
		boolean visitedAll = false;
		while(!visitedAll) {
			System.out.println("Starting to visit from " + current.getName());
			Iterator<Road> iter = edges.iterator();
			while(iter.hasNext()) {
				Road r = iter.next();
				
				Town t;
				if(!r.getSource().equals(current)) {
					t = r.getSource();
				} else {
					t = r.getDestination();
				}
				System.out.println("Set town t to " + t.getName());
				
				boolean unvisited2 = true;
				for(int l = 0; l < size; l++) {
					if(visited[l] != null) {
						if(visited[l].equals(t)) {
							unvisited2 = false;
							System.out.println("already visited");
						}
					}
				}
				
				if(unvisited2) {
					int indexT = -1;
					for(int j = 0; j < size; j++) {
						if(indexReferance[j].equals(t)) {
							indexT = j;
							System.out.println("found t's index");
						}
					}
					
					if(distance[indexT] > r.getWeight()) {
						distance[indexT] = r.getWeight();
						previousVertex[indexT] = current;
						System.out.println("updated distance to " + distance[indexT] + " and previousVertex to " + current.getName());
					}
				}	
			}
			
			visited[visitedCounter] = current;
			visitedCounter++;
			System.out.println("added " + current.getName() + " to visited");
			
			if(visitedCounter == size) {
				visitedAll = true;
				System.out.println("visited all");
			} else {
				System.out.println("not yet visited all");
				Town next = null;
				int lowest = 100;
				for(int j = 0; j < size; j++) {
					boolean unvisited = true;
					for(int k = 0; k < size; k++) {
						if(visited[k] == indexReferance[j]) {
							unvisited = false;
							System.out.println("found that " + visited[k].getName() + " was visited");
						}
					}
					
					if(unvisited) {
						System.out.println("found that " + indexReferance[j].getName() + " was not visited yet");
						if(distance[j] < lowest) {
							next = indexReferance[j];
							lowest = distance[j];
							System.out.println("updated next to " + indexReferance[j].getName() + " and lowest to " + distance[j]);
						}
					}
				}
				
				current = next;
				edges = edgesOf(current);
			}
		}
		System.out.println("finished dsp");
	
	}

}

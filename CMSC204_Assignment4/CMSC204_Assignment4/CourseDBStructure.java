import java.io.IOException;
import java.util.LinkedList;

/**
 * Course Data Structure
 * @author Elizabeth Perez
 *
 */
public class CourseDBStructure implements CourseDBStructureInterface {
	public LinkedList<CourseDBElement>[] hashTable;
	
	/**
	 * CDS test constructor
	 */
	public CourseDBStructure(String test, int numOfCourses) {
		hashTable = new LinkedList[numOfCourses];
		for(int i = 0; i < numOfCourses; i++) {
			hashTable[i] = new LinkedList<CourseDBElement>();
		}
	}
	
	/**
	 * CDS parameter constructor
	 * @param numOfCourses
	 */
	public CourseDBStructure(int numOfCourses) {
		hashTable = new LinkedList[numOfCourses];
		for(int i = 0; i < numOfCourses; i++) {
			hashTable[i] = new LinkedList<CourseDBElement>();
		}
	}
	
	/** 
	* Adds element to hash table if it doesn't already exist
	* @param element the CDE to be added
	*/
	public void add(CourseDBElement element) {
		int hashCode = element.hashCode();
		int index = hashCode%getTableSize();
		
		if(hashTable[index].isEmpty()) {
			hashTable[index].add(element);
		} else {
			boolean elementExists = false;
			for(int i = 0; i < hashTable[index].size(); i++) {
				if(hashTable[index].get(i).compareTo(element) == 0) {
					elementExists = true;
				}
			}
			if(!elementExists) {
				hashTable[index].add(element);
			}
		}
	}
	
	/** 
	* Returns the course data element if it exists
	* @param element the CDE to be added
	* @throws IOException 
	*/
	public CourseDBElement get(int crn) throws IOException {
		String key = Integer.toString(crn);
		int hashCode = key.hashCode();
		int index = hashCode%getTableSize();

		for(int i = 0; i < hashTable[index].size(); i++) {
			if(hashTable[index].get(i).getCRN() == crn) {
				return hashTable[index].get(i);
			}
		}
		
		throw new IOException();
	}

	/**
	* Returns the size of the ConcordanceDataStructure
	* @return size - number of indexes in the array
	*/
	public int getTableSize() {
		return hashTable.length;
	}
}

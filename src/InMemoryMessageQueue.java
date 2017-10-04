import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class InMemoryMessageQueue implements MessageQueue {
	
	public static final int GLOBAL_ID = 1000; 
	public static final String ERROR = "ERROR"; 
	// Change to private later 
	public Map<Integer, Queue<String>> messageQueues_ = new HashMap<Integer, Queue<String>>();
	
	public InMemoryMessageQueue() {
		Queue<String> GLOBAL = new ArrayDeque<String>();
		messageQueues_.put(GLOBAL_ID, GLOBAL);
	}

	/**
	 * Adds message to queue and returns status
	 */
	@Override
	public int AddMessage(int userID, int queueID, String message) {
		if (!messageQueues_.containsKey(queueID)) {
			Queue<String> newQueue = new ArrayDeque<String>(); 
			newQueue.add(message); // case of add failure? 
			messageQueues_.put(queueID, newQueue );
			return 0; 
		}
		// add message to specified queues, REMEMBER: add failure conditions
		messageQueues_.get(queueID).add(message); 
		
		return 0;
	}

	/**  
	 * Returns message from queue to user 
	 */
	@Override
	public String GetMessage(int userID, int queueID) {
		if (!messageQueues_.containsKey(queueID)) {
			return ERROR; 
		}
		String mes = messageQueues_.get(queueID).poll(); 
		return mes;
	}

	
}

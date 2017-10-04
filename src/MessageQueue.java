/**
 * 
 * @author yiboz
 * Defining the functionality of the queues 
 * In the future, return status metadata 
 */
public interface MessageQueue {
	int AddMessage(int userID, int queueID, String message);
	String GetMessage(int userID, int queueID); 
}

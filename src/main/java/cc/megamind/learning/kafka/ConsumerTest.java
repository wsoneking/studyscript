package cc.megamind.learning.kafka;

import java.net.UnknownHostException;

import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;

import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
 
public class ConsumerTest implements Runnable {
    private KafkaStream m_stream;
    private int m_threadNumber;
 
    public ConsumerTest(KafkaStream a_stream, int a_threadNumber) {
        m_threadNumber = a_threadNumber;
        m_stream = a_stream;
    }
 
    public void run() {
        ConsumerIterator<byte[], byte[]> it = m_stream.iterator();
        while (it.hasNext()){
        	String messagepayload = new String(it.next().message());
        	System.out.println("Thread " + m_threadNumber + ": " + messagepayload);
        	

			// write into MongoDB Jin
			String dbUrl = "10.252.3.186";
			String dbName = "admin";
			int dbPort = 27017;
			String dbColl = "testKafkaMessages";

			// create the connection and login as root
			MongoDB mgdb = new MongoDB(dbUrl, dbName, dbPort);
			try {
				mgdb.connectToDbWithoutAuth();
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			DBCollection collection = mgdb.getDB().getCollection(dbColl);

			DBObject insertDBObject = (DBObject) JSON.parse(messagepayload);
			

			collection.insert(insertDBObject);
        	
        }
            
        System.out.println("Shutting down Thread: " + m_threadNumber);
    }
}
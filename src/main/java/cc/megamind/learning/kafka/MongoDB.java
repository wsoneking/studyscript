package cc.megamind.learning.kafka;

/**
 * I copied this main code from daalt-mongodb, which we maintained before. 
 * I removed the dependency of daalt-mongodb project in pom, and add org.mongo as direct dependency. 
 * Pay attention to the version of jar file under Maven Dependencies!
 *   
 *   Jin 
 */

import java.net.UnknownHostException;
import java.util.List;
import java.util.Set;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;

public class MongoDB {

	MongoClient mongoClient;
	static DBCollection collection;
	DB db;
	String dbLocation;
	String dbName;
	int dbPort;
	Set<String> excludes;
	
	public MongoDB(String dbLocation, String dbName, int dbPort) {
		this.dbLocation = dbLocation;
		this.dbName = dbName;
		this.dbPort = dbPort;
	}


	public void connectToDb(String myUserName, char[] myPassword)
			throws UnknownHostException {
		mongoClient = new MongoClient(dbLocation, dbPort);
		db = mongoClient.getDB(dbName);
		@SuppressWarnings("deprecation")
		boolean auth = db.authenticate(myUserName, myPassword);
		if (!auth) {
			System.out.println("login Fail.");
		}
	}

	public void connectToDbWithoutAuth()
			throws UnknownHostException {
		mongoClient = new MongoClient(dbLocation, dbPort);
		db = mongoClient.getDB(dbName);
	}

	public DB getDB() {
		return db;
	}

	public void getCollection(String collname) {
		collection = db.getCollection(collname);
	}

	public void closeDB() {
		mongoClient.close();
	}

	public void printListOfColls() {
		Set<String> colls = db.getCollectionNames();
		for (String s : colls) {
			System.out.println(s);
		}
	}
	
	
	@SuppressWarnings("unchecked")
	public List<String> getSuiteNames() {
		getCollection("TestEngineDB");
		return (List<String>) collection.distinct("suiteName");

	}
	
	public void printDB() {
		DBCursor cursor = collection.find();
		System.out.println();
		System.out.println("Number of data in this DB: " + cursor.count());
		while (cursor.hasNext()) {
			// System.out.println(cursor.toString());
			System.out.println(cursor.next());
		}
	}


}

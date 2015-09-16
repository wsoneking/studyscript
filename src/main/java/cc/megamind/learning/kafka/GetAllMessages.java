package cc.megamind.learning.kafka;

public class GetAllMessages {
	
	public static void main(String[] args) {
        String zooKeeper = "10.252.5.103:2181"; // args[0];	// 10.252.5.240:9092
        String groupId = "test-consumer-group"; // args[1];	// daaltale1
        String topic = "tincan_raw2.0"; // args[2];		// tincan_raw2.0
        int threads = 3;
 
        ConsumerGroupExample example = new ConsumerGroupExample(zooKeeper, groupId, topic);
        example.run(threads);
 
        System.out.println("Start to wait 20 seconds");
        try {
            Thread.sleep(20000);
        } catch (InterruptedException ie) {
 
        }
        System.out.println("Finish waiting");

        example.shutdown();
    }

}

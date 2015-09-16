package cc.megamind.learning;

class StringTest {
	
	public static void main (String... args) {
		char a1 = 'a';
		char a2 = 'b';
		int a3 = 23;
		float a4 = 34.3f;
		System.out.println(a3<=a1);
		
		StringTest t = new StringTest();
		
		String ttt = "abcd";
		System.out.println(ttt.length());		
		System.out.println((int)'a');
		System.out.println(ttt.startsWith("b"));
		int[] bb = {1,2,3,4};
		String[] strs = new String[]{"hell","world"};
		System.out.println("this is "+calculate(3, strs));
		
		StringBuilder sb = new StringBuilder();

		
	}
	
	static int calculate(int integers, String... fl) {
		return 0;
	}
	
	int name;
	static int aaa;
	String bankName;
	
	int getBankVaultValue() {
		return name;
	}
	
	long getBankVaultValue22() {
		short cc;
		cc = 23;
		return cc;
	}
	
	void setBank(String str) {
		bankName = str;
		return;
	}
	
}


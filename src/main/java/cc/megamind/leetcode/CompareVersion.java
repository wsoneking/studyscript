package cc.megamind.leetcode;

public class CompareVersion {
	
	public static void main(String[] args) {
		String v1 = "1.2.3";
		String v2 = "1.1.23";
		System.out.println(compareVersion(v1,v2));
	}

	
	public static int compareVersion(String version1, String version2) {
        if(version1 == null && version2 == null) {
            return 0;
        } else if (version2 == null) {
            return 1;
        } else if (version1 == null) {
            return -1;
        } else if(version1.length() == 0 && version2.length() == 0) {
            return 0;
        }
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int i=0;
        while(i<v1.length && i<v2.length) {
            int v1value = Integer.valueOf(v1[i]);
            int v2value = Integer.valueOf(v2[i]);
            if( v1value > v2value) {
                return 1;
            } else if(v1value < v2value) {
                return -1;
            } else if(i==v1.length-1 && i==v2.length-1){
                return 0;
            }
            i++;
        }
        if(i==v1.length) {
            return -1;
        } else {
            return 1;
        }
    }
}

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Vector;

/**
 * 
 */

/**
 * @author Administrator
 * 
 */
public class A {

	public int a;
	
	public A(String name) {
		this.name = name;
	}

	private String name = "Jimmy";

	public void setName(String name) {
		this.name = name;
	}
	
	{
		System.out.println("#############################################");
	}

	/**
	 * @param args
	 * @throws ClassNotFoundException 
	 */
	public static void main(String ... args) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		
		
		System.out.println("AA, " + args.length);

		int c[][] = { { 1, 2 }, { 3, 4, 5 } };
		System.out.println(c.length); // 2
		System.out.println(c[1].length); // 3
		System.out.println(c[0].length); // 2
		System.out.println(c[1].length); // 3

		int[] array2[] = { { 1, 2, 3 }, { 4, 5 } };
		System.out.println("aaa:"+array2.length);// 2
		System.out.println("bbb:"+array2[0].length);// 3

		int a[] = { 1, 2 };
		int b[][] = { { 11, 12 }, { 21, 22 } };
		// a = b;
		// b = a;

		float floatMax = Float.MAX_VALUE;
		int intMax = Integer.MAX_VALUE;
		System.out.println(floatMax);
		System.out.println(intMax);
		System.out.println(floatMax > intMax);

		float floatMin = Float.MIN_VALUE;
		int intMin = Integer.MIN_VALUE;
		System.out.println(floatMin);
		System.out.println(intMin);
		System.out.println(floatMin > intMin);

		System.out.println(Double.parseDouble("3123123123124123124124131241231241231241231.1231248190257890823590729304791273940723"));

		
		A user = new A("Jimmy");
		System.out.println("user:"+user+", user.getName:"+user.getName());
		foo(user);
		System.out.println("user:"+user+", user.getName:"+user.getName());
		
		int i = 1;
		System.out.println("i:"+i);
		bar(i);
		System.out.println("i:"+i);
		
		Integer integer = 1;
		System.out.println("integer:"+integer);
		bar(integer);
		System.out.println("integer:"+integer);
		
		String str = "111";
		System.out.println("str:"+str);
		zzz(str);
		System.out.println("str:"+str);
		
		
		int array[] = {1,1};
		int bbb[] = array;
		int ccc[] = bbb;
		ccc[0] = 2;
		System.out.println(array[0]);//2
		
		System.out.println(bbb);
		
		String str1 = "abcdef";
					 //012345
		System.out.println(str1.substring(1, str1.length() - 1)); // It will throw IndexOutOfBoundsException
		System.out.println(str1.substring(1, 2)); // It will throw IndexOutOfBoundsException
		
		
		String atr = new String("abc");
		
		
		Map map1 = new HashMap();
		Map map2 = new Hashtable();
		map1.put(null, null);
		map2.put(1, 2);
		System.out.println(map1.get(null));
		System.out.println(map2.get(1));
		
		List list1 = new ArrayList();
		List list2 = new Vector();
		list1.add(null);
		list2.add(null);
		list1.get(0);
		list2.get(0);
		
		
//		A.class.getClassLoader().loadClass("A");
//		Class.forName("A");
		String str11 = "abcedfadsfeasdfea";
		String str12 = "abcedfadsfeasdfea";
		String str13 = new String("abcedfadsfeasdfea");
		
		StringBuffer sb1 = new StringBuffer("abc");
		StringBuffer sb2 = new StringBuffer("abc");
		
		System.out.println(str11 == str12);
		System.out.println(str11 == str13);
		
		System.out.println(str11.hashCode());
		System.out.println(str12.hashCode());
		System.out.println(str13.hashCode());
		System.out.println(sb1.hashCode());
		System.out.println(sb2.hashCode());
		
	}
	
	public String getName() {
		return name;
	}
	
	private static void foo(A a){
		a.setName("David");
		a = new A("Kenny");
		a.setName("Jack");
	}
	
	private static void bar(int i){
		i=3;
	}
	
	private static void bar(Integer i){
		i=3;
	}
	
	private static void zzz(String str){
		str = "abc";
	}
	
	
	public void ma() throws Exception {

	}
	
	

}


class B extends A{
	public B(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}


	public void ma() throws MyException {
	}
}


class MyException extends Exception {
	
}

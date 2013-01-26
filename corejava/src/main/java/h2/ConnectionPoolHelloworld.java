package h2;

import java.sql.Connection;
import java.sql.SQLException;

import org.h2.jdbcx.JdbcConnectionPool;

/**
 * Default there's no max concurrent connection limit for each mode.
 * 
 * @author hejiaming
 *
 */
public class ConnectionPoolHelloworld {

	static JdbcConnectionPool pool = JdbcConnectionPool.create("jdbc:h2:~/test", "sa", "");
	
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		Class.forName("org.h2.Driver");

		// only one connection to one database, if opening two connections, the
		// two connection is for different database.
		/*for (int i = 0; i < 10000; i++) {
			System.out.println(i + ":"
					+ DriverManager.getConnection("jdbc:h2:mem:").hashCode());
		}*/

		//embedded mode
		/*for (int i = 0; i < 10000; i++) {
			System.out.println(i + ":"
					+ DriverManager.getConnection("jdbc:h2:~/test", "sa", "")
							.hashCode());
		}*/
		
		
		//embedded mode
		/*for (int i = 0; i < 10000; i++) {
			System.out.println(i + ":"
					+ DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "")
							.hashCode());
		}*/

		
		
		System.out.println("Maxiumn connection:" + pool.getMaxConnections());
		System.out.println("getLoginTimeout:" + pool.getLoginTimeout());
		pool.setMaxConnections(2);
		pool.setLoginTimeout(1);
		System.out.println("Maxiumn connection:" + pool.getMaxConnections());
		System.out.println("getLoginTimeout:" + pool.getLoginTimeout());

		
		new Thread(new Runnable() {
			
			public void run() {
				for (int i = 0; i < 100; i++) {
					try {
						Connection conn = pool.getConnection();
						System.out.println("active connection count:" + pool.getActiveConnections());
//						org.h2.jdbcx.JdbcXAConnection PooledJdbcConnection
						System.out.println("Thrad:" + Thread.currentThread().getName()+ ", connection:" + conn.hashCode());
						Thread.sleep(100);
						conn.close();
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
		}).start();
		
		new Thread(new Runnable() {
			
			public void run() {
				for (int i = 0; i < 100; i++) {
					try {
						Connection conn = pool.getConnection();
						System.out.println("active connection count:" + pool.getActiveConnections());
						System.out.println("Thrad:" + Thread.currentThread().getName()+ ", connection:" + conn.hashCode());
						Thread.sleep(100);
						conn.close();
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
		}).start();
		
//		for (int i = 0; i < 100; i++) {
//			
//			System.out.println(i + ":"+pool.getConnection().hashCode());
//			
//		}
		
	}

}




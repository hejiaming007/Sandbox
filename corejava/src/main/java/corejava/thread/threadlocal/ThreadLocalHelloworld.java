package corejava.thread.threadlocal;


public class ThreadLocalHelloworld {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		SequenceNumber sn = new SequenceNumber();
		
		TestClient t1 = new TestClient(sn);
		TestClient t2 = new TestClient(sn);
		TestClient t3 = new TestClient(sn);
		t1.start();
		t2.start();
		t3.start();
		
		Thread.sleep(100);
		
		System.out.println("Conculsion: If with Thread local support, each Thread holds its local object and won't affect by others threads. ");
	}

}


class TestClient extends Thread {
	
	private SequenceNumber sn;
	
	/**
	 * Threadlocal object inside a thread so that each thread will have a self thread local object.
	 */
	ThreadLocal<ThreadLocalContext> threadLocal = new ThreadLocal<ThreadLocalContext>(){
		protected ThreadLocalContext initialValue() {
			return new ThreadLocalContext();
		}
	};
	
	public TestClient(SequenceNumber sn) {
		this.sn = sn;
	}
	
	public synchronized int getNextNum() {
		ThreadLocalContext temp = threadLocal.get();
		temp.setSeqNumb(temp.getSeqNumb() + 1);
		return threadLocal.get().getSeqNumb();
	}
	
	public synchronized SimpleObject getBBB(){
		return threadLocal.get().getBbb();
	}
	
	
	@Override
	public void run() {
		for (int i = 0; i < 3; i++) {
			System.out.println("thread["+Thread.currentThread().getName()+", "+(i+1)+"th] SequenceNumber, "+ sn.getBbb() +"(without ThreadLocal support):["+sn.getNextNum()+"], SequenceNumber, "+getBBB()+"(with ThreadLocal support):[" + getNextNum() + "]");
		}
	}
	
}


class SequenceNumber {
	
	private SimpleObject simpleObject = new SimpleObject();
	
	private Integer seqNum = new Integer(0);

	public synchronized int getNextNum() {
		seqNum = seqNum + 1;
		return seqNum;
	}
	
	public SimpleObject getBbb(){
		return simpleObject;
	}
	
}

class ThreadLocalContext {
	
	private SimpleObject simpleObject = new SimpleObject();
	
	private Integer seqNumb = 0;
	
	public SimpleObject getBbb() {
		return simpleObject;
	}
	
	public Integer getSeqNumb() {
		return seqNumb;
	}
	
	public void setSeqNumb(Integer seqNumb) {
		this.seqNumb = seqNumb;
	}
}

class SimpleObject{
	
}
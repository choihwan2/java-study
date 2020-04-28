package selftest.java.mythread.procon;

import java.util.LinkedList;

/*
 * 공용객체를 만들기 위한 클래스 각 Thread 가 공유하는 자료구조
 * 이 자료구조를 사용하기 위한 method
 * 공유객체는 여러개가 필요 없어요.. 1개만 존재하고 
 * 이 1개의 공유객체를 여러개의 Thread 가 공유해서 사용
 * => Singleton 패턴
 */
public class SharedObject {

	private final static SharedObject instance = new SharedObject();
	// 공용으로 사용하는 데이터가 존재
	// 숫자를 저장하는 자료구조를 하나 만들어서 이 자료구조를 각 Thread가 공유하게끔 처리!
	private LinkedList<String> list = new LinkedList<String>();

	private static final Object MONITOR = new Object();

	// Singleton 에서는 생성자가 private으로 지정합니다.
	// 그래야지 class 외부에서 (다른 class 에서) 생성자가 반복 호출되서 객체가
	// 여러개 생성되는걸 막을 수 있어요!!
	private SharedObject() {

	}

	public static SharedObject getInstance() {
		return instance;
	}

	// Thread에 의해서 공용으로 사용되는 Business method 가 필요!
	// 2 종류의 Thread 가 있는데 하나는 생산자(자료구조에 데이터를 집어 넣는일)
	// 하나는 소비자(자료구조에서 데이터를 빼내서 화면에 출력하는일)
	// 생산자 Thread 에 의해서 사용되는 method
	public void put(String s) {
		synchronized (MONITOR) {
			list.addLast(s);
			MONITOR.notify();
		}
	}

	// 소비자 Thread 에 의해서 사용되는 method

	public String pop() {
		// list 안에 데이터가 있어야 removeFirst() 호출 가능!!
		String result = null;

		synchronized (MONITOR) {
			while (list.isEmpty()) {
				try {
					MONITOR.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			result = list.removeFirst();
		}
		return result;
	}
}

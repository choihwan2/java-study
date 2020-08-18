package ssafy.java.hw0818;

import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;

public class ProductMgrImpl implements IProudctMgr {
	ArrayList<Product> list = new ArrayList<>();

	@Override
	public void add(Product p) {
		list.add(p);
	}

	@Override
	public Product[] searchAllProduct() {
		Product[] arr = new Product[list.size()];
		list.toArray(arr);
		return arr;
	}

	@Override
	public Product[] searchProduct(int no) {
		int cnt = 0;
		int index = 0;
		for (Product product : list) {
			if (product.getNo() == no)
				cnt++;
		}
		Product[] searchProducts = new Product[cnt];
		for (Product product : list) {
			if (product.getNo() == no)
				searchProducts[index++] = product;
		}
		return searchProducts;
	}

	@Override
	public Product[] searchProduct(String name) {
		int cnt = 0;
		int index = 0;
		for (Product product : list) {
			if (product.getName().equals(name))
				cnt++;
		}
		Product[] searchProducts = new Product[cnt];
		for (Product product : list) {
			if (product.getName().equals(name))
				searchProducts[index++] = product;
		}
		return searchProducts;
	}

	@Override
	public Product[] searchTV() {
		int cnt = 0;
		int index = 0;
		for (Product product : list) {
			if (product instanceof TV)
				cnt++;
		}
		Product[] searchProducts = new Product[cnt];
		for (Product product : list) {
			if (product instanceof TV)
				searchProducts[index++] = product;
		}
		return searchProducts;
	}

	@Override
	public Product[] searchRefrigerator() {
		int cnt = 0;
		int index = 0;
		for (Product product : list) {
			if (product instanceof Refrigerator)
				cnt++;
		}
		Product[] searchProducts = new Product[cnt];
		for (Product product : list) {
			if (product instanceof Refrigerator)
				searchProducts[index++] = product;
		}
		return searchProducts;
	}

	@Override
	public Product[] search400LRefrigeratort() {
		int cnt = 0;
		int index = 0;
		for (Product product : list) {
			if (product instanceof Refrigerator) {
				Refrigerator ref = (Refrigerator) product;
				if (ref.getCapacity() >= 400)
					cnt++;
			}
		}
		Product[] searchProducts = new Product[cnt];
		for (Product product : list) {
			if (product instanceof Refrigerator) {
				Refrigerator ref = (Refrigerator) product;
				if (ref.getCapacity() >= 400)
					searchProducts[index++] = product;
			}
		}
		return searchProducts;
	}

	@Override
	public Product[] search50InchTv() {
		int cnt = 0;
		int index = 0;
		for (Product product : list) {
			if (product instanceof TV) {
				TV ref = (TV) product;
				if (ref.getInch() >= 50)
					cnt++;
			}
		}
		Product[] searchProducts = new Product[cnt];
		for (Product product : list) {
			if (product instanceof TV) {
				TV ref = (TV) product;
				if (ref.getInch() >= 50)
					searchProducts[index++] = product;
			}
		}
		return searchProducts;
	}

	@Override
	public void changeProductPrice(int no, int price) {
		for (Product product : list) {
			if (product.getNo() == no)
				product.setPrice(price);
		}
	}

	@Override
	public void deleteProduct(int no) {
		Iterator<Product> it = list.iterator();
		while (it.hasNext()) {
			Product product = (Product) it.next();
			if (product.getNo() == no)
				it.remove();
		}
	}

	@Override
	public int getAmountPriceSum() {
		int sum = 0;
		Iterator<Product> it = list.iterator();
		while (it.hasNext()) {
			Product product = (Product) it.next();
			sum += product.getPrice() * product.getAmount();
		}
		return sum;
	}

	@Override
	public void makeProductdat() {
		new Thread() {
			public void run() {
				try (PrintWriter pw = new PrintWriter(new FileWriter("product.dat", true), false);) {
					for (Product product : list) {
						pw.println(product);
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			};
		}.start();
	}

	@Override
	public void sendProductToServer() {
		new Thread() {
			@Override
			public void run() {
				try (Socket s = new Socket("localhost", 8400);
						PrintWriter pw = new PrintWriter(new OutputStreamWriter(s.getOutputStream()), true);) {
					StringBuilder stb = new StringBuilder();
					for (Product product : list) {
						if (product instanceof TV) {
							pw.println(product);
						} else if (product instanceof Refrigerator) {
							stb.append(product + "\n");
						}
					}
					pw.append(stb.toString());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}.start();
	}

}

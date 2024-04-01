import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Prob4 {

	public static void main(String[] args) {
		Product[] prodList = {
				new Product("NT450R5E-K24S",500000,"삼성전자"),
				new Product("15UD340-LX2CK",400000,"LG전자"),
				new Product("G2-K3T32AV",600000,"HP") };
		HashSet<Product> product_hs = makeHashSet(prodList, 500000);
		makeFile(product_hs);
		readFile();
		
	}

	
	private static HashSet<Product> makeHashSet(Product[] prodList, int price) {
		//구현하시오...return값 수정하기 
		HashSet<Product> pset = new HashSet<>();
		
		for(Product p:prodList) {
			if(p.getPrice()>=price) {
				pset.add(p);
			}
		}
		
		return pset;
	}


	private static void makeFile(HashSet resultList)  {
		//구현하시오.
		
		//여기서 파일경로 수정해주세요. 개인 노트북이라 경로가 다릅니다.
		String fileName = "C:\\University\\GitHub\\Shinhan-SW-Academy\\JAVA_Project\\src\\data.txt";
		File file = new File(fileName);
		
		try {
			FileWriter fw = new FileWriter(file,false);
			
			Iterator<Product> iterator= resultList.iterator();
			System.out.println("*특정 금액 이상의 상품 결과입니다***********");
			while(iterator.hasNext()) {
				Product p = iterator.next();
				System.out.println(p.toString());
				fw.write(p.toString()+"\r\n");
				
				//fw.flush();
			}
			
			fw.close();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private static void readFile()  {
		//구현하시오. 
		
		//파일 경로 수정해주세요.
		String fileName = "C:\\University\\GitHub\\Shinhan-SW-Academy\\JAVA_Project\\src\\data.txt";

		try {
			BufferedReader rd = new BufferedReader(new FileReader(fileName));
			System.out.println("*readFile 결과입니다***********");

			String str;        
			try {
				while ((str = rd.readLine()) != null) {
					System.out.println(str);
					}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}


class Product implements Serializable{
	private String model_name;
	private int price;
	private String company;
	
	
	public Product(String model_name, int price, String company) {
		super();
		this.model_name = model_name;
		this.price = price;
		this.company = company;
	}


	public String getModel_name() {
		return model_name;
	}


	public void setModel_name(String model_name) {
		this.model_name = model_name;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public String getCompany() {
		return company;
	}


	public void setCompany(String company) {
		this.company = company;
	}


	@Override
	public String toString() {
		return "Product [model_name=" + model_name + ", price=" + price
				+ ", company=" + company + "]";
	}
	
	

}
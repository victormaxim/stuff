package base.data;

import base.data.pojos.Product;
import base.data.pojos.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by optaros on 3/25/15.
 */
public class TestDataReader {

	ObjectMapper mapper = new ObjectMapper();


	private HashMap<String, User> readUsers(){

		HashMap<String, User> map = null;
		try {
			map = mapper.readValue(Thread.currentThread().getContextClassLoader().getResourceAsStream("TESTDATA/users.json"), new TypeReference<HashMap<String, User>>() {});
		} catch (IOException e) {
			e.printStackTrace();
		}
		return map;
	}

	public User getUserByType(String userType){
		return readUsers().get(userType);
	}

	public User getRndUser(){

		HashMap<String, User> users = readUsers();

		for (Map.Entry<String, User> entry : users.entrySet()) {
			if((Math.random()*10)>5){
				return entry.getValue();
			}
		}
		return users.get("us_1");
	}


	private ArrayList<Product> loadAllProducts(){
		ArrayList<Product> products = new ArrayList<Product>();
		try {
			Product[] productArr = mapper.readValue(Thread.currentThread().getContextClassLoader().getResourceAsStream("TESTDATA/products.json"), Product[].class);
			products.addAll(Arrays.asList(productArr));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return products;
	}


	public Product getProductById(String productID){

		for (Product product : loadAllProducts()) {
			if (product.getItemNumber().equals(productID)){
				return product;
			}
		}
		return null;
	}

	public Product getProductWithVariant(String variantName){
		if(variantName.equalsIgnoreCase("color")){
			for (Product product : loadAllProducts()) {
				if(product.isColorSelect()) return product;
			}
		}else if(variantName.equalsIgnoreCase("length")){
			for (Product product : loadAllProducts()) {
				if(product.isLengthSelect()) return product;
			}
		}else if(variantName.equalsIgnoreCase("size")){
			for (Product product : loadAllProducts()) {
				if(product.isSizeSelect()) return product;
			}
		}else if(variantName.equalsIgnoreCase("style")){
			for (Product product : loadAllProducts()) {
				if(product.isStyleSelect()) return product;
			}

		}else if(variantName.equalsIgnoreCase("styleWithImage")){
			for (Product product : loadAllProducts()) {
				if(product.isStyleWithImageSelect()) return product;
			}
		}
		return null;
	}

	public Product getSimpleProduct(){
		for (Product product : loadAllProducts()) {
			if(!product.isStyleWithImageSelect() && !product.isLengthSelect() && !product.isStyleSelect() && !product.isColorSelect() && !product.isSizeSelect()){
				return product;
			}
		}
		return null;
	}

	public Product getCallForQuoteProduct(){
		for (Product product : loadAllProducts()) {
			if(product.isCallForQuote()){
				return product;
			}
		}
		return null;
	}

}

package Assignment_9.CartApp;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;

@SpringBootApplication
public class CartApp {
	public static void main(String[] args) {
		SpringApplication.run(CartApp.class, args);
	}
	// 상품 목록 생성
	Set<Product> ProductSet = new HashSet<>();
	//TODO: 상품 클래스를 생성하여 상품 목록에 넣는다.

	//상품 목록 확인
	System.out.println("고유 상품 목록:");
	for(Product product : productSet) {
		System.out.println(product.getName() + " : " + product.getPrice());
	}

	//장바구니 생성
	Cart myCart = new Cart();
	//TODO: 상품을 장바구니에 추가
	//TODO: 상품을 장바구니에서 제거
	//TODO: 장바구니에 현재 담긴 상품들을 출력 (상품 이름, 각 상품의 갯수)

}

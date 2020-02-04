package org.kimbs.jwt;

import org.kimbs.jwt.model.Product;
import org.kimbs.jwt.model.Role;
import org.kimbs.jwt.model.code.RoleCode;
import org.kimbs.jwt.repository.ProductRepository;
import org.kimbs.jwt.repository.RoleRepository;
import org.kimbs.jwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		roleRepository.deleteAll();
		productRepository.deleteAll();
		userRepository.deleteAll();

		Role roleAdmin = new Role();
		roleAdmin.setRole(RoleCode.ROLE_ADMIN.getCode());
		roleRepository.insert(roleAdmin);

		Product product1 = new Product();
		product1.setDescription("상품1 입니다.");
		product1.setName("상품1");
		product1.setPrice(1000);
		product1.setImage("2020/product1.jpg");

		Product product2 = new Product();
		product2.setDescription("상품2 입니다.");
		product2.setName("상품2");
		product2.setPrice(2000);
		product2.setImage("2020/product2.jpg");

		Product product3 = new Product();
		product3.setDescription("상품3 입니다.");
		product3.setName("상품3");
		product3.setPrice(3000);
		product3.setImage("2020/product3.jpg");

		productRepository.insert(product1);
		productRepository.insert(product2);
		productRepository.insert(product3);
	}
}

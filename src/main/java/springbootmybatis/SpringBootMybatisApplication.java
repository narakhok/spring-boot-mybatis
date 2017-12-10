package springbootmybatis;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springbootmybatis.model.User;
import springbootmybatis.repository.UserRepository;


//we have to imple ApplicationRunner for run test 
@SpringBootApplication
public class SpringBootMybatisApplication implements ApplicationRunner {
	@Autowired
	public UserRepository userRepository;
	public static void main(String[] args) {
		SpringApplication.run(SpringBootMybatisApplication.class, args);		
		 
	}
	
	@Override
	public void run(ApplicationArguments arg0) throws Exception {
		User user1 = new User(1,"A",98);
		User user2 = new User(2,"B",99);
		User user3 = new User(3,"C",100);
		User user4 = new User(4,"D",101);
		
		userRepository.save(user1);
		userRepository.save(user2);
		userRepository.save(user3);
		userRepository.save(user4);
		
	ArrayList<User> users= userRepository.findAll();
	for(User user: users)
	{
		System.out.println(user.toString());
	}
		User user = userRepository.findByID(1);
		System.out.println(user.toString());
	}
}

package springbootmybatis.repository;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import springbootmybatis.model.User;

@Repository
public interface UserRepository {

	@Insert("INSERT INTO tbuser(id,name,age) VALUES(#{id},#{name},#{age})")
	public boolean save(User user);
	
	@Select("SELECT id,name,age FROM tbuser WHERE id=#{id}")
	public User findByID(Integer id);
	
	@Select("SELECT id,name,age FROM tbuser")
	public ArrayList<User> findAll();
	
	@Update("UPDATE	tbuser SET id=#{id},name=#{name},age=#{age} WHERE id=#{id}")
	public boolean update(User user);
	
	
}

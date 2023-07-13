package com.example.demo.repositories;

import com.example.demo.entities.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
/* This interface gives access to all CRUD operations on the User table in database*/
public interface UserRepository extends CrudRepository<UserEntity,Integer> {

    @Query(value = "select email from user" ,nativeQuery = true)
    public List<String> getAllEmail();

    @Query(value = "select phone from user" ,nativeQuery = true)
    public List<String> getAllPhone();
    @Query(value = "select * from user where email=?1",nativeQuery = true)
    Optional<UserEntity> findByEmail(String email);

    @Query(value = "select p.p_id,p.name,count(u.id) as qty from user u join user_cart c on u.id=c.id \n" +
            "join product p on c.p_id=p.p_id where u.id=?1 group by c.p_id;",nativeQuery = true)
    List<Object[]> getCart(int userid);



}

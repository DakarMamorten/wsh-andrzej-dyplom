package com.dyplom.repository;

import com.dyplom.domain.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RequestRepository extends JpaRepository<Request, Long> {
    @Query(value = "SELECT r FROM Request r WHERE r.user.username =:userName")
    List<Request> findAllByUsername(String userName);

}

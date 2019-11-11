package com.viva.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.viva.model.CustomerDetails;
@Repository
public interface CustomerRepository extends JpaRepository<CustomerDetails,String> {
}

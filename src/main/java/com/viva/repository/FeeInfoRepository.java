package com.viva.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.viva.model.FeeInformation;

@Repository
public interface FeeInfoRepository extends JpaRepository<FeeInformation,String> {

	@Query(value = "SELECT creationDate,Sum(feeAmount) FROM FeeInformation group by creationDate")
	List<Object[]> calculateFee();
}

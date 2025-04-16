package com.onlinedairy.repository;

import com.onlinedairy.model.MilkRequest;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
//@Repository
//public interface MilkRequestRepository extends JpaRepository<MilkRequest, Long> {
//    List<MilkRequest> findByFarmerEmail(String email);
//    Optional<MilkRequest> findByEmployee(String employee); // If additional employee-specific queries are required
//}
@Repository
public interface MilkRequestRepository extends JpaRepository<MilkRequest, Long> {

    @Query("SELECT m FROM MilkRequest m WHERE m.farmerEmail = :email")
    List<MilkRequest> findByFarmerEmail(@Param("email") String email);

    Optional<MilkRequest> findByEmployee(String employee);


    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("SELECT m FROM MilkRequest m WHERE m.id = :id")
    Optional<MilkRequest> findForUpdateById(@Param("id") Long id);
}
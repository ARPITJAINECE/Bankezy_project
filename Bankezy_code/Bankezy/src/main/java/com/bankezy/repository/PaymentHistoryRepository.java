package com.bankezy.repository;

import com.bankezy.models.PaymentHistory;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentHistoryRepository extends CrudRepository<PaymentHistory, Integer> {

    @Query(value = "SELECT * FROM v_payments WHERE user_id = :user_id", nativeQuery = true)
    List<PaymentHistory> getPaymentRecordsById(@Param("user_id")int user_id);
}

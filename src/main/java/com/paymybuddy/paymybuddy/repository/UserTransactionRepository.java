package com.paymybuddy.paymybuddy.repository;

import com.paymybuddy.paymybuddy.models.BankCard;
import com.paymybuddy.paymybuddy.models.User;
import com.paymybuddy.paymybuddy.models.UserTransaction;
import com.paymybuddy.paymybuddy.models.dto.PaymentDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserTransactionRepository extends CrudRepository<UserTransaction, Integer> {

    @Query(value = "SELECT t.description_transaction, t.amount, u.beneficiary_user_id FROM user_transaction t INNER JOIN transfer_to_user u ON u.user_transaction_id = t.transaction_id WHERE t.transaction_id = u.user_transaction_id AND t.user_id = ?", nativeQuery = true)
    List<PaymentDto> paymentByCurrentUser(Integer userId);
    List<UserTransaction> findByUser(User user);

}

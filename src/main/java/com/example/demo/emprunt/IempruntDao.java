package com.example.demo.emprunt;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IempruntDao extends JpaRepository<Emprunt, Integer> {

	public List<Emprunt> findByEndDateBefore(LocalDate maxEndDate);
    
    @Query("SELECT lo "
         + "FROM Loan lo "
         + "INNER JOIN lo.pk.customer c "
         + "WHERE UPPER(c.email) = UPPER(?1) " //converti en majuscule
         + "   AND lo.status = ?2 ")
 public List<Emprunt> getAllOpenLoansOfThisCustomer(String email, LoanStatus status);
 
    @Query("SELECT lo "
         + "FROM Loan lo "
         + "INNER JOIN lo.pk.book b "
         + "INNER JOIN lo.pk.customer c "
         + "WHERE b.id =    ?1 "
         + "   AND c.id = ?2 "
         + "   AND lo.status = ?3 ")
 public Emprunt getEmpruntByCriteria(Integer bookId, Integer customerId, LoanStatus status);
}

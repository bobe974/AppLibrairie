package com.example.demo.emprunt;

import java.time.LocalDate;
import java.util.List;

public interface IEmpruntService {
	
public List<Emprunt> findAllLoansByEndDateBefore(LocalDate maxEndDate);
    
    public List<Emprunt> getAllOpenLoansOfThisCustomer(String email, LoanStatus status);
    
    public Emprunt getOpenedLoan(SimpleLoanDTO simpleLoanDTO);
    
    public boolean checkIfLoanExists(SimpleLoanDTO simpleLoanDTO);
    
    public Emprunt saveLoan(Emprunt loan);
    
    public void closeLoan(Emprunt loan);
}

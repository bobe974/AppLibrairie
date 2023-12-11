package com.example.demo.emprunt;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service("empruntService")
@Transactional
public class EmpruntServiceImpl implements IEmpruntService {

	@Autowired
    private IempruntDao empruntDao;

    @Override
    public List<Emprunt> findAllLoansByEndDateBefore(LocalDate maxEndDate) {
        return empruntDao.findByEndDateBefore(maxEndDate);
    }
    
    @Override
    public List<Emprunt> getAllOpenLoansOfThisCustomer(String email, LoanStatus status) {
        return empruntDao.getAllOpenLoansOfThisCustomer(email, status);
    }
    
    @Override
    public Emprunt getOpenedLoan(SimpleLoanDTO simpleLoanDTO) {
        return empruntDao.getLoanByCriteria(simpleLoanDTO.getBookId(), simpleLoanDTO.getCustomerId(), LoanStatus.OPEN);
    }
    
    @Override
    public boolean checkIfLoanExists(SimpleLoanDTO simpleLoanDTO) {
    	Emprunt loan = empruntDao.getLoanByCriteria(simpleLoanDTO.getBookId(), simpleLoanDTO.getCustomerId(), LoanStatus.OPEN);
        if(loan != null) {
            return true;
        }
        return false;
    }
    
    @Override
    public Emprunt saveLoan(Emprunt loan) {
        return empruntDao.save(loan);
    }
    
    /**
     * On fera de la suppression logique, car le statut de l'objet Loan est positionné à CLOSE.
     */
    @Override
    public void closeLoan(Emprunt loan) {
    	empruntDao.save(loan);
    }

	@Override
	public List<Emprunt> getAllOpenLoansOfThisCustomer(String email, LoanStatus status) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Emprunt getOpenedLoan(SimpleLoanDTO simpleLoanDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean checkIfLoanExists(SimpleLoanDTO simpleLoanDTO) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Emprunt> getAllOpenLoansOfThisCustomer(String email, LoanStatus status) {
		// TODO Auto-generated method stub
		return null;
	}

	
}

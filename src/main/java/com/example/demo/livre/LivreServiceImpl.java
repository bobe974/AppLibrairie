package com.example.demo.livre;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service("livreService") //permet à Spring de considérer la classe qui la porte comme un bean qu'il créera au démarrage de l'application
@Transactional
public class LivreServiceImpl implements ILivreService {

	 @Autowired //injecter un bean « supposé » existant dans le contexte de la classe appelante
	    private IlivreDao bookDao;
	 
	@Override
	public Livre saveBook(Livre book) {
		// TODO Auto-generated method stub
		return bookDao.save(book);
	
	}

	@Override
	public Livre updateBook(Livre book) {
		// TODO Auto-generated method stub
		return bookDao.save(book);
	}

	@Override
	public void deleteBook(Integer bookId) {
		// TODO Auto-generated method stub
		 bookDao.deleteById(bookId);
		
	}

	@Override
	public List<Livre> findBooksByTitleOrPartTitle(String title) {
		// TODO Auto-generated method stub
		return bookDao.findByTitreLikeIgnoreCase(
				new StringBuilder().append("%").append(title).append("%").toString()
				);
	}

	@Override
	public Livre findBookByIsbn(String isbn) {
		// TODO Auto-generated method stub
		return bookDao.findByIsbnIgnoreCase(isbn);
	}

	@Override
	public boolean checkIfIdexists(Integer id) {
		// TODO Auto-generated method stub
		return bookDao.existsById(id);
	}

	@Override
	public List<Livre> getBooksByCategory(String codeCategory) {
		// TODO Auto-generated method stub
		return bookDao.findByCategory(codeCategory);
	}

}

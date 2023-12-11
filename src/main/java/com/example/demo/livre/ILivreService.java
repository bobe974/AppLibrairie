package com.example.demo.livre;

import java.util.List;

public interface ILivreService {

	 public Livre saveBook(Livre book);
	    
	    public Livre updateBook(Livre book);
	    
	    public void deleteBook(Integer bookId);
	    
	    public List<Livre> findBooksByTitleOrPartTitle(String title);
	    
	    public Livre findBookByIsbn(String isbn);
	    
	    public boolean checkIfIdexists(Integer id);
	    
	    public List<Livre> getBooksByCategory(String codeCategory);
}

package com.example.demo.livre;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository    
public interface IlivreDao extends JpaRepository<Livre, Integer> {  //Livre: type entité  Integer: type clé primaire

	//fonctionne mécanisme de convention de nommage,mot clé "Find" "Isbn"  "IgnoreCase" est interprété par jpa 
	public Livre findByIsbnIgnoreCase(String isbn);
    
    public List<Livre> findByTitreLikeIgnoreCase(String title);
    
    
    /**
     * Nécéssite de requete JPQL car jointure entre 2 tables, la convention de nommage est utile dans le cas
     * cas simple
     * SELECT * FROM livre inner join categorie on categorie.code = livre.cat_code
    **/
       @Query("SELECT b "
            + "FROM Livre b "
            + "INNER JOIN b.category cat "
            + "WHERE cat.code = :code"
          )
    public List<Livre> findByCategory(@Param("code") String codeCategory);		
	
}

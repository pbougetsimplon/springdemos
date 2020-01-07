package fr.bouget.jpa.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import fr.bouget.jpa.model.Article;

/**
 * @author Philippe
 *
 */
@NoRepositoryBean
public interface ArticleRepository<T extends Article, ID extends Serializable> extends JpaRepository<T, ID> {

	
}

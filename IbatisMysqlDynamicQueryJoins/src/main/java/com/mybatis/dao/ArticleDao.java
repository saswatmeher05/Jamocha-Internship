package com.mybatis.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.mybatis.model.Article;

public class ArticleDao {

	/* returns list of all Article instances from database filtered by title */
	public List<Article> selectArticleByTitle(Article article) {
		SqlSessionFactory factory = MyBatisConnectionFactory.getSessionFactory();
		SqlSession session = factory.openSession();

		try {
			List<Article> list = session.selectList("Article.selectArticleByTitle", article);
			return list;
		} finally {
			session.close();
		}
	}
	
	public List<Article> selectArticleByTitleAndAuthor(Article article){
		SqlSessionFactory factory=MyBatisConnectionFactory.getSessionFactory();
		SqlSession session=factory.openSession();
		try {
			List<Article> list=session.selectList("Article.selectArticleByTitleAndAuthor", article);
			return list;
		}finally {
			session.close();
		}
	}
	
	public List<Article> selectArticleByTitleOrAuthorOrCategory(Article article){
		SqlSessionFactory factory=MyBatisConnectionFactory.getSessionFactory();
		SqlSession session=factory.openSession();
		try {
			List<Article> list=session.selectList("Article.selectArticleByTitleOrAuthorOrCategory", article);
			return list;
		}finally {
			session.close();
		}
	}
	
	public List<Article> selectArticleByTitleAndAuthorDynamic(Article article){
		SqlSessionFactory factory=MyBatisConnectionFactory.getSessionFactory();
		SqlSession session=factory.openSession();
		try {
			List<Article> list=session.selectList("selectArticleByTitleAndAuthorDynamic", article);
			return list;
		}finally {
			session.close();
		}
	}
	
	public List<Article> selectArticleByTitleAndAuthorDynamic2(Article article){
		SqlSessionFactory factory=MyBatisConnectionFactory.getSessionFactory();
		SqlSession session=factory.openSession();
		try {
			List<Article> list=session.selectList("selectArticleByTitleAndAuthorDynamic2",article);
			return list;
		}finally {
			session.close();
		}
	}
	
	public List<Article> selectArticleByListCategories(List<Integer> categories){
		SqlSessionFactory factory=MyBatisConnectionFactory.getSessionFactory();
		SqlSession session=factory.openSession();
		try {
			List<Article> list=session.selectList("selectArticleByListCategories",categories);
			return list;
		}finally {
			session.close();
		}
	}
	
	
}

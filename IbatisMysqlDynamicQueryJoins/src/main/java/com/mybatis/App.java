package com.mybatis;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale.Category;

import com.mybatis.dao.ArticleDao;
import com.mybatis.model.Article;

public class App {
	public static void main(String[] args) {
		ArticleDao dao = new ArticleDao();

		// All Articles
		System.out.println("--------|All Articles|---------");
		List<Article> al = dao.selectArticleByTitle(null);
		for (Article ar : al) {
			System.out.println(ar);
		}

		// Article by specific title
		System.out.println("--------|Articles by specific title|---------");
		Article art = new Article();
		art.setTitle("Getting Started with Ext JS");
		List<Article> lwt = dao.selectArticleByTitle(art);
		for (Article alt : lwt) {
			System.out.println(alt);
		}

		// Article by specific title and author
		System.out.println("--------|Article by specific title and author|---------");
		Article arr = new Article();
		arr.setTitle("Book Review: Ext JS in Action");
		arr.setAuthor("John");
		List<Article> lswt = dao.selectArticleByTitleAndAuthor(arr);
		for (Article altr : lswt) {
			System.out.println(altr);
		}

		// Article by specific title and author dynamic
		System.out.println("--------|Article by specific title and author dynamic|---------");
		Article arr1 = new Article();
		// since it is dynamic we can comment one of the following fields and output
		// will be same
		arr1.setTitle("Getting Started with Ext JS");
		arr1.setAuthor("Loiane Groner");
		List<Article> lswt1 = dao.selectArticleByTitleAndAuthorDynamic(arr1);
		for (Article altr : lswt1) {
			System.out.println(altr);
		}

		// Article by specific title and author dynamic2
		System.out.println("--------|Article by specific title and author dynamic2|---------");
		Article arr2 = new Article();
		// since it is dynamic we can comment one of the following fields and output
		// will be same
		arr2.setTitle("Book Review: Ext JS in Action");
		// arr2.setAuthor("John");
		List<Article> lswt2 = dao.selectArticleByTitleAndAuthorDynamic(arr2);
		for (Article altr : lswt2) {
			System.out.println(altr);
		}

		// Article by List Categories
		System.out.println("--------|Articles by List Category|---------");
		List<Integer> categories=new ArrayList<Integer>();
		categories.add(1);
		categories.add(3);
		categories.add(5);
		List<Article> lswt3 = dao.selectArticleByListCategories(categories);
		for (Article altr : lswt3) {
			System.out.println(altr);
		}

	}
}

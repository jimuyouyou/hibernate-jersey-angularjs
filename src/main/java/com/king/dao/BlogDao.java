package com.king.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.king.entity.Blog;
import com.king.test.HibernateTest;

public class BlogDao {
	public Blog findBlogById(String id) {
		Session session = HibernateTest.getSession();

		String hql = "from Blog b where b.id = :id";
		Blog blog = (Blog) (session.createQuery(hql).setString("id", id).uniqueResult());

		session.close();
		return blog;
	}

	public List<Blog> getAllBlogs() {
		Session session = HibernateTest.getSession();

		String hql = "from Blog";
		Query qry = session.createQuery(hql);
		List<Blog> list = qry.list();

		session.close();
		return list;
	}

	public void updateBlog(Blog blog) {
		Session session = HibernateTest.getSession();
		Transaction ts = session.beginTransaction();
		session.saveOrUpdate(blog);
		session.flush();
		ts.commit();
		session.close();
	}
	
	public static void main(String[] args) {
		Blog blog = new Blog();
		blog.setTitle("ttd");
		blog.setContent("conet");
		BlogDao dao = new BlogDao();
		dao.updateBlog(blog);
	}
}

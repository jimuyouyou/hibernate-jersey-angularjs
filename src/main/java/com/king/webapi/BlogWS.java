package com.king.webapi;

import java.util.Collection;

import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.king.dao.BlogDao;
import com.king.entity.Blog;

@Path("/blog")
public class BlogWS {

	@GET
	@Path("list")
	@Produces({ "application/json" })
	public Collection<Blog> list() {
		return new BlogDao().getAllBlogs();
	}

	@GET
	@Path("create")
	@Produces({ "application/json" })
	public String create(@BeanParam Blog blog) {
		new BlogDao().updateBlog(blog);
		return "{}";
	}

	@GET
	@Path("findById")
	@Produces({ "application/json" })
	public Blog findById(@QueryParam("id") String id) {
		return new BlogDao().findBlogById(id);
	}

	@GET
	@Path("update")
	@Produces({ "application/json" })
	public String update(@BeanParam Blog blog) {
		new BlogDao().updateBlog(blog);
		return "{}";
	}
}

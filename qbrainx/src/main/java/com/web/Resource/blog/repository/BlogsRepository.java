package com.web.resource.blog.repository;




import com.web.resource.blog.entity.blogs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogsRepository extends JpaRepository<blogs, Integer> {
}

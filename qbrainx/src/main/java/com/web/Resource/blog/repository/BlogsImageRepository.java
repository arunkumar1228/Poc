package com.web.resource.blog.repository;




import com.web.resource.blog.entity.BlogsImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogsImageRepository extends JpaRepository<BlogsImage,Integer> {


}

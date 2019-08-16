package com.example.elastic.repository;

import com.example.elastic.bean.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * 操作es,也可以自己写接口,遵守规则,就会自动实现,也可以接口上面写注解表达式类似mybatis写查询规则自己实现方法
 */
public interface BookRepository extends ElasticsearchRepository<Book,Integer> {
}

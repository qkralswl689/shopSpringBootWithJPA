package com.shop.repository;

import com.shop.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item,Long> , QuerydslPredicateExecutor<Item> {

    // item 찾기
    List<Item> findByItemNm(String itemNm);

    // item과 상세설명 Or 조건으로 조회
   List<Item> findByItemNmOrItemDetail(String itemNm, String ItemDetail);

    // LessThan 조건처리
    List<Item> findByPriceLessThan(Integer price);

    // 정렬
    List<Item> findByPriceLessThanOrderByPriceDesc(Integer price);

    //JPQL사용
    @Query("select i from Item i where i.itemDetail like %:itemDetail% order by i.price desc")
    List<Item> findByItemDetail(@Param("itemDetail") String itemDetail);

    // @query - nativeQuery 속성 예제
    @Query(value = "select * from item i where i.item_detail like %:itemDetail% order by i.price desc", nativeQuery = true)
    List<Item> findByItemDetailByNative(@Param("itemDetail") String itemDetail);


}

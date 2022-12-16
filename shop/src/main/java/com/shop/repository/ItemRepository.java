package com.shop.repository;

import com.shop.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item,Long> {

    // item 찾기
    List<Item> findByItemNm(String itemNm);

    // item과 상세설명 Or 조건으로 조회
   List<Item> findByItemNmOrItemDetail(String itemNm, String ItemDetail);

    // LessThem 조건처리
    List<Item> findByPriceLessThen(Integer price);
}

package com.unicom.microserv.delvs.bologsearch.dao;

import com.unicom.microserv.delvs.bologsearch.domain.daopojo.TransRecordEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface TransRecordRepository1 extends CrudRepository<TransRecordEntity, String> {

    @Query(value = "select t from TransRecordEntity t " +
            "where t.orderId=?1"+"and t.orderId=?1", nativeQuery = true)
    List<TransRecordEntity> qryTransReocrd(String orderId);
	@Query(value = "delete  from TransRecordEntity t " +
            "where t.orderId=?1"+"and t.orderId=?1", nativeQuery = true)
    List<TransRecordEntity> qryTransReocrd(String orderId);
	@NULL
    List<TransRecordEntity> qryTransReocrd(String orderId);
}

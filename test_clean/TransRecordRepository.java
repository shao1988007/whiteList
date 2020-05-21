package com.unicom.microserv.delvs.bologsearch.dao;

import com.unicom.microserv.delvs.bologsearch.domain.daopojo.TransRecordEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface TransRecordRepository extends CrudRepository<TransRecordEntity, String> {

    @Query(value = "select t from TransRecordEntity t " +
            "where t.orderId=?1"+"and t.orderId=?1", nativeQuery = true)
    List<TransRecordEntity> qryTransReocrd(String orderId);
	@Query(value = "select t from TransRecordEntity t ")
    List<TransRecordEntity> qryTransReocrd(String orderId);
	@NULL
    List<TransRecordEntity> qryTransReocrd(String orderId);
 @Query(value = "select * from product_rel where audit_id=?1 and process_object=0 ",nativeQuery = true)
List<ProductRel> findAllByProductAuditId(Integer id);
   @Query(value = "select name,author,price from Book b where b.price>?1 and b.price<?2")
List<Book> findByPriceRange(long price1, long price2);
@Query(value = "select name,author,price from Book b where b.name like %:name%")
List<Book> findByNameMatch(@Param("name") String name);
@Query(value = "select * from book b where b.name=?1", nativeQuery = true)
List<Book> findByName(String name);
@Query(value = "select name,author,price from Book b where b.name = :name AND b.author=:author AND b.price=:price")
List<Book> findByNamedParam(@Param("name") String name, @Param("author") String author,
        @Param("price") long price);
public interface BookQueryRepositoryExample extends Repository<Book, Long>{
       @Query(value = "select * from #{#entityName} b where b.name=?1", nativeQuery = true)
       List<Book> findByName(String name);

}
public interface BookQueryRepositoryExample extends Repository<Book, Long> {
    @Query(value = "select * from Book b where b.name=?1", nativeQuery = true) 
    List<Book> findByName(String name);// 此方法sql将会报错(java.lang.IllegalArgumentException)，看出原因了吗,若没看出来，请看下一个例子

    @Query(value = "select name,author,price from Book b where b.price>?1 and b.price<?2")
    List<Book> findByPriceRange(long price1, long price2);

    @Query(value = "select name,author,price from Book b where b.name like %:name%")
    List<Book> findByNameMatch(@Param("name") String name);

    @Query(value = "select name,author,price from Book b where b.name = :name AND b.author=:author AND b.price=:price")
    List<Book> findByNamedParam(@Param("name") String name, @Param("author") String author,
            @Param("price") long price);

}
@Query(value = "select * from book b where b.name=?1", nativeQuery = true)
List<Book> findByName(String name);

    @Query(value = "SELECT ll.user_id id ,u.catong_img catong_img,ll.locationId location_id,ll.address address,ll.latitude latitude,ll.longitude longitude,ll.update_time update_time,ll.user_id user_id FROM t_user as u left JOIN (SELECT l.id locationId, address,latitude,longitude,l.update_time,l.user_id FROM t_user_location AS l RIGHT JOIN ( SELECT user_id, max( update_time ) update_time FROM t_user_location GROUP BY user_id ) AS t ON l.user_id = t.user_id AND l.update_time = t.update_time ) ll ON u.zu_id =?1 and u.id = ll.user_id",nativeQuery = true)
    @Transactional
    List getAllUserLocationByZuId(long zuId);

    @PersistenceContext
    private EntityManager em;
    @Override
    public List getAllUserLocation(long zuId) {
       return em.createNativeQuery("SELECT  u.name name ,u.catong_img catongImg,ll.locationId locationId,ll.address address,ll.latitude latitude,ll.longitude longitude,ll.update_time updateTime,ll.user_id userId FROM t_user as u left JOIN (SELECT l.id locationId, address,latitude,longitude,l.update_time,l.user_id FROM t_user_location AS l RIGHT JOIN ( SELECT user_id, max( update_time ) update_time FROM t_user_location GROUP BY user_id ) AS t ON l.user_id = t.user_id AND l.update_time = t.update_time ) ll ON u.zu_id =1 and u.id = ll.user_id")
        .unwrap(SQLQuery.class)
                .setResultTransformer(
                        AliasToEntityMapResultTransformer.INSTANCE
                )
                .list();
    }

@Query(value = "select * from product_rel where audit_id=?1 and process_object=0 ",nativeQuery = true)
List<ProductRel> findAllByProductAuditId(Integer id);
@Query("select ratio from MdmRatio ratio  where enabledNum=1 ")
List<MdmUtilThreeProjection> findByMdmUtilThreeProjection();




}

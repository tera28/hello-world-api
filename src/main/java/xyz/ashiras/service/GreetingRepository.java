package xyz.ashiras.service;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import xyz.ashiras.model.Books;

/**
 *
 * @author Fumio SAGAWA
 */
@Repository // Springにコンポーネントとして管理されるDBにアクセスするためのクラス
public interface GreetingRepository extends JpaRepository<Books, Long> {
  @Query("select b from Books b")
  List<Books> findAll();

  @Query("select b from Books b where b.name like %:name%")
  List<Books> searchByName(final String name);
}

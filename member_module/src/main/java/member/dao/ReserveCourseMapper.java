package member.dao;

import api.pojo.ReserveCourse;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ReserveCourseMapper {


    int addReserveCourse(ReserveCourse reserveCourse);

    int updateReserveCourse(ReserveCourse reserveCourse);

    ReserveCourse findReserveCourseById(Integer id);

    List<ReserveCourse> findReserveCourseByMemberId(@Param("lastId") Integer lastId,@Param("course") ReserveCourse course,@Param("pageSize") Integer pageSize);

    Integer getMinId(Integer memberId);

    int findReserveNumberByBrandIdAndCourseId(@Param("brandId") Integer brandId, @Param("courseId") Integer courseId);
}

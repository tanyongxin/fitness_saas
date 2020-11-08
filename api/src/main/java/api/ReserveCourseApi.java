package api;

import api.pojo.Course;
import api.pojo.PageReq;
import api.pojo.ReserveCourse;

import java.util.List;


public interface ReserveCourseApi {

    ReserveCourse.ReserveRes addReserveCourse(ReserveCourse reserveCourse);

    boolean updateReserveCourse(ReserveCourse reserveCourse);

    ReserveCourse findReserveCourseById(Integer id);

    List<ReserveCourse> findReserveCourseByMemberId(PageReq<ReserveCourse> pageReq);

    List<Course>  findReserveNumberByCourseId(List<Course> list);


}

package api;

import api.pojo.PageReq;
import api.pojo.ReserveCourse;

import java.util.List;


public interface ReserveCourseApi {

    boolean addReserveCourse(ReserveCourse reserveCourse);

    boolean updateReserveCourse(ReserveCourse reserveCourse);

    ReserveCourse findReserveCourseById(Integer id);

    List<ReserveCourse> findReserveCourseByMemberId(PageReq<ReserveCourse> pageReq);


}

package com.cinemaappapi.repository;

import com.cinemaappapi.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to count how many tickets a user bought
    Integer countAllByUserId(Long userId);

    //Write a derived query to list all tickets by specific email
    List<Ticket> findAllByUserEmail(String email);

    //Write a derived query to count how many tickets are sold for a specific movie
    Integer countAllByMovieCinemaMovieName(String movieName);

    //Write a derived query to list all tickets between a range of dates
    List<Ticket> findAllByDateTimeBetween(LocalDateTime date1, LocalDateTime date2);

    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query that returns all tickets are bought from a specific user
    @Query("select t from Ticket t where t.user.id = ?1")
    List<Ticket> fetchAllByUser(Long userId);

    //Write a JPQL query that returns all tickets between a range of dates
    @Query("select t from Ticket t where t.dateTime > ?1 and t.dateTime < ?2")
    List<Ticket> fetchAllDatesBetween(LocalDateTime date1, LocalDateTime date2);

    // ------------------- Native QUERIES ------------------- //

    //Write a native query to count the number of tickets a user bought
    @Query(value = "select count(*) from ticket where user_account_id = ?1", nativeQuery = true)
    Integer retrieveCountAllByUser(Long userId);

    //Write a native query to count the number of tickets a user bought in a specific range of dates
    @Query(value = "select count(*) from ticket where user_account_id = ?1 and date_time between ?2 and ?3", nativeQuery = true)
    Integer retrieveAllByDatesRange(Long userId, LocalDateTime start, LocalDateTime end);

    //Write a native query to distinct all tickets by movie name
    @Query(value = "select distinct m.name from ticket t join movie_cinema mc on mc_id = t.movie_cinema_id join movie m on mc.movie_id = m.id", nativeQuery = true)
    List<String> retrieveAllByMovieName();

    //Write a native query to find all tickets by user email
    @Query(value = "select * from ticket t join user_account ua on ua.id = t.user_account_id where ua.email = ?1", nativeQuery = true)
    List<Ticket> retrieveAllByUserEmail(String email);

    //Write a native query that returns all tickets
    @Query(value = "select * from ticket", nativeQuery = true)
    List<Ticket> retrieveAll();

    //Write a native query to list all tickets where a specific value should be containable in the username or name or movie name
    @Query(value = "select * from ticket t join user_account ua on t.user_account_id = ua.id join account_details ad on ad.id = ua.account_details_id join movie_cinema mc on t.movie_cinema_id = mc.id join movie m on mc.movie_id = m.id where ua.username ilike concat('%',?1,'%') or a.name ilike concat('%',?1,'%') or m.name ilike concat('%',?1,'%')", nativeQuery = true)
    List<Ticket> retrieveAllBySearchCriteria(String searchCriteria);

}

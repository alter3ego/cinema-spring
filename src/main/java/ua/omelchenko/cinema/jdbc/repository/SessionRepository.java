package ua.omelchenko.cinema.jdbc.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ua.omelchenko.cinema.entity.Session;
import ua.omelchenko.cinema.entity.User;

import java.math.BigDecimal;
import java.util.Optional;

@Repository
public interface SessionRepository extends JpaRepository<Session, Long> {
    Page<Session> findAllByNumberOfTicketsIsLessThan(int numberOfTickets, Pageable pageable);

    Optional<Session> findById(long sessionId);

    @Modifying
    @Query(value = "UPDATE sessions SET number_of_tickets = number_of_tickets + ?  WHERE id = ?", nativeQuery = true)
    int updateNumberOfTickets(int places, Session session);

}

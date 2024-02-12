package com.khit.library.repository;

import com.khit.library.entity.RentalReturn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface RentalReturnRepository extends JpaRepository<RentalReturn, Long> {
    //Optional<RentalReturn> findByRentalId(Long rentalId);
    RentalReturn findByRentalId(Long rentalId);

    List<RentalReturn> findByMemberMid(String mid);

    @Query("select count(*) from RentalReturn where member.memberId = :memberId and returnDate is null")
    public int rentalCount(Long memberId);

}
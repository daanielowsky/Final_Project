package com.github.daanielowsky.FinalProject.repositories;

import com.github.daanielowsky.FinalProject.entity.Category;
import com.github.daanielowsky.FinalProject.entity.Offer;
import com.github.daanielowsky.FinalProject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface OfferRepository extends JpaRepository<Offer, Long> {

    @Query("select o from Offer o where title like %?1%")
    List<Offer> getAllByTitleLike(String title);
    List<Offer> getAllByUser(User user);
    List<Offer> getAllByCategory(Category category);
    @Query("select o from Offer o order by created desc")
    List<Offer> getFirstTen();

    Optional<Offer> getOfferById(Long id);
}

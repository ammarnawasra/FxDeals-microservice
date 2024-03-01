package com.progressSoft.fxDealsMicroservice.repo;


import com.progressSoft.fxDealsMicroservice.model.FxDeal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FxDealRepository extends JpaRepository<FxDeal, Long> {

}

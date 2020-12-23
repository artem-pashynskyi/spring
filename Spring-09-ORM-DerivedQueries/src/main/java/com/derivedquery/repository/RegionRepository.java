package com.derivedquery.repository;

import com.derivedquery.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegionRepository extends JpaRepository<Region, Integer> {

    //Display all regions in Canada
    List<Region> findByCountry(String country);

    //Display all regions in Canada without duplicates
    List<Region> findDistinctByCountry(String country);

    //Display all regions with Country name includes 'United'
    List<Region> findByCountryContaining(String country);

    //Display all regions with Country name includes 'United' In Order
    List<Region> findByCountryContainingOrderByCountry(String country);

    //Display top 1 region in Canada
    List<Region> findTop1ByCountry(String country);

}

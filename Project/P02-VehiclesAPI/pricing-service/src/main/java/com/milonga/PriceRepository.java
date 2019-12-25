package com.milonga;

import com.milonga.model.Price;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
/*
@RepositoryRestResources
is an annotation that tells this is the class in charge to save Prices
so, you save or get information through this class
it works as a server and a rest api
where /price ??? url ??? where is it
path = yes W'here is it

 */
@RepositoryRestResource(collectionResourceRel = "prices", path = "prices")
public interface PriceRepository extends PagingAndSortingRepository<Price, Long> {

    public Price findByVehicleId(String vehicleId);
}

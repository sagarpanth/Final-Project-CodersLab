package pl.coderslab.service;

import java.util.List;

import org.joda.time.LocalDate;

import pl.coderslab.entity.Advert;

public interface AdvertService {
	
	List<Advert> findAll();

	List<Advert> findAllByOwnerUsername(String username);

	List<Advert> findAllByHostUsername(String username);
	
	List<Advert> checkAvailability(LocalDate start, LocalDate end);
	
	List<Advert> showAllAvailable();
	
	List<Advert> showAllPromoted();
}

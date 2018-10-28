package com.sstrzelka.jee.jaxrs.config;

import com.sstrzelka.jee.jaxrs.repositories.CarRepository;
import com.sstrzelka.jee.jaxrs.repositories.InMemoryRepository;
import com.sstrzelka.jee.jaxrs.services.CarService;
import org.glassfish.jersey.internal.inject.AbstractBinder;

public class ApplicationBinder extends AbstractBinder {

    @Override
    protected void configure() {
        bind(CarService.class).to(CarService.class);
        bind(CarRepository.class).to(CarRepository.class);
        bind(InMemoryRepository.class).to(InMemoryRepository.class);
//        bind(CarRepository.class).to(CarRepository.class).in(Singleton.class);
//        bind(InMemoryRepository.class).to(InMemoryRepository.class).in(Singleton.class);
    }
}
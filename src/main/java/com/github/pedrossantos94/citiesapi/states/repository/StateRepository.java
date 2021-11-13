package com.github.pedrossantos94.citiesapi.states.repository;

import com.github.pedrossantos94.citiesapi.states.State;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository extends JpaRepository<State, Long> {
}
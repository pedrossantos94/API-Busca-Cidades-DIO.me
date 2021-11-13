package com.github.pedrossantos94.citiesapi.countries;

import com.github.pedrossantos94.citiesapi.countries.Country;
import com.github.pedrossantos94.citiesapi.countries.repository.CountryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;


@RestController
@RequestMapping("/countries")
public class CountryResource {

    private CountryRepository repository;

    public CountryResource(CountryRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public Page countries(Pageable page){
        return repository.findAll(page);
    }

    @GetMapping("/{Id}")
    public ResponseEntity<Country> getOne(@PathVariable Long Id) {
        Optional<Country> optional = repository.findById(Id);

        if (optional.isPresent())
            return ResponseEntity.ok().body(optional.get());
        else
            return ResponseEntity.notFound().build();
    }
}

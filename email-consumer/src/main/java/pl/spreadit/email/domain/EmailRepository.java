package pl.spreadit.email.domain;

import org.springframework.data.repository.Repository;

import java.util.List;

interface EmailRepository extends Repository<Email, Long> {

    Email save(Email emailToAdd);
    List<Email> findAll();

}
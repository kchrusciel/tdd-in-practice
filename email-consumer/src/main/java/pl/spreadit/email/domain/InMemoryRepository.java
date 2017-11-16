package pl.spreadit.email.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class InMemoryRepository implements EmailRepository {

    private Map<Integer, Email> emails = new HashMap<>();

    private int counter;

    @Override
    public Email save(Email emailToAdd) {
        emailToAdd.setId(++counter);
        emails.put(counter, emailToAdd);
        return emails.get(counter);
    }

    @Override
    public List<Email> findAll() {
        return new ArrayList<>(emails.values());
    }
}

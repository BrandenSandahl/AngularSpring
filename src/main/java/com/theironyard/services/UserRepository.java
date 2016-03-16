package com.theironyard.services;

import com.theironyard.entities.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by branden on 3/16/16 at 10:17.
 */
public interface UserRepository extends CrudRepository<User, Integer> {
}

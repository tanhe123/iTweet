package net.xiayule.itweet.db.repository;

import net.xiayule.itweet.db.entity.GreetingEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by tan on 15-11-18.
 */
public interface GreetingRepository extends PagingAndSortingRepository<GreetingEntity, Long> {

    GreetingEntity findByName(String name);
}

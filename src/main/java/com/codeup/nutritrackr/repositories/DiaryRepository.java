package com.codeup.nutritrackr.repositories;

import com.codeup.nutritrackr.models.Diary;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiaryRepository extends CrudRepository<Diary, Long> {

}

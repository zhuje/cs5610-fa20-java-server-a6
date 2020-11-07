package com.example.cs5610f20serverjavajannunzi.repositories;

import com.example.cs5610f20serverjavajannunzi.models.Widget;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


// In computer software, a data access object (DAO) is a pattern that
// provides an abstract interface to some type of database or other
// persistence mechanism.
// CrudRepository interface allow implementing generic DAOs
// Just need to configure 'class' and 'primary key'  :: 'Widget' 'Integer'

// This is where were can store custom functions. Instead of using
// the library function provided by the 'CrudRepository' we can
// define custom functions for querying the SQL database.

public interface WidgetRepository
    extends CrudRepository<Widget, Integer> {


    // @Query -- denotes a JPQL query syntax -- once we reach the
    // SQL database run this query to retrieve our data
    // ':topicId'
    @Query("select widget from Widget widget where topicId=:topicId")
    // Below is purely SQL -- nativeQuery
    // @Query(value = "select * from widgets where topic_id=:topicId", nativeQuery = true)
    public List<Widget> findWidgetsForTopic(
            @Param("topicId") String topicId);
}

package org.example.repository;


import org.example.model.Post;

import java.util.*;

public interface PostRepository {


    List<Post> all();

    Optional<Post> getById(long id);

    Optional<Post> save(Post post);

    void removeById(long id);

    List<Post> show();
}


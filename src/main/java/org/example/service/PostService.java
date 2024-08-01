package org.example.service;


import org.example.model.Post;
import org.example.repository.PostRepository;
import org.example.exception.NotFoundException;

import java.util.List;
import java.util.Optional;

public class PostService {
    private final PostRepository repository;

    public PostService(PostRepository repository) {
        this.repository = repository;
    }

    public List<Post> all() {
        return repository.all();
    }

    public Post getById(long id) {
        Optional<Post> post = repository.getById(id);
        if (post.isPresent()) {
            return post.get();
        } else {
            throw new NotFoundException();
        }
    }

    public Post save(Post post) {
        return repository.save(post);
    }

    public void removeById(long id) {
        repository.removeById(id);
    }
}


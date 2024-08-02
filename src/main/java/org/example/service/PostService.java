package org.example.service;


import org.example.model.Post;
import org.example.repository.PostRepository;
import org.example.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    private final PostRepository repository;

    public PostService(PostRepository repository) {
        this.repository = repository;
    }

    public List<Post> all() {
        return repository.all();
    }

    public Post getById(long id) {
        Optional<Post> postOption = repository.getById(id);
        if (postOption.isPresent()) {
            return postOption.get();
        } else {
            throw new NotFoundException();
        }
    }

    public Post save(Post post) {
        Optional<Post> postOption = repository.save(post);
        if (postOption.isPresent()) {
            return postOption.get();
        } else {
            throw new NotFoundException();
        }
    }

    public void removeById(long id) {
        repository.removeById(id);
    }

    public List<Post> show() {
        return repository.show();
    }
}


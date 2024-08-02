package org.example.repository;


import org.example.model.Post;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class PostRepositoryImpl implements PostRepository {
    public static long postCounter = 0;
    private List<Post> posts = Collections.synchronizedList(new ArrayList<>());

    public List<Post> all() {
        List<Post> postsPresented = posts.stream().filter(s -> !s.isRemoved()).collect(Collectors.toList());
        return postsPresented;
    }

    @Override
    public List<Post> show() {
        return posts;
    }

    public Optional<Post> getById(long id) {
        for (Post p : posts) {
            if (p.getId() == id && !p.isRemoved()) {
                return Optional.of(p);
            }
        }
        return Optional.empty();
    }

    public Optional<Post> save(Post post) {
        if (post.getId() == 0) {
            postCounter++;
            post.setId(postCounter);
            posts.add(post);
            return Optional.of(post);

        } else {
            for (Post e : posts) {
                if (e.getId() == post.getId() && !e.isRemoved()) {
                    e.setContent(post.getContent());
                    return Optional.of(e);
                }
            }
        }
        return Optional.empty();
    }

    public void removeById(long id) {
        posts.stream().filter(s -> s.getId() == id).forEach(s -> s.setRemoved(true));

    }
}


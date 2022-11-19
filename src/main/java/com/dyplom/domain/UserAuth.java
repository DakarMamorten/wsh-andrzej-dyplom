package com.dyplom.domain;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.Objects;

public class UserAuth extends org.springframework.security.core.userdetails.User {

    private final Long id;
    private String name;
    private int failedAttempt;

    public UserAuth(final String username,
                    final String password,
                    final Collection<? extends GrantedAuthority> authorities,
                    final Long id) {
        super(username, password, authorities);
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFailedAttempt() {
        return failedAttempt;
    }

    public void setFailedAttempt(int failedAttempt) {
        this.failedAttempt = failedAttempt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        UserAuth userAuth = (UserAuth) o;
        return failedAttempt == userAuth.failedAttempt && id.equals(userAuth.id) && name.equals(userAuth.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, name, failedAttempt);
    }
}

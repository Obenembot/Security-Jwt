package com.sam.models;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String password;
    @Column(unique = true, nullable = false)
    private String username;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Role> authorities = new ArrayList<>();
    @Column(name = "last_login_date")
    private LocalDateTime lastLoginDate;

    @Column(name = "enabled")
    private Boolean enabled;

    @Column(name = "email")
    private String email;

    @Column(name = "lock_time")
    private LocalDateTime lockTime;

    @Column(name = "failed_attempt")
    private Short failedAttempt;

    @Column(name = "user_locked")
    private Boolean userLocked;

    public User() {
    }

    public User(Long id, String password, String username) {
        this.id = id;
        this.password = password;
        this.username = username;
    }

    public User(String password, String username) {
        this.password = password;
        this.username = username;
    }

    public User(String password, String username, List<Role> authorities) {
        this.password = password;
        this.username = username;
        this.authorities = authorities;
    }

    public User(String password, String username, LocalDateTime lastLoginDate) {
        this.password = password;
        this.username = username;
        this.lastLoginDate = lastLoginDate;
    }

    public LocalDateTime getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(LocalDateTime lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Role> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<Role> authorities) {
        this.authorities = authorities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(username, user.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                ", authorities=" + authorities +
                ", lastLoginDate=" + lastLoginDate +
                ", email='" + email + '\'' +
                ", lockTime=" + lockTime +
                ", failedAttempt=" + failedAttempt +
                ", userLocked=" + userLocked +
                ", enabled=" + enabled +
                '}';
    }

    public Boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getLockTime() {
        return lockTime;
    }

    public void setLockTime(LocalDateTime lockTime) {
        this.lockTime = lockTime;
    }

    public Short getFailedAttempt() {
        return failedAttempt;
    }

    public void setFailedAttempt(Short failedAttempt) {
        this.failedAttempt = failedAttempt;
    }

    public Boolean getUserLocked() {
        return userLocked;
    }

    public void setUserLocked(Boolean userLocked) {
        this.userLocked = userLocked;
    }
}

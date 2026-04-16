package com.smarttask.taskplatform.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.smarttask.taskplatform.enums.Role;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;


@Entity
@Table(name = "users")
public class User {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private UUID id;

        private String name;

        @Column(unique = true,nullable = false)
        private String email;

        @JsonIgnore
        @Column(nullable = false)
        private String password;

        @Enumerated(EnumType.STRING)
        @Column(nullable = false)

        private Role role;

        @JsonIgnore
        @OneToMany(mappedBy = "assignedTo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
        private List<Task> tasks;

        @JsonIgnore
        @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
        private List<Comment> comments;

        public User() {
        }

        public User(UUID id, String name, String email, String password, Role role, List<Task> tasks, List<Comment> comments) {
                this.id = id;
                this.name = name;
                this.email = email;
                this.password = password;
                this.role = role;
                this.tasks = tasks;
                this.comments = comments;
        }

        public UUID getId() {
                return id;
        }

        public void setId(UUID id) {
                this.id = id;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        public String getPassword() {
                return password;
        }

        public void setPassword(String password) {
                this.password = password;
        }

        public Role getRole() {
                return role;
        }

        public void setRole(Role role) {
                this.role = role;
        }

        public List<Task> getTasks() {
                return tasks;
        }

        public void setTasks(List<Task> tasks) {
                this.tasks = tasks;
        }

        public List<Comment> getComments() {
                return comments;
        }

        public void setComments(List<Comment> comments) {
                this.comments = comments;
        }
}
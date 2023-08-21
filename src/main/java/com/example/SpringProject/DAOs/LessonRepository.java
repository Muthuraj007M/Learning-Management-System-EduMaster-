package com.example.SpringProject.DAOs;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SpringProject.Entity.Lesson;

public interface LessonRepository extends JpaRepository<Lesson, Integer> {

}

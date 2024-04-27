package com.minaoui.repositorie;

import com.minaoui.entity.CourseMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CourseMaterialRepository extends JpaRepository<CourseMaterial,Long> {
}

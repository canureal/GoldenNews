package org.canureal.goldennews.repositorys;

import org.canureal.goldennews.models.NormalNewsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NormalNewsRepository extends JpaRepository<NormalNewsModel, Long> {
}

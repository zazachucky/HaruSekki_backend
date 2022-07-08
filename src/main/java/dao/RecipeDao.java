package dao;

import dto.RecipeDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RecipeDao extends JpaRepository<RecipeDto, Long> {
    List<RecipeDto> findByTitle(String title);
    List<RecipeDto> findByCategory(String category);
}

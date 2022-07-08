package service;

import dao.RecipeDao;
import dto.RecipeDto;

import java.util.List;

public interface RecipeService {
    List<RecipeDto> findByTitle(String title) throws Exception;
    List<RecipeDto> findByCategory(String category) throws Exception;
}
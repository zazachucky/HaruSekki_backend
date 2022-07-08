package service;

import dao.RecipeDao;
import dto.RecipeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RecipeServiceImplement implements RecipeService{
    @Autowired
    private RecipeDao recipeDao;

    @Override
    public List<RecipeDto> findByTitle(String title) throws Exception{
        List<RecipeDto> recipeDtoList = new ArrayList<>() {
        };
        if(!title.equals("")){
            List<RecipeDto> result = recipeDao.findByTitle(title);
            if(result.isEmpty()){
                recipeDtoList = result;
                return recipeDtoList;
            }
        }
        return recipeDtoList;
    }

    @Override
    public List<RecipeDto> findByCategory(String category) throws Exception{
        List<RecipeDto> recipeDtoList = new ArrayList<>() {
        };
        if(!category.equals("")){
            List<RecipeDto> result = recipeDao.findByCategory(category);
            if(result.isEmpty()){
                recipeDtoList = result;
                return recipeDtoList;
            }
        }
        return recipeDtoList;
    }
}

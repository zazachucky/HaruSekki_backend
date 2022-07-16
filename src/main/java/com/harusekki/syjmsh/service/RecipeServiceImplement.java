package com.harusekki.syjmsh.service;

import com.harusekki.syjmsh.dao.RecipeDao;
import com.harusekki.syjmsh.dto.RecipeDto;
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
        List<RecipeDto> recipeDtoList = new ArrayList<>();

        recipeDtoList.addAll(recipeDao.findAllByTitleContaining(title));

//        if(!title.equals("")){
//            List<RecipeDto> result = new ArrayList<>();
//            result.addAll(recipeDao.findByTitle(title));
//            if(result.isEmpty()){
//                recipeDtoList.addAll(result);
//                return recipeDtoList;
//            }
//        }
        return recipeDtoList;
    }

    @Override
    public List<RecipeDto> findByCategory(String category) throws Exception{
        List<RecipeDto> recipeDtoList = new ArrayList<>();

        recipeDtoList.addAll(recipeDao.findAllByCategoryContaining(category));

//        if(!category.equals("")){
//            List<RecipeDto> result = new ArrayList<>();
//            result.addAll(recipeDao.findAllByCategory(category));
//            if(result.isEmpty()){
//                recipeDtoList.addAll(result);
//                return recipeDtoList;
//            }
//        }
        return recipeDtoList;
    }

    public List<RecipeDto> findAllById() throws Exception{
        List<RecipeDto> recipeDtoList = new ArrayList<>();
        recipeDtoList.addAll(recipeDao.findAllByOrderByIdDesc());

        return recipeDtoList;
    }
}

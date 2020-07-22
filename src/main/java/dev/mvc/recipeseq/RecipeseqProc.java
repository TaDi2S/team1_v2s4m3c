package dev.mvc.recipeseq;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component("dev.mvc.recipeseq.RecipeseqProc")
public class RecipeseqProc implements RecipeseqProcInter{
  @Autowired  // DI, Spring framework�� �ڵ� ������ DAO�� �ڵ� �Ҵ��.
  private RecipeseqDAOInter recipeseqDAO;
  
  
  @Override
  public int create(RecipeseqVO recipeseqVO) {
    int cnt = this.recipeseqDAO.create(recipeseqVO);
    return cnt;
  }


  @Override
  public List<RecipeseqVO> list(int recipeno) {
    List<RecipeseqVO> list = this.recipeseqDAO.list(recipeno);
    return list;
  }


}

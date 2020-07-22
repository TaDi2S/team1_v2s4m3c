package dev.mvc.recipe;

import java.util.HashMap;
import java.util.List;

public interface RecipeProcInter {
  
  public int create(RecipeVO recipeVO);
  public RecipeVO read(int recipeno);
 
  /**
   * ������ ��� ���ڿ� ����, Box ����
   * @param listFile ��� ���ϸ� 
   * @param recipecateno ī�װ�����ȣ
   * @param search_count �˻� ����
   * @param nowPage ���� ������, nowPage�� 1���� ����
   * @param word �˻���
   * @return
   */
  public String pagingBox(String listFile, int recipecateno, int search_count, int nowPage, String word);
  
  public List<Member_Recipe_join> list_by_recipecateno_search_paging(HashMap<String, Object> map);
  
  /**
   * ī�װ����� �˻� ���ڵ� ����
   * @param hashMap
   * @return
   */
  public int search_count(HashMap<String, Object> hashMap);
  
  public int increaseRatingCnt(int recipeno);
  
  public int addRating(RecipeVO recipeVO);
  
  public int ratingUpdate(RecipeVO recipeVO);
  
  /**
   * ��ȸ��
   * @param recipeno
   * @return
   */
  public int hits(int recipeno);
  
  /**
   * ���� �� ����Ʈ
   * @param map
   * @return
   */
  public List<Member_Recipe_join> list_by_rating_search_paging(HashMap<String, Object> map);
}
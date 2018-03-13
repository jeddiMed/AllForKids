/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import entities.Categories;
import java.util.List;

/**
 *
 * @author mohamed
 */
public interface IServices {
    public void add(Categories categories);
    public void remove(Categories categories);
    public void update(Categories categories, int id);
    public List<Categories> getAll();
}

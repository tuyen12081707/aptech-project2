/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aptech.project2.model;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Admin
 */
public abstract class AbstractDAO <T>{
    private Class<T> entity = null;
    
    public AbstractDAO(Class<T> clazz){
        entity = clazz;
    }
    public abstract EntityManager getEntityManager();
    
}

package Dao;

import java.util.ArrayList;

public interface DAOInteFace<T> {
public int Insert(T t);
public int Update(T t);
public  int Delete(T t);
public ArrayList<T>SelectAll();
public T SelectById(T t);
}

package DAO;

import java.util.*;

import Model.Guitar;

public interface GuitarDAO {
	// 增加操作
	public void insert(Guitar guitar) throws Exception;

	// 删除操作
	public void delete(String serialNumber) throws Exception;

	// 模糊查询
	public List queryByLike(String cond) throws Exception;

	// 查询全部
	public List queryAll() throws Exception;

}

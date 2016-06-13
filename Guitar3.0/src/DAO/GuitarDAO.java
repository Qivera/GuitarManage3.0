package DAO;

import java.util.*;

import Model.Guitar;

public interface GuitarDAO {
	// ���Ӳ���
	public void insert(Guitar guitar) throws Exception;

	// ɾ������
	public void delete(String serialNumber) throws Exception;

	// ģ����ѯ
	public List queryByLike(String cond) throws Exception;

	// ��ѯȫ��
	public List queryAll() throws Exception;

}

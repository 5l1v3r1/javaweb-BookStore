package dao;

import java.util.List;

import domain.Order;
import org.apache.commons.dbutils.QueryRunner;

public interface OrderDao {
	//order��orderitem���ݱ�ͬʱ���Ӽ�¼
	void add(Order order);

	void update(Order order);
	//���ض���order������Ҫ�Բ�������order����ʵ�����и�ֵ
	Order find(String id);

	void fill(Order order, QueryRunner runner);//���order�е�orderitem����

	List<Order> getAll(boolean state);//��̨�õ�����״̬Ϊstate�Ķ���

	List<Order> getAll(boolean state, String userid);//ǰ̨�õ�ָ���û�����״̬Ϊstate�Ķ�����,viewΪtrue

	List<Order> getAllOrder(String userid);//ǰ̨�õ�ָ���û������ж�����viewΪtrue

	void hidden(String orderid);//��ָ������view��Ϊfalse����ǰ̨���ɼ�

	void delete(String orderid);//��ָ�����������ݿ���ɾ��
}
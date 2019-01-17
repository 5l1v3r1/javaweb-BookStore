package service.impl;

import java.util.List;

import domain.Book;
import domain.Category;
import domain.Order;

public interface BusinessService {

	/**��ӷ���**/
	void addCategory(Category category);

	/**���ҷ���**/
	Category findCategory(String id);

	/**�õ����з���**/
	List<Category> getAllCategory();
	//ǰ̨������ɾ��order
	void hiddenOrder(String orderid);
	//��̨�������޸ķ���
	void updateCategory(Category category);

	//��̨������ɾ����Ӧorderid����
	void deleteOrder(String orderid);

	//��̨�������޸�ͼ��
	void updatebook(Book book);
}
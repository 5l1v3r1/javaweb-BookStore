package web.client;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.User;
import service.impl.BusinessServiceImpl;

public class LoginServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String wh;//ȥ�ĸ�ҳ��
        BusinessServiceImpl service = new BusinessServiceImpl();
        User user = service.userLogin(username, password);
        if (user == null) {
            String message = String.format(
                    "�Բ����û������������󣡣������µ�¼��1���Ϊ���Զ�������¼ҳ�棡��<meta http-equiv='refresh' content='1;url=%s'",
                    request.getContextPath() + "/welcome.jsp");
            request.setAttribute("message", message);
            request.getRequestDispatcher("/message.jsp").forward(request, response);
            return;
        }
        //��¼�ɹ��󣬾ͽ��û��洢��session��
        request.getSession().setAttribute("user", user);
        if (user.isRoot()) {
            wh = "/manager.jsp";
        } else {
            wh = "/client.jsp";
        }
        String message = String.format(
                "��ϲ��%s,��½�ɹ�����ҳ����1�����ת����<meta http-equiv='refresh' content='1;url=%s'",
                user.getUsername(),
                request.getContextPath() + wh);
        request.setAttribute("message", message);
        request.getRequestDispatcher("/message.jsp").forward(request, response);

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}

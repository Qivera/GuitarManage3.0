package Servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.dataAccess;
import Model.Builder;
import Model.Guitar;
import Model.GuitarSpec;
import Model.Type;
import Model.Wood;

@WebServlet("/GuitarServlet")
public class GuitarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GuitarServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		{
			this.doPost(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		request.setCharacterEncoding("GB2312");
		String path = "index.jsp";
		// 接收要操作的参数值
		String status = request.getParameter("status");

		if (status != null) {
			if("selectall".equals(status))
			{
				try
				{
					request.setAttribute("all",dataAccess.getGuitarDAOInstance().queryAll()) ;
				}
				catch (Exception e)
				{
				}
				path = "index.jsp" ;
			}
			// 插入操作
			if ("insert".equals(status)) {
				Map properties = new HashMap();
				properties.put(
						"builder",
						Builder.valueOf(request.getParameter("builder")
								.toUpperCase().replaceAll(" ", "_")));
				properties.put(
						"backWood",
						Wood.valueOf(request.getParameter("backWood")
								.toUpperCase().replaceAll(" ", "_")));
				properties.put(
						"topWood",
						Wood.valueOf(request.getParameter("topWood")
								.toUpperCase().replaceAll(" ", "_")));
				properties.put("model", request.getParameter("model")
						.toUpperCase().replaceAll(" ", "_"));
				properties.put(
						"type",
						Type.valueOf(request.getParameter("type").toUpperCase()
								.replaceAll(" ", "_")));
				GuitarSpec spec = new GuitarSpec(properties);

				String serialNumber = request.getParameter("serialNumber");
				double price = Double
						.parseDouble(request.getParameter("price"));
				Guitar guitar = new Guitar();
				guitar.setSerialNumber(serialNumber);
				guitar.setPrice(price);
				;
				guitar.setSpec(spec);
				;

				boolean flag = false;
				try {
					dataAccess.getGuitarDAOInstance().insert(guitar);
					flag = true;
				} catch (Exception e) {
				}
				request.setAttribute("flag", new Boolean(flag));
				path = "insert_do.jsp";
			}
			// 模糊查询
			if ("selectbylike".equals(status)) {
				String keyword = request.getParameter("keyword").toUpperCase();
				try {
					request.setAttribute("all", dataAccess
							.getGuitarDAOInstance().queryByLike(keyword));
				} catch (Exception e) {
				}
				path = "index.jsp";
			}
			// 删除操作
			if ("delete".equals(status)) {
				String serialNumber = "";
				try {
					serialNumber = request.getParameter("serialNumber");
				} catch (Exception e) {
				}
				boolean flag = false;
				try {
					dataAccess.getGuitarDAOInstance().delete(serialNumber);
					flag = true;
				} catch (Exception e) {
				}
				request.setAttribute("flag", new Boolean(flag));
				path = "delete_do.jsp";
			}
		} else {

		}
		request.getRequestDispatcher(path).forward(request, response);
	}

}
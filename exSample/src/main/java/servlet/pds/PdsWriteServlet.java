package servlet.pds;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload2.core.DiskFileItemFactory;
import org.apache.commons.fileupload2.core.FileItem;
import org.apache.commons.fileupload2.javax.JavaxServletDiskFileUpload;

import model.pds.PdsDAO;
import model.pds.PdsDTO;

/**
 * Servlet implementation class PdsWriteServlet
 */
@WebServlet("/Pds/pds_write.do")
public class PdsWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PdsWriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		RequestDispatcher rd = request.getRequestDispatcher("pds_write.jsp");
		rd.forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		ServletContext context = getServletContext();
		String path = context.getRealPath("/Pds/upload/");//실제 저장 경로
		
		String encType = "UTF-8";
		int sizeLimit = 2*1024*1024;// 파일의 최대 저장용량(2M)
		
		DiskFileItemFactory factory = 
				new DiskFileItemFactory.Builder().setBufferSize(sizeLimit)
								.setCharset(encType).setPath(path).get();
		JavaxServletDiskFileUpload upload = new JavaxServletDiskFileUpload(factory);
		upload.setFileSizeMax(sizeLimit);
		
		
		List items = upload.parseRequest(request);
		Iterator iter = items.iterator();
		
		String name = ((FileItem)iter.next()).getString();
		String email = ((FileItem)iter.next()).getString();
		String subject = ((FileItem)iter.next()).getString();
		String contents = ((FileItem)iter.next()).getString();
		FileItem file = (FileItem)iter.next(); 
		String filename = file.getName();
		String pass = ((FileItem)iter.next()).getString();
		//출력 테스트
		//System.out.println("name : " + name);
		//System.out.println("subject : " + subject);
		//System.out.println("contents : " + contents);
		//System.out.println("filename : " + filename);
		//System.out.println("pass : " + pass);
		//파일저장==> 서버에 저장
		if(filename != null && !filename.equals("")) {
			Path path2 = Paths.get(path+filename);
			file.write(path2);
		}
		
		PdsDAO dao = PdsDAO.getInstance();
		PdsDTO dto = new PdsDTO();
		dto.setName(name);
		dto.setEmail(email);//생략가능
		dto.setSubject(subject);
		dto.setContents(contents);
		dto.setFilename(filename);
		dto.setPass(pass);
		
		int row = dao.pdsWrite(dto);
		
		response.sendRedirect("pds_list.do");

	}

}

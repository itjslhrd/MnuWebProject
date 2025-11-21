package servlet.pds;

import java.io.File;
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
 * Servlet implementation class PdsModifyServlet
 */
@WebServlet("/Pds/pds_modify.do")
public class PdsModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PdsModifyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		PdsDAO dao = PdsDAO.getInstance();
		PdsDTO dto = dao.pdsSelect(idx);
		
		request.setAttribute("dto", dto);
		
		RequestDispatcher rd = request.getRequestDispatcher("pds_modify.jsp");
		rd.forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		PdsDAO dao = PdsDAO.getInstance();
		PdsDTO dto = new PdsDTO();
		
		
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

		int idx = Integer.parseInt(((FileItem)iter.next()).getString());
		String oldfilename = ((FileItem)iter.next()).getString();
		String name = ((FileItem)iter.next()).getString();
		String email = ((FileItem)iter.next()).getString();
		String subject = ((FileItem)iter.next()).getString();
		String contents = ((FileItem)iter.next()).getString();
		//파일 받기
		FileItem file = (FileItem)iter.next();
		String filename = file.getName();
		
		String pass = ((FileItem)iter.next()).getString();
		
		//dto에 세팅
		dto.setIdx(idx);
		dto.setSubject(subject);
		dto.setContents(contents);
		dto.setPass(pass);
		
		
		//파일첨부시 서버에 저장
		if(filename != null && !filename.equals("")) {
			Path path2 = Paths.get(path+filename);
			file.write(path2);
		}
		
		//첨부파일 변경시(예전파일 삭제)
		if(filename == null || filename.equals("")) {
			//파일을 변경하지 않을 경우
			dto.setFilename(oldfilename);
		}else {
			//첨부파일 변경시
			dto.setFilename(filename);
			File f1 = new File(path + oldfilename);
			if(f1.exists()) {//파일이 존재할 경우
				f1.delete();
			}
		}
		
		int row = dao.pdsModify(dto);		
		
		request.setAttribute("row", row);
		
		RequestDispatcher rd = request.getRequestDispatcher("pds_modify_pro.jsp");
		rd.forward(request, response);

	}

}

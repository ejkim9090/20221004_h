package kh.spring.s02.common.file;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

public class FileUtil {
	private final static String UPLOAD_FOLDER = "\\resources\\uploadfiles";
	/**
	 * @param multi 
	 * @param request
	 * @return : saved file path
	 */
	public String saveFile(MultipartFile multi, HttpServletRequest request, String addedPath) throws Exception{
		String renameFilePath = null;
		if(multi != null && !multi.equals("")) {
			String orginalFileName = multi.getOriginalFilename();
			
			// file을 server에 특정 위치(저장할 폴더)에 저장
			String webServerRoot = request.getSession().getServletContext().getRealPath("");
			String savePath = webServerRoot + UPLOAD_FOLDER;
			if(addedPath != null) {
				savePath += addedPath;
			}
			// 저장할 폴더가 안만들어져 있다면 만들어줘야함.
			File folder = new File(savePath);
			if(!folder.exists()) {
				folder.mkdirs();
			} 
			// 파일을 savePath 위치에 저장
			// 시간을 활용한 rename
			String renameByTime = System.currentTimeMillis() + "_"+orginalFileName;
			// UUID
			//String renameByUUID = UUID.randomUUID().toString() + "_"+orginalFileName;
			
			renameFilePath = savePath + "\\" + renameByTime;
			multi.transferTo(new File(savePath + "\\" + renameByTime));
		}
		return renameFilePath;
	}
	
}

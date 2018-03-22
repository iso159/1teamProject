package com.cafe24.iso159.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

public class FileDownloadView extends AbstractView {
	private static final Logger logger = LoggerFactory.getLogger(FileDownloadView.class);
	public FileDownloadView() {
		// content type을 지정.
		setContentType("apllication/download; charset=utf-8");
	}

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model,
					HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 맵에 담은 file을 꺼냄
		File file = (File) model.get("file");
		// 생성자를 만들면서 셋팅한 content type을 입력
		response.setContentType(getContentType());
		response.setContentLength((int) file.length());
		response.setHeader("Content-Disposition", "attachment; filename=\"" +
				java.net.URLEncoder.encode(file.getName(), "utf-8") + "\";");
		response.setHeader("Content-Transfer-Encoding", "binary");
		OutputStream out = response.getOutputStream();
		FileInputStream fis = null;

		try {
			fis = new FileInputStream(file);
			FileCopyUtils.copy(fis, out);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		out.flush();
		
		// 파일명을 확장자 붙이기 전으로 다시 되돌림
		if(request.getAttribute("reFile") != null){
			logger.debug("renderMergedOutputModel(...)메서드 실행 if 블록 성공");
            File original_file= new File(file.getPath()); //원본 경로+파일
            logger.debug("renderMergedOutputModel(...)메서드 original_file is {}",original_file);
            String file_path  = original_file.toString().replace(file.getName(),""); //path 추출
            logger.debug("renderMergedOutputModel(...)메서드 file_path is {}",file_path);
            File stored_file  = new File(file_path+request.getAttribute("fileName"));//변경 파일명
            logger.debug("renderMergedOutputModel(...)메서드 stored_file is {}",stored_file);
            original_file.renameTo(stored_file);//이름 변경
        }else {
        	logger.debug("renderMergedOutputModel(...)메서드 실행 if 블록 실패");
        }
	}
}

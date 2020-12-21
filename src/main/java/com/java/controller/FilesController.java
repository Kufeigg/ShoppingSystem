package com.java.controller;

import com.java.util.DataGridViewResult;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/files")
public class FilesController {

	/**
	 * 上传文件
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/upload")
	public DataGridViewResult upload(HttpServletRequest request) {

		String fileName = "";
		String fileMd5 = "";
		String fileSuffix = "";
		long fileSize = 0;

		//返回结果
		DataGridViewResult dataGridViewResult = new DataGridViewResult();
		// 获取当前时间
		Date date = new Date();
		// 设置显示格式
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		// 转换时间格式
		String date1 = format.format(date);
		// 获取地址内容
		String realPath = request.getSession().getServletContext().getRealPath("");// 原路径（项目名）
		// 项目截取（只适合在Nginx和php集成环境运行）
		String path = request.getContextPath();
		// 设置流的路径
		File file1 = new File(realPath + "/upload/");
		// 创建路径
		String filePath = "upload/" ;
		file1.mkdirs();

		String file_path = file1.getAbsolutePath();

		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
				request.getSession().getServletContext());
		if (multipartResolver.isMultipart(request)) {
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
			Iterator iter = multiRequest.getFileNames();
			while (iter.hasNext()) {
				MultipartFile file = multiRequest.getFile(iter.next().toString());

				if (file != null) {
					// 获取文件路径后获取文件的MD5
					CommonsMultipartFile cf = (CommonsMultipartFile) file;
					DiskFileItem fileItem = (DiskFileItem) cf.getFileItem();
					String targetFile = fileItem.getStoreLocation().toString();
					try {
						fileMd5 = DigestUtils.md5Hex(new FileInputStream(targetFile));
					} catch (Exception e) {
						fileMd5 = UUID.randomUUID().toString().replace("-", "");
					}
					System.err.println("fileMd5："+fileMd5);
					
					fileSize = file.getSize() / 1024;
					fileName = file.getOriginalFilename();
					fileSuffix = fileName.substring(fileName.lastIndexOf(".") + 1);
					try {
						file.transferTo(new File(file_path, fileMd5 + "." + fileSuffix));
					} catch (IllegalStateException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
		if (fileMd5 == null || fileMd5 == "") {
			dataGridViewResult.setMsg("上传为空");
			return dataGridViewResult;
		}
		String projectName = request.getContextPath();
		String basePath = request.getScheme() + "://" + request.getServerName()+":"+request.getServerPort()+ "/" + projectName;
		String filepath = basePath + "/" + filePath  + fileMd5 + "." + fileSuffix;// 正常项目内路径（有项目名）
		Map<String, Object>  fileInfo = new HashMap<>();
		fileInfo.put("file", filepath);
		fileInfo.put("fileSize", fileSize);
		fileInfo.put("fileName", fileName);

		dataGridViewResult.setData(fileInfo);
		return dataGridViewResult;
	}

}

package kr.or.ddit.util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileuploadUtil {

	private static final Logger logger = LoggerFactory.getLogger(FileuploadUtil.class);

	/**
	 *
	 * Method : getFilename
	 * 작성자 : PC-11
	 * 변경이력 :
	 * @param contentDisposition
	 * @return
	 * Method 설명 : Content-Disposition 헤더 문자열로 부터 파일이름 추출
	 */
	public static String getFilename(String contentDisposition) {

		// 메소드 인자  : "form-data; name\"file\"; filename=\"brown.png\"";
		String[] attrs = contentDisposition.split("; ");
		//attrs[0] = form-data
		//attrs[1] = name="file"
		//attrs[2] = filename="brown.png"

		String filename = "";
		for(String attr : attrs) {
			if(attr.startsWith("filename")) {
				String[] keyvalue = attr.split("=");
				logger.debug("keyvalue[1].indexOf(\") : {}", keyvalue[1].indexOf("\""));
				filename = keyvalue[1].substring(keyvalue[1].indexOf("\"")+1, keyvalue[1].lastIndexOf("\""));
				break;
			}
		}

		return filename;
	}

	/**
	 *
	 * Method : getFileExtension
	 * 작성자 : PC-11
	 * 변경이력 :
	 * @param contentDsipostion
	 * @return
	 * Method 설명 : Content-dispostion 헤더 문자열로 부터 파일확장자 추출 테스트
	 */
	public static String getFileExtension(String contentDsipostion) {

		String filename = getFilename(contentDsipostion);

		if(filename.lastIndexOf(".") > 0) {
			// :) 확장자 있음
			// 혜인
			//return filename.split(".")[1].substring(0, filename.split(".")[1].lastIndexOf("\""));

			// 선생님
			return filename.substring(filename.lastIndexOf("."), filename.length());
		}else {
			// :) 확장자 없음
			return "";
		}
	}

	/**
	 *
	 * Method : getPath
	 * 작성자 : PC-11
	 * 변경이력 :
	 * @return
	 * Method 설명 : 파일을 업로드 할 경로를 조회한다.
	 */
	   public static String getPath() {

	      String basicPath = "e:\\board";

	      SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
	      String yyyyMM = sdf.format(new Date());
	      String yyyy = yyyyMM.substring(0,4);
	      String mm = yyyyMM.substring(4,6);

	      File yyyyDirectory = new File(basicPath + "\\" + yyyy + "\\" + mm);
	      if(!yyyyDirectory.exists()) {
	         yyyyDirectory.mkdirs();
	      }
	      return basicPath + "\\" + yyyy + "\\" + mm + "\\";

	   }

}

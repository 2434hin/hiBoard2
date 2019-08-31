package kr.or.ddit.post.model;

public class PostFile {

	private int fileno;				// 첨부파일 번호
	private String filename;		// 업로드 파일명
	private String realfilename;	// 실제 파일경로
	private int postno;				// 게시글 번호

	public PostFile() {}
	public PostFile(String filename, String realfilename) {
		this.filename = filename;
		this.realfilename = realfilename;
	}
	public int getFileno() {
		return fileno;
	}
	public void setFileno(int fileno) {
		this.fileno = fileno;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getRealfilename() {
		return realfilename;
	}
	public void setRealfilename(String realfilename) {
		this.realfilename = realfilename;
	}
	public int getPostno() {
		return postno;
	}
	public void setPostno(int postno) {
		this.postno = postno;
	}


}

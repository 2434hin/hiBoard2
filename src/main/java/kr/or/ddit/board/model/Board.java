package kr.or.ddit.board.model;

public class Board {

	// 게시판
	private int boardno;		// 게시판 번호
	private String boardname;	// 게시판 이름
	private int useyn;			// 사용여부 (사용 0, 미사용 1)

	public Board() {}

	public Board(String boardName, int useYN) {
		this.boardname = boardName;
		this.useyn = useYN;
	}

	public int getBoardno() {
		return boardno;
	}
	public void setBoardno(int boardno) {
		this.boardno = boardno;
	}
	public String getBoardname() {
		return boardname;
	}
	public void setBoardname(String boardname) {
		this.boardname = boardname;
	}
	public int getUseyn() {
		return useyn;
	}
	public void setUseyn(int useyn) {
		this.useyn = useyn;
	}



}

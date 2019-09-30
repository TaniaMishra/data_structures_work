package assignment4;

public class DLLNode<T> {
	private T info;
	private DLLNode<T> link;
	private DLLNode<T> back;

	public DLLNode(T info) {
		this.info = info;
		link = null;
		back = null;
	}

	/**
	 * @return the info
	 */
	public T getInfo() {
		return info;
	}

	/**
	 * @param info the info to set
	 */
	public void setInfo(T info) {
		this.info = info;
	}

	/**
	 * @return the link
	 */
	public DLLNode<T> getLink() {
		return link;
	}

	/**
	 * @param link the link to set
	 */
	public void setLink(DLLNode<T> link) {
		this.link = link;
	}

	/**
	 * @return the back
	 */
	public DLLNode<T> getBack() {
		return back;
	}

	/**
	 * @param back the back to set
	 */
	public void setBack(DLLNode<T> back) {
		this.back = back;
	}

}

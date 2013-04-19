package sig.icom.userservice.model;

public class NumLikeCommentModel {
	private long numLike;
	private long numComment;
	private long numShare;
	private boolean userLike;
	
	
	public NumLikeCommentModel() {
	}

	public NumLikeCommentModel(long numLike, long numComment, long numShare,
			boolean userLike) {
		this.numLike = numLike;
		this.numComment = numComment;
		this.numShare = numShare;
		this.userLike = userLike;
	}



	public long getNumLike() {
		return numLike;
	}


	public void setNumLike(long numLike) {
		this.numLike = numLike;
	}


	public long getNumComment() {
		return numComment;
	}


	public void setNumComment(long numComment) {
		this.numComment = numComment;
	}


	public long getNumShare() {
		return numShare;
	}


	public void setNumShare(long numShare) {
		this.numShare = numShare;
	}


	public boolean isUserLike() {
		return userLike;
	}


	public void setUserLike(boolean userLike) {
		this.userLike = userLike;
	}
	
}

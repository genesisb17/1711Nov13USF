package com.ers.pojos;

public class Author
{
	private int authorId;
	private String authorName;

	public int getAuthorId()
	{
		return authorId;
	}

	public void setAuthorId(int authorId)
	{
		this.authorId = authorId;
	}

	public String getAuthorName()
	{
		return authorName;
	}

	public void setAuthorName(String authorName)
	{
		this.authorName = authorName;
	}

	@Override
	public String toString()
	{
		return "Author [id=" + authorId + ", authorName=" + authorName + "]";
	}

}

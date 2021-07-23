package it.unibo.chachingservice.entity;

import java.util.Date;

import org.bson.Document;
import org.bson.types.ObjectId;

@org.springframework.data.mongodb.core.mapping.Document(collection = "fs.files")
public class FsFiles {

	private ObjectId _id;
	private String filename;
	private long length;
	private Integer chunkSize;
	private Date uploadDate;
	private Document metadata;

	public FsFiles() {
		super();
	}

	public FsFiles(ObjectId _id, String filename, long length, Integer chunkSize, Date uploadDate, Document metadata) {
		super();
		this._id = _id;
		this.filename = filename;
		this.length = length;
		this.chunkSize = chunkSize;
		this.uploadDate = uploadDate;
		this.metadata = metadata;
	}

	public ObjectId get_id() {
		return _id;
	}

	public void set_id(ObjectId _id) {
		this._id = _id;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public long getLength() {
		return length;
	}

	public void setLength(long length) {
		this.length = length;
	}

	public Integer getChunkSize() {
		return chunkSize;
	}

	public void setChunkSize(Integer chunkSize) {
		this.chunkSize = chunkSize;
	}

	public Date getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}

	public Document getMetadata() {
		return metadata;
	}

	public void setMetadata(Document metadata) {
		this.metadata = metadata;
	}

	@Override
	public String toString() {
		return "FsFiles [_id=" + _id + ", filename=" + filename + ", length=" + length + ", chunkSize=" + chunkSize
				+ ", uploadDate=" + uploadDate + ", metadata=" + metadata + "]";
	}
}

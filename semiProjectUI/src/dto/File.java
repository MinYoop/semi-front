package dto;

//FILES 
public class File {

 // 파일번호 
 private int fileSeq;

 // 매물번호 
 private int sellNum;

 // 파일위치 
 private String filePath;

 // 파일이름 
 private String fileName;

 public int getFileSeq() {
     return fileSeq;
 }

 public void setFileSeq(int fileSeq) {
     this.fileSeq = fileSeq;
 }

 public int getSellNum() {
     return sellNum;
 }

 public void setSellNum(int sellNum) {
     this.sellNum = sellNum;
 }

 public String getFilePath() {
     return filePath;
 }

 public void setFilePath(String filePath) {
     this.filePath = filePath;
 }

 public String getFileName() {
     return fileName;
 }

 public void setFileName(String fileName) {
     this.fileName = fileName;
 }

 // FileTb 모델 복사
 public void CopyData(File param)
 {
     this.fileSeq = param.getFileSeq();
     this.sellNum = param.getSellNum();
     this.filePath = param.getFilePath();
     this.fileName = param.getFileName();
 }
}
package QQ.QQClient.qqcommon;

import javax.xml.soap.SAAJResult;
import java.io.PipedReader;
import java.io.Serializable;

@SuppressWarnings("all")
public class Message implements Serializable {
    private static final long serialVersionUID = 1L;

    private String sender;
    private String gatter;
    private String content;
    private String sendTime;
    private String mesType;

    private byte[] fileBytes;
    private int fileLen = 0;
    private String dest;
    private String src;

    public byte[] getFileBytes() {
        return fileBytes;
    }

    public void setFileBytes(byte[] fileBytes) {
        this.fileBytes = fileBytes;
    }

    public int getFileLen() {
        return fileLen;
    }

    public void setFileLen(int fileLen) {
        this.fileLen = fileLen;
    }

    public String getDest() {
        return dest;
    }

    public void setDest(String dest) {
        this.dest = dest;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getGatter() {
        return gatter;
    }

    public void setGatter(String gatter) {
        this.gatter = gatter;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    public String getMesType() {
        return mesType;
    }

    public void setMesType(String mesType) {
        this.mesType = mesType;
    }
}

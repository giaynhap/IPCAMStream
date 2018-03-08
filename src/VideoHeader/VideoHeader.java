package VideoHeader;

public class VideoHeader {

    // video format
    public short reserve;
    public int codeid;
    public short bitrate;
    public short width;
    public short height;
    public byte framerate;
    public byte colorDepth;
    public String toString()
    {
        return "codeID: "+this.codeid+", bitrate: "+this.bitrate+", width: "+this.width+", height: "+this.height+", framerate:"+this.framerate+", colorDepth: "+this.colorDepth+", reserver: "+this.reserve;
    }



}

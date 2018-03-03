package VideoHeader;

public class VideoHeader {

    // video format
    public byte videoChannel;
    public byte audioChannel;
    public byte dataType;
    public byte reserve;
    public int codeid;
    public short bitrate;
    public short width;
    public short height;
    public byte framerate;
    public byte colorDepth;

    // audio format
    public int samplesPerSecond;
    public int audioBitrate;
    public byte waveFormat;
    public short chanelNumber;
    public short chanelNumberl;
    public short blockAlign;
    public short bitsPerSample;
    public short  frameInterval;



}
